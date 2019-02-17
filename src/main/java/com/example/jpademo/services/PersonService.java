package com.example.jpademo.services;

import com.example.jpademo.models.Address;
import com.example.jpademo.repositories.AddressRepository;
import com.example.jpademo.repositories.PersonRepository;
import com.example.jpademo.models.Person;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository,
                         AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public List<Person> getPersonByName(String name){
        return personRepository.findByName(name);
    }

    public Set<Person> getPersonSetByAddress(String address){
        Optional<Address> addressOptional= addressRepository.findByAddress(address);
        return addressOptional.isPresent() ?
                personRepository.findByAddress(addressOptional.get()) :
                Sets.newHashSet();
    }

}
