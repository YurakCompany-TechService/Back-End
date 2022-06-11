package com.yurakcompany.demo.register.service;

import com.yurakcompany.demo.register.domain.model.Technician;
import com.yurakcompany.demo.register.domain.persistence.TechnicianRepository;
import com.yurakcompany.demo.register.domain.service.TechnicianService;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class TechnicianServiceImpl implements TechnicianService {

    private static final String ENTITY = "Technician";
    private final TechnicianRepository technicianRepository;

    private final Validator validator;
    public TechnicianServiceImpl(TechnicianRepository technicianRepository, Validator validator) {
        this.technicianRepository = technicianRepository;
        this.validator = validator;
    }

    @Override
    public Technician getById(Long id) {
        return technicianRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Technician create(Technician technician) {
        Set<ConstraintViolation<Technician>>violations = validator.validate(technician);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return technicianRepository.save(technician);
    }
    @Override
    public Technician getAccount(String email, String password){
        return technicianRepository.findByEmailAndPassword(email, password);
    }
}
