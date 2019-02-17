package com.example.jpademo.controllers;

import com.example.jpademo.DTO.PersonDTO;
import com.example.jpademo.models.Address;
import com.example.jpademo.models.Person;
import com.example.jpademo.repositories.AddressRepository;
import com.example.jpademo.services.PersonService;
import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{name}")
    public List<PersonDTO> getPerson(@PathVariable("name") String name){

        List<Person> personList = personService.getPersonByName(name);
        List<PersonDTO> dtos = Lists.newArrayList();
        for (Person person : personList)
            dtos.add(modelMapper.map(person, PersonDTO.class));
        return dtos;
    }

    @GetMapping("/address/{address}")
    public Address getAddress(@PathVariable("address") String address){
        return addressRepository.findByAddress(address).get();
    }
}
