package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Country;
//@Repository this annotation is no need to use why because JpaRepository interface will automatically take this page is Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{

}
