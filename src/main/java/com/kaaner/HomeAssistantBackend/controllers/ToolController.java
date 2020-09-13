package com.kaaner.HomeAssistantBackend.controllers;

import com.kaaner.HomeAssistantBackend.models.Tool;
import com.kaaner.HomeAssistantBackend.repository.RoomRepository;
import com.kaaner.HomeAssistantBackend.repository.ToolRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ToolController {

    private ToolRepository toolRepository;
    private RoomRepository roomRepository;

    @Autowired
    public ToolController(ToolRepository toolRepository,RoomRepository roomRepository){this.roomRepository=roomRepository; this.toolRepository=toolRepository;}

    @GetMapping("/{roomId}/tools") //http://localhost:8080/api/1/tools
    public List<Tool> getByToolId(@PathVariable Long roomId){return toolRepository.findByRoomId(roomId);}

    @PostMapping("/{roomId}/tools") //http://localhost:8080/api/1/tools
    public Tool addTool(@PathVariable Long roomId, @Valid @RequestBody Tool newTool) throws NotFoundException {
        return roomRepository.findById(roomId).map(room -> {
            newTool.setRoom(room);
            return toolRepository.save(newTool);
        }).orElseThrow(() -> new NotFoundException("Room not found!"));
    }
}
