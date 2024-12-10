package com.test.demo.dto;

import com.test.demo.validator.ValidPhoneNumber;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientDto {
    private String name;
    @ValidPhoneNumber
    private String phonenumber;
    @Email
    private String email;
}
