package com.wintech.wtclientservice.services;

import com.wintech.wtclientservice.domains.Address;
import com.wintech.wtclientservice.dtos.AddressDto;
import com.wintech.wtclientservice.dtos.ClientDto;
import com.wintech.wtclientservice.repositories.AddressRepository;
import com.wintech.wtclientservice.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.wintech.wtclientservice.mapper.EntityMapper.convertToDto;
import static com.wintech.wtclientservice.mapper.EntityMapper.convertToEntity;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public ClientDto insert(AddressDto addressDto, ClientDto clientDto){
        Address address = convertD




    }
}
