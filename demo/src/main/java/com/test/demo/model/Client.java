package com.test.demo.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "client")
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_name")
    private String Name;

    @ElementCollection
    @CollectionTable(name = "phonenumbers", joinColumns = @JoinColumn(name = "client_id"))
    @Column(name = "phonenumber", unique = true)
    private List<String> phonenumbers;

    @ElementCollection
    @CollectionTable(name = "emails", joinColumns = @JoinColumn(name = "client_id"))
    @Column(name = "email", unique = true)
    private List<String> emails;
}
