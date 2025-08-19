package com.rosso.magalu.repository;

import com.rosso.magalu.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
