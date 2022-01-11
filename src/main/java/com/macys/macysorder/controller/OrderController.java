package com.macys.macysorder.controller;

import com.macys.macysorder.dto.UpdateOrderStatusRequest;
import com.macys.macysorder.service.OrderMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/macys/order")
public class OrderController {

    @Autowired
    OrderMessageService orderMessageService;

    @PutMapping(value = "/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Boolean> updateOrder(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest) {
        return orderMessageService.updateOrder(updateOrderStatusRequest);
    }
}
