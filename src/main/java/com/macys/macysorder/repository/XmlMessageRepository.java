package com.macys.macysorder.repository;

import com.macys.macysorder.entity.xml.FulfillmentOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XmlMessageRepository extends JpaRepository<FulfillmentOrderEntity, Integer> {
}