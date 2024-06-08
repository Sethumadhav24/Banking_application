package com.banking.Banking_application.repository;


import com.banking.Banking_application.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users,Long> {
    Boolean existsByEmail(String email);

}
