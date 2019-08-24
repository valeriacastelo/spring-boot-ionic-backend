package com.nelioalves.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.backend.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
