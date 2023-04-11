package com.dci.drone_manager.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.drone_manager.exception.NoDrone;
import com.dci.drone_manager.exception.NoField;
import com.dci.drone_manager.models.Drone;
import com.dci.drone_manager.repository.DroneRepository;

@Service
public class DroneService {

  @Autowired
  private DroneRepository repository;

  public Drone create(Optional<String> nome) {
    if (nome.isPresent()) {
      Drone drone = new Drone(nome.get());
      return repository.save(drone);
    } else {
      Drone drone = new Drone();
      return repository.save(drone);
    }
  }

  public List<Drone> all() {
    return repository.findAll();
  }

  public Optional<Drone> getById(String droneId) throws NoDrone {
    if (!repository.existsById(droneId)) {
      throw new NoDrone();
    }

    return repository.findById(droneId);
  }

  public Drone update(String droneId, Map<String, String> nome) throws NoDrone, NoField {
    if (!repository.existsById(droneId)) {
      throw new NoDrone();
    }

    if (!nome.containsKey("nome")) {
      throw new NoField("nome");
    }

    Drone drone = repository.findById(droneId).get();
    drone.setNome(nome.get("nome"));
    return repository.save(drone);
  }

  public void delete(String droneId) throws NoDrone {
    if (!repository.existsById(droneId)) {
      throw new NoDrone();
    }

    repository.deleteById(droneId);
  }
}
