package com.dci.drone_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dci.drone_manager.models.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {

}
