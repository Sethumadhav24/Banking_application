package com.banking.Banking_application.controller;

import com.banking.Banking_application.dto.*;
import com.banking.Banking_application.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Account Management APIs")
public class UserController {

    @Autowired
    UserService userService;


    @Operation(
            summary = "Create New User Account",
            description = "Creating a new User and assigning an account ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }


    @Operation(
            summary = "Balance Enquiry",
            description = "Given an account number, check how much the user has"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }


    @Operation(
            summary = "Name Enquiry",
            description = "Given an account number, result the name of the account number"
    )
    @ApiResponse(
            responseCode = "202",
            description = "HTTP Status 202 SUCCESS"
    )
    @GetMapping("nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

    @Operation(
            summary = "Credit",
            description = "Given an account number and amount, and Credit from respected  user "
    )
    @ApiResponse(
            responseCode = "203",
            description = "HTTP Status 203 SUCCESS"
    )
    @PostMapping("credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
        return userService.creditAccount(request);
    }

    @Operation(
            summary = "Debit",
            description = "Given an account number and amount , Debit the amount to respected user"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 SUCCESS"
    )
    @PostMapping("debit")
    public BankResponse debitAmount(@RequestBody CreditDebitRequest request){
        return userService.debitAccount(request);
    }

    @Operation(
            summary = "Transfer",
            description = "Transferring the amount form Credit account to Debit account"
    )
    @ApiResponse(
            responseCode = "205",
            description = "HTTP Status 200 SUCCESS"
    )
    @PostMapping("transfer")
    public BankResponse transfer(@RequestBody TransferRequest request){
        return userService.transfer(request);
    }

}
