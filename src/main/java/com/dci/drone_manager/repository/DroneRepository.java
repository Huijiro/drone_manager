package com.dci.drone_manager.repository;

import com.dci.drone_manager.models.Drone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, String> {
    List<Drone> findByDisponivel(Boolean disponivel);
}
