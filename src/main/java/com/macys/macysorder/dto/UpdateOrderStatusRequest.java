package com.macys.macysorder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UpdateOrderStatusRequest implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("newStatus")
    private String status;

    public UpdateOrderStatusRequest() {
    }

    public UpdateOrderStatusRequest(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateOrderStatusRequest{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
