package com.dci.drone_manager.service;

import com.dci.drone_manager.models.Delivery;
import com.dci.drone_manager.models.Drone;
import com.dci.drone_manager.repository.DeliveryRepository;
import com.dci.drone_manager.repository.DroneRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private DroneRepository droneRepository;

    public Delivery create(Float latitude, Float longitude) {
        Optional<Drone> drone = droneRepository.findByDisponivel(true).stream().findFirst();

        if (!drone.isPresent()) {
            throw new RuntimeException("Nenhum drone disponível!");
        }

        Delivery delivery = new Delivery();

        delivery.setDrone(drone.get());
        delivery.setLatitude(latitude);
        delivery.setLongitude(longitude);

        drone.get().setDisponivel(false);

        droneRepository.save(drone.get());

        return repository.save(delivery);
    }

    public List<Delivery> all() {
        return repository.findAll();
    }

    public void recebido(String deliveryId) {
        Optional<Delivery> delivery = repository.findById(deliveryId);

        if (!delivery.isPresent()) {
            throw new RuntimeException("Entrega não encontrada!");
        }

        delivery.get().setEntregue(true);
        delivery.get().setDataDeEntrega(LocalDateTime.now());

        repository.save(delivery.get());

        Drone drone = delivery.get().getDrone();

        drone.setDisponivel(true);

        droneRepository.save(drone);
    }
}