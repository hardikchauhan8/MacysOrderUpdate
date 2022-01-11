package com.macys.macysorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macys.macysorder.dto.UpdateOrderStatusRequest;
import com.macys.macysorder.service.OrderMessageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    OrderMessageService orderMessageService;

    @Test
    void testUpdateStatus() throws Exception {

        UpdateOrderStatusRequest orderStatusRequest = new UpdateOrderStatusRequest();
        given(orderMessageService.updateOrder(orderStatusRequest)).willReturn(new ResponseEntity<>(true, HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        String updateObjStr = objectMapper.writeValueAsString(orderStatusRequest);

        mvc.perform(put("/macys/order/update")
                        .content(updateObjStr)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
