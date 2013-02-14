package com.me.testproject.server.repositories;

import org.springframework.data.repository.CrudRepository;

import com.me.testproject.server.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
