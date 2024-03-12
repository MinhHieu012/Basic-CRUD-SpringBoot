package com.example.springbootbe.customer_module.controller;

import com.example.springbootbe.customer_module.entity.CustomerRequest;
import com.example.springbootbe.customer_module.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity<?> getCustomer() {
        return new ResponseEntity<>(customerService.getCustomer(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest) {
        return new ResponseEntity<>(customerService.addCustomer(customerRequest), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customerRequest), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
