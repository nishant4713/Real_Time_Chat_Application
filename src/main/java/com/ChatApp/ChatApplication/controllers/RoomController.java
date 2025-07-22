package com.ChatApp.ChatApplication.controllers;

import com.ChatApp.ChatApplication.entities.Message;
import com.ChatApp.ChatApplication.entities.Room;
import com.ChatApp.ChatApplication.repositories.RoomRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody  String roomId){
           if(roomRepository.findByRoomId(roomId)!=null){
               return ResponseEntity.badRequest().body("Room already exists !");
           }
         Room room = new Room();
           room.setRoomId(roomId);
          Room savedRoom =  roomRepository.save(room);
          return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        Room room = roomRepository.findByRoomId(roomId);
        if(room==null){
            return ResponseEntity.badRequest().body("Room does not exist !");
        }
        return ResponseEntity.ok(room);
    }
}
@GetMapping("/{roomId}/messages")
public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId)
