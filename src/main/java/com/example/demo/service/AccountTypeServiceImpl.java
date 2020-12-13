package com.example.demo.service;

import com.example.demo.entity.AccountType;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public AccountType findAccountTypeById(Long id) {
        return accountTypeRepository.findById(id)
                .orElseThrow(
                        () -> new IdNotFoundException(id, AccountType.class.getSimpleName()));
    }
}
