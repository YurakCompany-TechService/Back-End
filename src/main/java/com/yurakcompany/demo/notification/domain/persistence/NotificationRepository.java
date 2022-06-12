package com.yurakcompany.demo.notification.domain.persistence;

import com.yurakcompany.demo.notification.domain.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification findByTechnicianId(Long TechnicianId);

    // Notification findByBusinessId(Long BusinessId);
}
