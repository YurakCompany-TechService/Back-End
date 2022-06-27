package com.yurakcompany.techservice.security.register.domain.service;

import com.yurakcompany.techservice.security.register.domain.model.Technician;

public interface TechnicianService {
    Technician getById(Long id);
    Technician create(Technician technician);

    Technician getAccount(String email, String password);
}
