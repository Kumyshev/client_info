package com.test.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.demo.dto.ClientDto;
import com.test.demo.dto.NewClientDto;
import com.test.demo.dto.UpdateClientDto;
import com.test.demo.exception.NotFoundException;
import com.test.demo.impl.IClientService;
import com.test.demo.mapper.ClientMapper;
import com.test.demo.model.Client;
import com.test.demo.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toClientDto)
                .toList();
    }

    @Override
    public ClientDto saveClient(NewClientDto newClientDto) {
        Client client = new Client();
        client.setName(newClientDto.getName());
        client.setPhonenumbers(Arrays.asList(newClientDto.getPhonenumber()));
        client.setEmails(Arrays.asList(newClientDto.getEmail()));
        return clientMapper.toClientDto(clientRepository.save(client));
    }

    @Override
    public ClientDto updateClient(Long id, UpdateClientDto updateClientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client not found with ID = %s", id)));
        if (updateClientDto.getName() != null)
            client.setName(updateClientDto.getName());
        if (updateClientDto.getPhonenumber() != null)
            client.getPhonenumbers().add(updateClientDto.getPhonenumber());
        if (updateClientDto.getEmail() != null)
            client.getEmails().add(updateClientDto.getEmail());
        return clientMapper.toClientDto(clientRepository.save(client));
    }

    @Override
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client not found with ID = %s", id)));
        return clientMapper.toClientDto(client);
    }
}
