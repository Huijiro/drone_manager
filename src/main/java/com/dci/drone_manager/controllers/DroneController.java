package com.dci.drone_manager.controllers;

import com.dci.drone_manager.models.Drone;
import com.dci.drone_manager.service.DroneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drone")
public class DroneController {

  @Autowired
  private DroneService droneService;

  @PostMapping
  public ResponseEntity<Drone> create(@RequestBody Drone drone) {
    return ResponseEntity.ok().body(droneService.create(drone));
  }

  @GetMapping
  public ResponseEntity<List<Drone>> all() {
    return ResponseEntity.ok().body(droneService.all());
  }

  @GetMapping("/{droneId}")
  public ResponseEntity<Optional<Drone>> getById(@PathVariable Integer droneId) {
    return ResponseEntity.ok().body(droneService.getById(droneId));
  }

  @PatchMapping("/{droneId}")
  public ResponseEntity<Void> update(@PathVariable Integer droneId) {
    droneService.update(droneId);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{droneId}")
  public ResponseEntity<Void> delete(@PathVariable Integer droneId) {
    droneService.delete(droneId);
    return ResponseEntity.ok().build();
  }
}
