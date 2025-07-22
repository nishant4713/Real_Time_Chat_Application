package com.ChatApp.ChatApplication.entities;

import jdk.jfr.Timestamp;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private String sender;
    private String receiver;
    @Timestamp
    private LocalDateTime timeStamp;
}
