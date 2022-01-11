package com.macys.macysorder.service;

import com.macys.macysorder.dto.OrderStatus;
import com.macys.macysorder.dto.UpdateOrderStatusRequest;
import com.macys.macysorder.entity.json.OrderMessageJsonEntity;
import com.macys.macysorder.entity.xml.FulfillmentOrderEntity;
import com.macys.macysorder.exxception.CustomEntityNotFoundException;
import com.macys.macysorder.repository.JsonMessageRepository;
import com.macys.macysorder.repository.XmlMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderMessageServiceImpl implements OrderMessageService {

    @Autowired
    XmlMessageRepository xmlMessageRepository;

    @Autowired
    JsonMessageRepository jsonMessageRepository;

    @ExceptionHandler(CustomEntityNotFoundException.class)
    @Override
    public ResponseEntity<Boolean> updateOrder(UpdateOrderStatusRequest updateOrderStatusRequest) {
        try {
            FulfillmentOrderEntity xmlEntity = xmlMessageRepository.getById(updateOrderStatusRequest.getId());
            return updateXmlOrder(xmlEntity, updateOrderStatusRequest);
        } catch (EntityNotFoundException e) {
            try {
                OrderMessageJsonEntity jsonEntity = jsonMessageRepository.getById(updateOrderStatusRequest.getId());
                return updateJsonOrder(jsonEntity, updateOrderStatusRequest);
            } catch (EntityNotFoundException ex) {
                throw new CustomEntityNotFoundException();
            }
        }
    }

    private ResponseEntity<Boolean> updateXmlOrder(FulfillmentOrderEntity entity, UpdateOrderStatusRequest updateOrderStatusRequest) throws EntityNotFoundException {
        entity.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getStatus().toUpperCase()));
        xmlMessageRepository.save(entity);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> updateJsonOrder(OrderMessageJsonEntity jsonEntity, UpdateOrderStatusRequest updateOrderStatusRequest) throws EntityNotFoundException {
        jsonEntity.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getStatus().toUpperCase()));
        jsonMessageRepository.save(jsonEntity);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
