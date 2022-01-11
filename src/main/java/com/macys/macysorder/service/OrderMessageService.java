package com.macys.macysorder.service;

import com.macys.macysorder.dto.UpdateOrderStatusRequest;
import com.macys.macysorder.dto.json.OrderMessageJson;
import com.macys.macysorder.dto.xml.FulfillmentOrder;
import org.springframework.http.ResponseEntity;

public interface OrderMessageService {
    ResponseEntity<Boolean> updateOrder(UpdateOrderStatusRequest updateOrderStatusRequest);
}
