package com.hotel.room.service;

import com.hotel.room.dto.RoomDTO;
import com.hotel.room.model.Room;
import com.hotel.room.repo.RoomRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private ModelMapper modelMapper;


    public RoomDTO addRoom(RoomDTO roomDTO){
        roomRepo.save(modelMapper.map(roomDTO, Room.class));
        return roomDTO;
    }

    public List<RoomDTO> getAllRooms() {
        List<Room> roomList =  roomRepo.findAll();
        return modelMapper.map(roomList, new TypeToken<List<RoomDTO>>(){}.getType());
    }

    public RoomDTO getRoomById(int id) {
        Optional<Room> room = roomRepo.findById(id);
        return modelMapper.map(room, new TypeToken<RoomDTO>(){}.getType());
    }

    public RoomDTO updateRoom(RoomDTO roomDTO) {
        roomRepo.save(modelMapper.map(roomDTO, Room.class));
        return roomDTO;
    }

    public String deleteAllRooms(){
        roomRepo.deleteAll();
        return "delete success.";
    }

    public String deleteById(int id){
        roomRepo.deleteById(id);
        return "successfully deleted room number: "+id;
    }
    public List<RoomDTO> getAvailableRooms(String status){
        List<Room> roomList = roomRepo.getAvailableRooms(status);
        return modelMapper.map(roomList, new TypeToken<List<RoomDTO>>(){}.getType());
    }

}
