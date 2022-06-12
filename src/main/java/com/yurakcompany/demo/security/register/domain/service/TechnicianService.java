package com.yurakcompany.demo.security.register.domain.service;

import com.yurakcompany.demo.security.register.domain.model.Technician;

public interface TechnicianService {
    Technician getById(Long id);
    Technician create(Technician technician);

    Technician getAccount(String email, String password);
}
