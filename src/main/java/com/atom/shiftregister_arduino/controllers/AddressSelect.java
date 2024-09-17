package com.atom.shiftregister_arduino.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atom.shiftregister_arduino.service.Address;


@RestController
@RequestMapping(value = "/address")
public class AddressSelect {
    private final Address address;

    @Autowired
    public AddressSelect(Address address) {
        this.address = address;
    }

     @GetMapping("/")
  public String index(@RequestParam String query) throws IOException {
    address.address(query);
		return "Greetings from Spring Boot!" + query;
	}

}
