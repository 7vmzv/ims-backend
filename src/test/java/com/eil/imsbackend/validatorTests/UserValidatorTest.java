package com.eil.imsbackend.validatorTests;

import com.eil.imsbackend.dto.UserDTO;
import com.eil.imsbackend.entities.Address;
import com.eil.imsbackend.validator.UserValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserValidatorTest {
    //Arrange
    UserValidator userValidator = new UserValidator();

    @Test
    public void should_throw_when_given_a_null_reference() {
        //Arrange
        List<String> expected = new ArrayList<>();

        //Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            userValidator.validate(null);
        });
    }

    @Test
    public void should_return_list_with_all_errors_messages_when_given_non_valid_entries() {
        //Arrange
        UserDTO userDTO = new UserDTO();
        Address address = new Address();
        userDTO.setAddress(address);

        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s entered is not valid", "firstname"));
        expected.add(String.format("%s entered is not valid", "lastname"));
        expected.add(String.format("%s entered is not valid", "email"));
        expected.add(String.format("%s entered is not valid", "phone number"));
        expected.add(String.format("%s entered is not valid", "address 1"));
        expected.add(String.format("%s entered is not valid", "postal code"));
        expected.add(String.format("%s entered is not valid", "country"));
        expected.add(String.format("%s entered is not valid", "city"));


        //Act
        List<String> actual = userValidator.validate(userDTO);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void should_return_list_with_non_valid_lastname_message_when_given_just_non_valid_lastname() {
        //Arrange
        UserDTO userDTO = new UserDTO();
        Address address = new Address("174 rue michel ange", null, "Calais", "62100", "France");
        userDTO.setAddress(address);


        userDTO.setPhoneNumber("098765432456");
        userDTO.setEmail("hamza@hamza.ma");
        userDTO.setFirstname("hamza");

        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s entered is not valid", "lastname"));

        //act
        List<String> actual = userValidator.validate(userDTO);
        actual.forEach((s) -> {
            System.out.println(s);
        });
        //assert
        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void should_throw_when_given_null_userDTO_ref(){
        //act & assert
        Assertions.assertThrows(NullPointerException.class, () -> {
           userValidator.validate(null);
        });
    }

    @Test
    public void should_throw_when_given_null_address_ref(){

        UserDTO userDTO = new UserDTO();

        userDTO.setPhoneNumber("098765432456");
        userDTO.setEmail("hamza@hamza.ma");
        userDTO.setFirstname("hamza");
        userDTO.setLastname("hamza");

        //act & assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            userValidator.validate(userDTO);
        });
    }
}
