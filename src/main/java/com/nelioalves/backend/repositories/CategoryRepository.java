package com.nelioalves.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.backend.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
