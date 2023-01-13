package com.eil.imsbackend.validator;

import com.eil.imsbackend.dto.UserDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public List<String> validate(UserDTO userDTO) {
        List<String> errors = new ArrayList<>();

        if(userDTO == null) {
            throw new NullPointerException("DTO ref passed is null");
        } else {
            if(!StringUtils.hasLength(userDTO.getFirstname()) || !userDTO.getFirstname().matches("[A-Za-z]*")){
                errors.add(String.format("%s entered is not valid", "firstname"));
            }

            if(!StringUtils.hasLength(userDTO.getLastname()) || !userDTO.getLastname().matches("[A-Za-z]*")){
                errors.add(String.format("%s entered is not valid", "lastname"));
            }

            if(!StringUtils.hasLength(userDTO.getEmail()) || !userDTO.getEmail().matches(".*@.*\\..*")){
                errors.add(String.format("%s entered is not valid", "email"));
            }

            if(!StringUtils.hasLength(userDTO.getEmail()) || !userDTO.getPhoneNumber().matches("\\d*")){
                errors.add(String.format("%s entered is not valid", "phone number"));
            }

            if (userDTO.getAddress() == null) {
                throw new NullPointerException("Address ref passed is null");
            } else{
                if(!StringUtils.hasLength(userDTO.getAddress().getAddress1()) || !userDTO.getAddress().getAddress1().matches("[A-Za-z\\d ]*")){
                    errors.add(String.format("%s entered is not valid", "address 1"));
                }

                if(StringUtils.hasLength(userDTO.getAddress().getAddress2()) && !userDTO.getAddress().getAddress2().matches("[A-Za-z\\d ]*")){
                    errors.add(String.format("%s entered is not valid", "address 2"));
                }

                if(!StringUtils.hasLength(userDTO.getAddress().getCity()) || !userDTO.getAddress().getCity().matches("[A-Za-z]*")){
                    errors.add(String.format("%s entered is not valid", "city"));
                }

                if(!StringUtils.hasLength(userDTO.getAddress().getCountry()) ||!userDTO.getAddress().getCountry().matches("[A-Za-z]*")){
                    errors.add(String.format("%s entered is not valid", "country"));
                }

                if(!StringUtils.hasLength(userDTO.getAddress().getPostalCode()) ||!userDTO.getAddress().getPostalCode().matches("\\d*")){
                    errors.add(String.format("%s entered is not valid", "postal code"));
                }
            }
        }
        return errors;
    }
}
