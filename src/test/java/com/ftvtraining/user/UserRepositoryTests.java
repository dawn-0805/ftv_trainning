package com.ftvtraining.user;


import com.ftvtraining.enity.UserEntity;
import com.ftvtraining.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public  void testCreateOneUsers(){
       UserEntity user = new UserEntity(4202,"dang","active");
       UserEntity saveUser = userRepository.save(user);
       assertThat(saveUser.getUserId()).isGreaterThan(0);

    }

    @Test
    public  void testGetUserById(){
        UserEntity user = userRepository.findById(4202).get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    public  void testListAllUsers(){
        Iterable<UserEntity> listUserEntities = userRepository.findAll();
        listUserEntities.forEach(userEntity -> System.out.println(userEntity));
    }

    @Test
    public  void testUpdateUserDetails(){
        UserEntity user = userRepository.findById(4202).get();
        user.setUserName("dawn");
        user.setUserStatus("inactive");
        userRepository.save(user);
    }

    @Test
    public  void testDeleteUser(){
        Integer userId = 4202;
        userRepository.deleteById(userId);
    }

}
