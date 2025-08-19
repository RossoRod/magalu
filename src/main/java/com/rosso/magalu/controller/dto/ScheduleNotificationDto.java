package com.rosso.magalu.controller.dto;

import com.rosso.magalu.enums.ChannelEnum;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      ChannelEnum channel) {
}
