package com.rosso.magalu.service;

import com.rosso.magalu.controller.dto.ScheduleNotificationDto;
import com.rosso.magalu.entity.Notification;
import com.rosso.magalu.enums.StatusEnum;
import com.rosso.magalu.mapper.NotificationMapper;
import com.rosso.magalu.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationMapper notificationMapper;

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(notificationMapper.dtoToEntity(dto));
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(StatusEnum.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(StatusEnum.PENDING.toStatus(), StatusEnum.ERROR.toStatus()),
                dateTime
        );
        
        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            //TODO: ENVIAR NOTIFICAÇÃO

            n.setStatus(StatusEnum.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }
}
