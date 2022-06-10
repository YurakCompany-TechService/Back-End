package com.yurakcompany.demo.register.domain.service;

import com.yurakcompany.demo.register.domain.model.Business;

public interface BusinessService {
    Business getById(Long id);
    Business create(Business business);
}
