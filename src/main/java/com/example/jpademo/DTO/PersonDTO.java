package com.example.jpademo.DTO;

import com.example.jpademo.models.Address;
import com.example.jpademo.models.Person;

public class PersonDTO {

    private Integer id;
    private String name;
    private Address address;

    public PersonDTO() {
    }

    public PersonDTO(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public PersonDTO(Person person){
        this(person.getId(), person.getName(), person.getAddress());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
