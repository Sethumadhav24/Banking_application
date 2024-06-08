package com.banking.Banking_application.service;

import com.banking.Banking_application.dto.AccountInfo;
import com.banking.Banking_application.dto.BankResponse;
import com.banking.Banking_application.dto.EmailDetails;
import com.banking.Banking_application.dto.UserRequest;
import com.banking.Banking_application.entity.Users;
import com.banking.Banking_application.repository.UserRepository;
import com.banking.Banking_application.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail())){

            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        Users newUser = Users.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alterNativePhoneNumber(userRequest.getAlterNativePhoneNumber())
                .status("ACTIVE")
                .build();

        Users saverUser = userRepository.save(newUser);
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(saverUser.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("Congratulations! Yur Account Has Been Successfully Created.\nYour Account Details: \n" +
                        "Account Name: " + saverUser.getFirstName() + " " + saverUser.getLastName() + " " + saverUser.getOtherName() + "\nAccount Number" + saverUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(saverUser.getAccountBalance())
                        .accountNumber(saverUser.getAccountNumber())
                        .accountName(saverUser.getFirstName() + " " + saverUser.getLastName() + " " + saverUser.getOtherName())
                        .build())
                .build();
    }
}
