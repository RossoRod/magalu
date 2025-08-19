package com.rosso.magalu.enums;

import com.rosso.magalu.entity.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
    PENDING(1L, "Pending"),
    SUCCESS(2L, "Success"),
    ERROR(3L, "Error"),
    CANCELED(4L, "Canceled");

    private final Long id;
    private final String description;

    public Status toStatus() {
        return new Status(id, description);
    }
}
