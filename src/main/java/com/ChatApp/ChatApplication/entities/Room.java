package com.ChatApp.ChatApplication.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@Data

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   private String roomId;

   private List<Message> messages = new ArrayList<>();
}
