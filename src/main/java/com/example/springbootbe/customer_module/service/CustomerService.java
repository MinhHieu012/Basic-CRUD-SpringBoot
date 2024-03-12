package com.example.springbootbe.customer_module.service;

import com.example.springbootbe.customer_module.entity.CustomerRequest;
import com.example.springbootbe.customer_module.entity.ResponseApi;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    ResponseApi getCustomer();
    ResponseApi addCustomer(CustomerRequest customerRequest);
    ResponseApi updateCustomer(Long id, CustomerRequest customerRequest);
    ResponseApi deleteCustomer(Long id);
}
