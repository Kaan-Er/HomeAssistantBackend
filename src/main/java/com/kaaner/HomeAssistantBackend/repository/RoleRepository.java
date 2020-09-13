package com.kaaner.HomeAssistantBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaaner.HomeAssistantBackend.models.ERole;
import com.kaaner.HomeAssistantBackend.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
