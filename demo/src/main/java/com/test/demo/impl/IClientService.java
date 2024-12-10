package com.test.demo.impl;

import java.util.List;

import com.test.demo.dto.ClientDto;
import com.test.demo.dto.NewClientDto;
import com.test.demo.dto.UpdateClientDto;

public interface IClientService {

    List<ClientDto> findAll();

    ClientDto findById(Long id);

    ClientDto saveClient(NewClientDto newClientDto);

    ClientDto updateClient(Long id, UpdateClientDto updateClientDto);
}
