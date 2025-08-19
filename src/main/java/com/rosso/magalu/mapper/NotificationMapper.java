package com.rosso.magalu.mapper;

import com.rosso.magalu.controller.dto.ScheduleNotificationDto;
import com.rosso.magalu.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "channel", expression = "java(dto.channel().toChannel())")
    @Mapping(target = "status", expression = "java(com.rosso.magalu.enums.StatusEnum.PENDING.toStatus())")
    Notification dtoToEntity (ScheduleNotificationDto dto);
}
