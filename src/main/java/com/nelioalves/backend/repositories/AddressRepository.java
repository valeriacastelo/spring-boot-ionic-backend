package com.nelioalves.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.backend.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
