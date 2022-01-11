package com.macys.macysorder.repository;

import com.macys.macysorder.entity.json.OrderMessageJsonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonMessageRepository extends JpaRepository<OrderMessageJsonEntity, Integer> {
}