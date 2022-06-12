package com.yurakcompany.demo.notification.service;

import com.yurakcompany.demo.notification.domain.model.Notification;
import com.yurakcompany.demo.notification.domain.persistence.NotificationRepository;
import com.yurakcompany.demo.notification.domain.service.NotificationService;
import com.yurakcompany.demo.register.domain.persistence.BusinessRepository;
import com.yurakcompany.demo.register.domain.persistence.TechnicianRepository;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final String ENTITY = "Notification";

    private final NotificationRepository notificationRepository;

    private final Validator validator;

    private final TechnicianRepository technicianRepository;

    private final BusinessRepository businessRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository, Validator validator, TechnicianRepository technicianRepository, BusinessRepository businessRepository) {
        this.notificationRepository = notificationRepository;
        this.validator = validator;
        this.technicianRepository = technicianRepository;
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    /*@Override
    public Notification getByTechnicianId(Long TechnicianId) {
        return notificationRepository.findByTechnicianId(TechnicianId);
    }*/

    @Override
    public Notification createTechnicianNotification(Long TechnicianId, Notification notification) {
        Set<ConstraintViolation<Notification>>violations = validator.validate(notification);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return technicianRepository.findById(TechnicianId).map(technician -> {
            notification.setTechnician(technician);
            return notificationRepository.save(notification);
        }).orElseThrow(()-> new ResourceNotFoundException("Technician", TechnicianId));
    }

   // @Override
    //public Notification createBusinessNotification(Long BusinessId, Notification notification) {
       // throw new ResourceValidationException(ENTITY, violations);

        //return businessRepository.findById(BusinessId).map(business -> {
            //notification.setBusiness(business);
          //  return notificationRepository.save(notification);
       // }).orElseThrow(()-> new ResourceNotFoundException("Business", BusinessId));
    //}

    @Override
    public ResponseEntity<?> delete(Long notificationId) {
        return notificationRepository.findById(notificationId).map(notification -> {
            notificationRepository.delete(notification);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, notificationId));
    }
}
