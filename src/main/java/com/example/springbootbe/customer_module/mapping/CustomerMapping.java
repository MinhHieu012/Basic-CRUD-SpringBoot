package com.example.springbootbe.customer_module.mapping;

import com.example.springbootbe.customer_module.entity.CustomerEntity;
import com.example.springbootbe.customer_module.entity.CustomerRequest;
import com.example.springbootbe.customer_module.entity.CustomerResponse;
import lombok.Data;

@Data
public class CustomerMapping {
    public static CustomerEntity mapRequestToEntity (CustomerRequest customerRequest) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerRequest.getName());
        customerEntity.setAddress(customerRequest.getAddress());
        customerEntity.setPhone(customerRequest.getPhone());
        return customerEntity;
    }
    public static CustomerResponse mapEntityToResponse (CustomerEntity customerEntity) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customerEntity.getId());
        customerResponse.setName(customerEntity.getName());
        customerResponse.setAddress(customerEntity.getAddress());
        customerResponse.setPhone(customerEntity.getPhone());
        return customerResponse;
    }
}
