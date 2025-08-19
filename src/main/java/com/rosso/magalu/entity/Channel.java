package com.rosso.magalu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CHANNEL")
public class Channel {
    @Id
    @Column(name = "ID")
    private Long channelId;

    @Column(name = "DESCRIPTION")
    private String description;
}
