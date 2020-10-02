package com.kaaner.HomeAssistantBackend.controllers;

import com.kaaner.HomeAssistantBackend.models.Room;
import com.kaaner.HomeAssistantBackend.repository.RoomRepository;
import com.kaaner.HomeAssistantBackend.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoomController {

    private RoomRepository roomRepository;
    private UserRepository userRepository;

    @Autowired
    public RoomController (RoomRepository roomRepository,UserRepository userRepository){this.roomRepository=roomRepository; this.userRepository=userRepository;}

    @GetMapping("/{userId}/rooms") //http://localhost:8080/api/1/rooms
    public List<Room> getByUserId(@PathVariable Long userId){return roomRepository.findByUsersId(userId);}

    @PostMapping("/{userId}/rooms") //http://localhost:8080/api/1/rooms
    public Room addRoom(@PathVariable Long userId, @Valid @RequestBody Room newRoom) throws NotFoundException{
        return userRepository.findById(userId).map(user -> {
            newRoom.setUsers(user);
            return roomRepository.save(newRoom);
        }).orElseThrow(() -> new NotFoundException("User not found!"));

    }

}
