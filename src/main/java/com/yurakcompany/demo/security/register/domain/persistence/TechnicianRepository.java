package com.yurakcompany.demo.security.register.domain.persistence;

import com.yurakcompany.demo.security.register.domain.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Technician findByEmailAndPassword(String email, String password);
    Technician findByFirstNameAndLastName(String firstName, String lastName);
    Technician findByEmail(String email);
}
