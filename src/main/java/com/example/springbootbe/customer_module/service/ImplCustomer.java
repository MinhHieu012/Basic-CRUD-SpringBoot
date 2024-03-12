package com.example.springbootbe.customer_module.service;

import com.example.springbootbe.customer_module.entity.CustomerEntity;
import com.example.springbootbe.customer_module.entity.CustomerRequest;
import com.example.springbootbe.customer_module.entity.CustomerResponse;
import com.example.springbootbe.customer_module.entity.ResponseApi;
import com.example.springbootbe.customer_module.mapping.CustomerMapping;
import com.example.springbootbe.customer_module.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImplCustomer implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public ResponseApi getCustomer() {
        try {
            List<CustomerEntity> customerEntityList = customerRepository.findAll();
            List<CustomerResponse> customerResponseList = customerEntityList
                    .stream()
                    .map(CustomerMapping::mapEntityToResponse)
                    .collect(Collectors.toList());
            return new ResponseApi(true, "Get Customer Data Successfully", customerEntityList);
        } catch (Exception e) {
            return new ResponseApi(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseApi addCustomer(CustomerRequest customerRequest) {
        try {
            CustomerEntity customerEntity = CustomerMapping.mapRequestToEntity(customerRequest);
            customerRepository.save(customerEntity);
            return new ResponseApi(true, "Create Customer Data Successfully", customerEntity);
        } catch (Exception e) {
            return new ResponseApi(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseApi updateCustomer(Long id, CustomerRequest customerRequest) {
        try {
            CustomerEntity customerEntity = customerRepository.findById(id).get();
            customerEntity.setName(customerRequest.getName());
            customerEntity.setAddress(customerRequest.getAddress());
            customerEntity.setPhone(customerRequest.getPhone());
            customerRepository.save(customerEntity);
            return new ResponseApi(true, "Update Customer Data Successfully", customerEntity);
        } catch (Exception e) {
            return new ResponseApi(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseApi deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return new ResponseApi(true, "Delete Customer Data Successfully", null);
        } catch (Exception e) {
            return new ResponseApi(false, e.getMessage(), null);
        }
    }
}
