package com.banking.Banking_application.service;

import com.banking.Banking_application.dto.TransactionDto;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
