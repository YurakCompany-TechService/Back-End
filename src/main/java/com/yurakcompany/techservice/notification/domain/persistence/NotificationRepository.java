package com.yurakcompany.techservice.notification.domain.persistence;

import com.yurakcompany.techservice.notification.domain.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification findByTechnicianId(Long TechnicianId);

    // Notification findByBusinessId(Long BusinessId);
}
