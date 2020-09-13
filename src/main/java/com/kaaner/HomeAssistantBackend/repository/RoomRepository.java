package com.kaaner.HomeAssistantBackend.repository;

import com.kaaner.HomeAssistantBackend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByUsersId(Long usersId);

}
