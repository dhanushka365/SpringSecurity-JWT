package com.example.SpringSecurity.JWT.repository;

import com.example.SpringSecurity.JWT.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}