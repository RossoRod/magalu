package com.rosso.magalu.service;

import com.rosso.magalu.controller.dto.ScheduleNotificationDto;
import com.rosso.magalu.entity.Notification;
import com.rosso.magalu.enums.StatusEnum;
import com.rosso.magalu.mapper.NotificationMapper;
import com.rosso.magalu.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //ADICIONAR LOGICA PARA CASO NÃO ENCONTRE A NOTIFICAÇÃO
    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(StatusEnum.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }
}
