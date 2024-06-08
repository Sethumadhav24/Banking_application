package com.banking.Banking_application.service;

import com.banking.Banking_application.dto.BankResponse;
import com.banking.Banking_application.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
