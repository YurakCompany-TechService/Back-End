package com.yurakcompany.demo.security.register.domain.service;

import com.yurakcompany.demo.security.register.domain.model.Business;

public interface BusinessService {
    Business getById(Long id);
    Business create(Business business);

    Business getAccount(String email, String password);
}
