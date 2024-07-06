package com.banking.Banking_application.repository;


import com.banking.Banking_application.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users,Long> {
    Boolean existsByEmail(String email);
    Optional<UserDetails> findByEmail(String email);

    Boolean existsByAccountNumber(String accountNumber);

    Users findByAccountNumber(String accountNumber);

}
