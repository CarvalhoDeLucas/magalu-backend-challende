package com.carvalhodelucas.magalums.controller.dtos;

import com.carvalhodelucas.magalums.entities.Channel;
import com.carvalhodelucas.magalums.entities.Notification;
import com.carvalhodelucas.magalums.entities.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(
        LocalDateTime dateTime,
        String destination,
        String message,
        Channel.Values channel
) {

    public Notification toNotification () {
        return new Notification(
                null,
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }

}
