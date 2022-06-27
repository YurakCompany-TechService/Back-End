package com.yurakcompany.techservice.notification.domain.service;

import com.yurakcompany.techservice.notification.domain.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
    List<Notification> getAll();
    //Notification getByTechnicianId(Long TechnicianId);
    //Notification getByBusinessId(Long BusinessId);
    Notification createTechnicianNotification(Long TechnicianId, Notification notification);
   // Notification createBusinessNotification(Long BusinessId, Notification notification);
    ResponseEntity<?> delete(Long notificationId);
}
