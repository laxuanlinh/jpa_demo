package com.example.jpademo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String address;

    @JsonBackReference
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private Set<Person> personSet;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }
}
