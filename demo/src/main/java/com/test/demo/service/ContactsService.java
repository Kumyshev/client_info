package com.test.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.demo.enums.ContactsType;
import com.test.demo.exception.NotFoundException;
import com.test.demo.impl.IContactsService;
import com.test.demo.model.Client;
import com.test.demo.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactsService implements IContactsService {

    private final ClientRepository clientRepository;

    @Override
    public List<String> findAllByContactType(Long id, String contactType) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client not found with ID = %s", id)));
        if (contactType != null && contactType.equals(ContactsType.email.name())) {
            return client.getEmails();
        }
        return client.getPhonenumbers();
    }
}
