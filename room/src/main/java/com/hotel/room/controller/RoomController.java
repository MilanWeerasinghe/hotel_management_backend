package com.hotel.room.controller;

import com.hotel.room.dto.RoomDTO;
import com.hotel.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/room/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/addroom")
    public RoomDTO register(@RequestBody RoomDTO roomDTO){
        return roomService.addRoom(roomDTO);
    }
    @GetMapping("/getrooms")
    public List<RoomDTO> getAll(){
        return roomService.getAllRooms();
    }
    @GetMapping("/getroom/{id}")
    public RoomDTO getRoomById(@PathVariable int id){
        return roomService.getRoomById(id);
    }
    @PutMapping("/updateroom")
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO){
        return roomService.updateRoom(roomDTO);
    }
    @DeleteMapping("/delete")
    public String deleteAll(){
        return roomService.deleteAllRooms();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return roomService.deleteById(id);
    }
    @GetMapping("/getrooms/{status}")
    public List<RoomDTO> getAvailableRooms(@PathVariable String status){
        return roomService.getAvailableRooms(status);
    }


}
