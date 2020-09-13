package com.kaaner.HomeAssistantBackend.repository;

import com.kaaner.HomeAssistantBackend.models.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    List<Tool> findByRoomId(Long roomId);
}
