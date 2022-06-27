package com.yurakcompany.techservice.security.register.domain.persistence;

import com.yurakcompany.techservice.security.register.domain.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findByEmailAndPassword(String email, String password);
    Business findByName(String name);
    Business findByEmail(String email);
}
