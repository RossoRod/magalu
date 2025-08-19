package com.rosso.magalu.enums;

import com.rosso.magalu.entity.Channel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ChannelEnum {
    EMAIL(1L, "email"),
    SMS(2L, "sms"),
    PUSH(3L, "push"),
    WHATSAPP(4L, "whatsapp");

    private final Long id;
    private final String description;

    public Channel toChannel() {
        return new Channel(id, description);
    }
}
