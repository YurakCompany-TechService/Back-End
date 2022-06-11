package com.yurakcompany.demo.register.domain.persistence;

import com.yurakcompany.demo.register.domain.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findByEmailAndPassword(String email, String password);
}
