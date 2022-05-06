package com.ftvtraining.api;


import com.ftvtraining.config.JwtTokenProvider;
import com.ftvtraining.dto.UserDto;
import com.ftvtraining.dto.request.JwtRequest;
import com.ftvtraining.dto.request.TokenRefreshRequest;
import com.ftvtraining.dto.response.JwtResponse;
import com.ftvtraining.dto.response.TokenRefreshResponse;
import com.ftvtraining.enity.RefreshToken;
import com.ftvtraining.service.IRefreshTokenService;
import com.ftvtraining.service.IUserService;
import com.ftvtraining.service.impl.CustomUserDetailsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserApi {
	
    private UserDetails userDetails;
	
    private final IUserService userService;

    @Autowired
    public UserApi(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenUtil;

    
    @Autowired
    private IRefreshTokenService refreshToken;


    @GetMapping()
    List<UserDto> getUser(@RequestParam Optional<Integer> pageNumber , @RequestParam Optional<String> sortBy){
         return  userService.findByPage(pageNumber,sortBy);
    }


    @GetMapping("/{userId}")
    public UserDto findOneById(@PathVariable("userId") Integer userId) throws NotFoundException {
        return userService.findById(userId);
    }


    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return  ResponseEntity.ok(userService.save(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUsers(@PathVariable("userId") Integer userId, @RequestBody UserDto userDTO) throws NotFoundException {
        return ResponseEntity.ok(userService.update(userId, userDTO));
    }

    @DeleteMapping("/{userId}")
    public void deleteUsers(@PathVariable("userId") Integer userId) throws NotFoundException {
        userService.deleteUser(userId);
    }

    /* Authentication */
   @PostMapping("/authenticate")
   public  ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest ) throws Exception {

       authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        userDetails = userDetailsService
               .loadUserByUsername(jwtRequest.getUsername());
       String token = jwtTokenUtil.generateTokenForUserName(userDetails.getUsername());
       List<String> roles = userDetails.getAuthorities().stream()
               .map(item -> item.getAuthority())
               .collect(Collectors.toList());
       System.out.println("Expiration :"+jwtTokenUtil.getExpirationDateFromToken(token));
       RefreshToken rfToken = refreshToken.createRefreshToken(userDetails.getUsername());
       System.out.println("Refresh Expiration:"+ rfToken.getExpiryDate());
       return ResponseEntity.ok(new JwtResponse(token,rfToken.getRefreshToken(),userDetails.getUsername(),roles));
   }

   
   @PostMapping("/refreshtoken")
   public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest refreshRequest ){
	try {
		   String requestRefreshToken = refreshRequest.getRefreshToken();
		   String token = jwtTokenUtil.generateTokenForUserName(userDetails.getUsername());
		   
	       return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
	}catch (Exception e) {
		throw new RuntimeException(e.getMessage());
	}
	 
   }
   

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
