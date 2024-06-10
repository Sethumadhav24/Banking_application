package com.banking.Banking_application.service;

import com.banking.Banking_application.dto.BankResponse;
import com.banking.Banking_application.dto.CreditDebitRequest;
import com.banking.Banking_application.dto.EnquiryRequest;
import com.banking.Banking_application.dto.UserRequest;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);

    BankResponse balanceEnquiry(EnquiryRequest request);

    String nameEnquiry(EnquiryRequest request);

    BankResponse creditAccount(CreditDebitRequest request);

    BankResponse debitAccount(CreditDebitRequest request);
}
