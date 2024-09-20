package com.springboot.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.banking.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
