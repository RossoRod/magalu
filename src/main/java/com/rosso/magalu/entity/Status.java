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
@Table(name = "TB_STATUS")
public class Status {
    @Id
    @Column(name = "ID")
    private Long statusId;

    @Column(name = "DESCRIPTION")
    private String description;
}
