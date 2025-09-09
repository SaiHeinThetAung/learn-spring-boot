package com.testdemo.eazy.controller;


import com.testdemo.eazy.model.Customer;
import com.testdemo.eazy.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        try{
           String hashPwd=passwordEncoder.encode(customer.getPwd());
           customer.setPwd(hashPwd);
           Customer saveCustomer=customerRepository.save(customer);
           if(saveCustomer.getId()>0){
               return ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully registered!");
           }
           else {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
           }

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
