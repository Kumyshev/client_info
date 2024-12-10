package com.test.demo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String name;
    private List<String> phonenumbers = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
}
