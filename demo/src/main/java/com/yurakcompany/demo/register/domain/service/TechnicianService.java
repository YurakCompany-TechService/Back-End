package com.yurakcompany.demo.register.domain.service;

import com.yurakcompany.demo.register.domain.model.Technician;
import com.yurakcompany.demo.register.domain.persistence.TechnicianRepository;

import java.util.List;

public interface TechnicianService {
    Technician getById(Long id);
    Technician create(Technician technician);
}
