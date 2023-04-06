package com.dci.drone_manager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dci.drone_manager.models.Drone;
import com.dci.drone_manager.repository.DroneRepository;

@Service
public class DroneService {

  @Autowired
  private DroneRepository repository;

  public Drone create(Drone drone) {
    return repository.save(drone);
  }

  public List<Drone> all() {
    return repository.findAll();
  }

  public Optional<Drone> getById(Integer droneId) throws Exception {
    if (!repository.existsById(droneId)) {
      throw new Exception("Drone não existe");
    }
    return repository.findById(droneId);
  }

  public void update(Integer droneId) {
    var drone = new Drone();
    drone.setDisponivel(true);
    repository.save(drone);
  }

  public void delete(Integer droneId) {
    repository.deleteById(droneId);
  }
}
