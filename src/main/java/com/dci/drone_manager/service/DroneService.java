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


  public Drone create(Optional<String> nome) throws Exception {
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

  public Optional<Drone> getById(String droneId) throws Exception {
    if (!repository.existsById(droneId)) {
      throw new Exception("Drone não existe");
    }
    return repository.findById(droneId);
  }

  public void update(String droneId, Drone drone) throws Exception {
    if (!repository.existsById(droneId)) {
      throw new Exception("Drone não localizado para atualização");
    }

    Drone droneUpdate = new Drone();
    droneUpdate.setNome(drone.getNome());
    drone.setDisponivel(drone.getDisponivel());
    repository.save(droneUpdate);
  }

  public void delete(String droneId) {
    repository.deleteById(droneId);
  }
}
