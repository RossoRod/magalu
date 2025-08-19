package com.rosso.magalu.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_NOTIFICATIONS")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long notificationId;

    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "MESSAGE")
    private String message;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private Status status;
}
