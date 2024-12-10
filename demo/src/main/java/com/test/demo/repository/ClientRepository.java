package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
