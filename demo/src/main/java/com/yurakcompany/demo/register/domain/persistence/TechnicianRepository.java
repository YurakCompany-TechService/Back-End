package com.yurakcompany.demo.register.domain.persistence;

import com.yurakcompany.demo.register.domain.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Technician findByEmailAndPassword(String email, String password);
}
