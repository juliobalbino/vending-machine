package com.bd.vendingMachine.service;

import com.bd.vendingMachine.model.User;
import com.bd.vendingMachine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.SocketException;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private GetMacAddressService getMac;


    public User insert(User obj) throws SocketException {
        obj.setId(null);
        obj.setMac(getMac.getMacAddress());
        obj = repository.save(obj);
        return obj;
    }
}
