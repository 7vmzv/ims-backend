package com.eil.imsbackend.services;

import com.eil.imsbackend.dto.CustomerOrderDTO;

import java.util.List;

public interface CustomerOrderService {
    CustomerOrderDTO save(CustomerOrderDTO customerOrderDTO);

    CustomerOrderDTO findById(Integer id);

    CustomerOrderDTO findByCode(String code);

    List<CustomerOrderDTO> findAll();

}
