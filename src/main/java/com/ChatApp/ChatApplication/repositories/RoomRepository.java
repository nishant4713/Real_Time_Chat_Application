package com.ChatApp.ChatApplication.repositories;

import com.ChatApp.ChatApplication.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,String> {
    Room findByRoomId(String roomId);

}
