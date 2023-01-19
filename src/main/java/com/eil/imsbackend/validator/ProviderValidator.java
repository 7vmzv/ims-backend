package com.eil.imsbackend.validator;

import com.eil.imsbackend.dto.ProviderDTO;
import com.eil.imsbackend.dto.UserDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProviderValidator {
    public List<String> validate(ProviderDTO providerDTO) {
        List<String> errors = new ArrayList<>();

        if(providerDTO == null) {
            throw new NullPointerException("DTO ref passed is null");
        } else {
            if(!StringUtils.hasLength(providerDTO.getFirstname()) || !providerDTO.getFirstname().matches("[A-Za-z]*")){
                errors.add(String.format("%s entered is not valid", "firstname"));
            }

            if(!StringUtils.hasLength(providerDTO.getLastname()) || !providerDTO.getLastname().matches("[A-Za-z]*")){
                errors.add(String.format("%s entered is not valid", "lastname"));
            }

            if(!StringUtils.hasLength(providerDTO.getEmail()) || !providerDTO.getEmail().matches(".*@.*\\..*")){
                errors.add(String.format("%s entered is not valid", "email"));
            }

            if(!StringUtils.hasLength(providerDTO.getEmail()) || !providerDTO.getPhoneNumber().matches("\\d*")){
                errors.add(String.format("%s entered is not valid", "phone number"));
            }

            if (providerDTO.getAddress() == null) {
                throw new NullPointerException("Address ref passed is null");
            } else{
                if(!StringUtils.hasLength(providerDTO.getAddress().getAddress1()) || !providerDTO.getAddress().getAddress1().matches("[A-Za-z\\d ]*")){
                    errors.add(String.format("%s entered is not valid", "address 1"));
                }

                if(StringUtils.hasLength(providerDTO.getAddress().getAddress2()) && !providerDTO.getAddress().getAddress2().matches("[A-Za-z\\d ]*")){
                    errors.add(String.format("%s entered is not valid", "address 2"));
                }

                if(!StringUtils.hasLength(providerDTO.getAddress().getCity()) || !providerDTO.getAddress().getCity().matches("[A-Za-z]*")){
                    errors.add(String.format("%s entered is not valid", "city"));
                }

                if(!StringUtils.hasLength(providerDTO.getAddress().getCountry()) ||!providerDTO.getAddress().getCountry().matches("[A-Za-z]*")){
                    errors.add(String.format("%s entered is not valid", "country"));
                }

                if(!StringUtils.hasLength(providerDTO.getAddress().getPostalCode()) ||!providerDTO.getAddress().getPostalCode().matches("\\d*")){
                    errors.add(String.format("%s entered is not valid", "postal code"));
                }
            }
        }
        return errors;
    }
}
