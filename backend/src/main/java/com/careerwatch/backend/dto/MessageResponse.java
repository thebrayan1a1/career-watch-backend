package com.careerwatch.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MessageResponse {
    private List<String> message;
    private Integer Status;
    private Date timeStamp;

    public MessageResponse(Integer status) {
        this.Status=status;
        this.message = new ArrayList<>();
        this.timeStamp = new Date();
    }

    public MessageResponse(Integer status, String message) {
        Status = status;
        this.message = new ArrayList<>();
        this.message.add(message);
        this.timeStamp = new Date();
    }
}
