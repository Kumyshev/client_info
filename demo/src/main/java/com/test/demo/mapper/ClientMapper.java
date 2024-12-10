package com.test.demo.mapper;

import org.springframework.stereotype.Component;

import com.test.demo.dto.ClientDto;
import com.test.demo.model.Client;

@Component
public class ClientMapper {

    public ClientDto toClientDto(Client client) {
        return new ClientDto(client.getName(), client.getPhonenumbers(), client.getEmails());
    }
}
