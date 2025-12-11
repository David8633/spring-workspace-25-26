package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Integer> {

}
