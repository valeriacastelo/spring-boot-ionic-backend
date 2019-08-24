package com.nelioalves.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.backend.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
