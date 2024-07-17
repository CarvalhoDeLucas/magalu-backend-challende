package com.carvalhodelucas.magalums.services;

import com.carvalhodelucas.magalums.controller.dtos.ScheduleNotificationDTO;
import com.carvalhodelucas.magalums.entities.Notification;
import com.carvalhodelucas.magalums.entities.Status;
import com.carvalhodelucas.magalums.repositories.NotificationRepository;
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

    public void scheduleNotification(ScheduleNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()
        ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return  n -> {
          // TODO - REALIZAR O ENVIO DA NOTIFICATION

          n.setStatus(Status.Values.SUCCESS.toStatus());
          notificationRepository.save(n);
        };
    }

}
