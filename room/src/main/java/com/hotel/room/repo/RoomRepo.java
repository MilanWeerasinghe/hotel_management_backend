package com.hotel.room.repo;

import com.hotel.room.dto.RoomDTO;
import com.hotel.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT * FROM room WHERE status = ?1", nativeQuery = true)
    List<Room> getAvailableRooms(String status);


}
