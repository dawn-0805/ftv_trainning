package com.ftvtraining.api;


import com.ftvtraining.dto.ContractDto;
import com.ftvtraining.enity.ContractEntity;
import com.ftvtraining.service.IContractService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200" )
@RestController
@RequestMapping("/api/contract")
public class ContractApi {

    private  final IContractService contactService;

    @Autowired
    public ContractApi(IContractService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<ContractDto> list = contactService.findAll();
        if (list.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getContract(@PathVariable Integer id) throws NotFoundException {
        ContractDto contractDto = contactService.findById(id);
        if (contractDto == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDto,HttpStatus.OK);
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<?> findByPage(@PathVariable(name = "pageNum") int pageNum,
                                         @PathVariable(name = "pageSize") int pageSize,
                                            @RequestParam(name = "sortField" , required = false) String sortField,
                                            @RequestParam(name = "sortDir" , required = false) String sortDir,
                                            @RequestParam(name = "keyword" , defaultValue = "") String keyword){
        Page<ContractEntity> entities = contactService.listByPage(pageNum,pageSize,sortField,sortDir,keyword);
        if (entities.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(entities,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ContractEntity> createContract( @Valid @RequestBody ContractEntity newContract) throws NotFoundException {
        ContractEntity contract = contactService.save(newContract);
//        return  ResponseEntity.ok(contactService.save(newContract));
        return  new ResponseEntity<>(contract,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ContractEntity> updateContract(@RequestBody ContractEntity entity) throws NotFoundException {
        return  ResponseEntity.ok(contactService.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomers(@PathVariable(name = "id") Integer id){
        contactService.delete(id);
        return ResponseEntity.ok("Delete Success");
    }

}
