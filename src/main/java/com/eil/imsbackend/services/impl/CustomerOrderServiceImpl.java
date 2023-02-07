package com.eil.imsbackend.services.impl;

import com.eil.imsbackend.dto.CustomerOrderDTO;
import com.eil.imsbackend.dto.CustomerOrderLineDTO;
import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.Customer;
import com.eil.imsbackend.entities.CustomerOrder;
import com.eil.imsbackend.entities.CustomerOrderLine;
import com.eil.imsbackend.exception.ErrorCodes;
import com.eil.imsbackend.exception.IllegalBusinessException;
import com.eil.imsbackend.exception.InvalidEntityException;
import com.eil.imsbackend.repository.ArticleRepository;
import com.eil.imsbackend.repository.CustomerOrderLineRepository;
import com.eil.imsbackend.repository.CustomerOrderRepository;
import com.eil.imsbackend.repository.CustomerRepository;
import com.eil.imsbackend.services.CustomerOrderService;
import com.eil.imsbackend.validator.CustomerOrderLineValidator;
import com.eil.imsbackend.validator.CustomerOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {
    private final CustomerOrderLineRepository customerOrderLineRepository;
    private CustomerOrderRepository customerOrderRepository;
    private CustomerRepository customerRepository;
    private ArticleRepository articleRepository;
    private CustomerOrderLineValidator customerOrderLineValidator;

    private CustomerOrderValidator customerOrderValidator;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository, ArticleRepository articleRepository, CustomerOrderLineValidator customerOrderLineValidator, CustomerOrderValidator customerOrderValidator,
                                    CustomerOrderLineRepository customerOrderLineRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.articleRepository = articleRepository;
        this.customerOrderLineValidator = customerOrderLineValidator;
        this.customerOrderValidator = customerOrderValidator;
        this.customerOrderLineRepository = customerOrderLineRepository;
    }

    @Override
    public CustomerOrderDTO save(CustomerOrderDTO customerOrderDTO) {
        List<String> errors = customerOrderValidator.validate(customerOrderDTO);
        if(!errors.isEmpty()) {
            log.error("Customer order is not valid", customerOrderDTO);
            throw new InvalidEntityException("Customer order is not valid", ErrorCodes.CUSTOMER_ORDER_NOT_VALID, errors);
        }

        Optional<Customer> customer = customerRepository.findById(customerOrderDTO.getCustomer().getId());
        if(!customer.isPresent()) {
            log.warn(String.format("Client with id = %d is not present in database !", customerOrderDTO.getCustomer().getId()));
            throw new IllegalBusinessException(String.format("You can't save a customer order of NON EXIST CUSTOMER !", customerOrderDTO.getCustomer().getId()));
        }

        List<String> articleErrors = new ArrayList<>();

        if(customerOrderDTO.getCustomerOrderLines() != null) {
            customerOrderDTO.getCustomerOrderLines().forEach(customerOrderLineDTO -> {
                Optional<Article> article = articleRepository.findById(customerOrderLineDTO.getArticle().getId());
                if(article.isEmpty()) {
                    articleErrors.add(String.format("There is no article with id = %d", customerOrderLineDTO.getArticle().getId()));
                }
            });

            if(!articleErrors.isEmpty()) {
                log.warn("Article does not exits in Database !");
                throw new IllegalBusinessException("Article does not exits in Database !");
            }
        }

        CustomerOrder customerOrder = customerOrderRepository.save(CustomerOrderDTO.toEntity(customerOrderDTO));

        customerOrderDTO.getCustomerOrderLines().forEach(customerOrderLineDTO -> {
            CustomerOrderLine customerOrderLine = CustomerOrderLineDTO.toEntity(customerOrderLineDTO);
            customerOrderLine.setCustomerOrder(customerOrder);
        });
        return CustomerOrderDTO.fromEntity(customerOrder);
    }

    @Override
    public CustomerOrderDTO findById(Integer id) {
        return null;
    }

    @Override
    public CustomerOrderDTO findByCode(String code) {
        return null;
    }

    @Override
    public List<CustomerOrderDTO> findAll() {
        return null;
    }
}
