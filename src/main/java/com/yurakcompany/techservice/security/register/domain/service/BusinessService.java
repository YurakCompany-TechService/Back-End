package com.yurakcompany.techservice.security.register.domain.service;

import com.yurakcompany.techservice.security.register.domain.model.Business;

public interface BusinessService {
    Business getById(Long id);
    Business create(Business business);

    Business getAccount(String email, String password);
}
