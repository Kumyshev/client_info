package com.test.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.impl.IContactsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@RestController
@RequestMapping(value = "/clients/{id}/contacts")
@RequiredArgsConstructor
public class ContactsController {

    private final IContactsService contactsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<String> findAllByContactType(@PathVariable Long id,
            @RequestParam(required = false) String contactType) {
        log.info("Получение списка контактов (заданного типа) заданного клиента");
        return contactsService.findAllByContactType(id, contactType);
    }

}
