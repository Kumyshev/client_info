package com.test.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.dto.ClientDto;
import com.test.demo.dto.NewClientDto;
import com.test.demo.dto.UpdateClientDto;
import com.test.demo.impl.IClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping(value = "/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> findAll() {
        log.info("Получение списка клиентов");
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto findById(@PathVariable Long id) {
        log.info("Получение информации по заданному клиенту (по id)");
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto saveClient(@Valid @RequestBody NewClientDto newClientDto) {
        log.info("Добавление нового клиента");
        return clientService.saveClient(newClientDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClientDto updateClient(@PathVariable Long id, @Valid @RequestBody UpdateClientDto updateClientDto) {
        log.info("Добавление нового контакта клиента (телефон или email)");
        return clientService.updateClient(id, updateClientDto);
    }

}
