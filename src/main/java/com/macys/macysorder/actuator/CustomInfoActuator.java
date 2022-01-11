package com.macys.macysorder.actuator;

import com.macys.macysorder.repository.JsonMessageRepository;
import com.macys.macysorder.repository.XmlMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoActuator implements InfoContributor {

    @Autowired
    JsonMessageRepository jsonMessageRepository;

    @Autowired
    XmlMessageRepository xmlMessageRepository;

    @Override
    public void contribute(Info.Builder builder) {
        builder
                .withDetail("Total XML Messages Consumed : ", xmlMessageRepository.count())
                .withDetail("Total JSON Messages Consumed : ", jsonMessageRepository.count())
                .build();
    }
}
