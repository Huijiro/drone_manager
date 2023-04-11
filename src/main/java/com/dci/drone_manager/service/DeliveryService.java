package com.dci.drone_manager.service;

import com.dci.drone_manager.exception.NoDelivery;
import com.dci.drone_manager.exception.NoDroneAvailable;
import com.dci.drone_manager.exception.NoField;
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

    public Delivery create(Float latitude, Float longitude) throws NoDroneAvailable, NoField {
        Optional<Drone> drone = droneRepository.findByDisponivel(true).stream().findFirst();

        if (latitude.equals(null)) {
            throw new NoField("latitude");
        }

        if (longitude.equals(null)) {
            throw new NoField("longitude");
        }

        if (!drone.isPresent()) {
            throw new NoDroneAvailable();
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

    public Delivery recebido(String deliveryId) throws NoDelivery {
        Optional<Delivery> delivery = repository.findById(deliveryId);

        if (!delivery.isPresent()) {
            throw new NoDelivery();
        }

        delivery.get().setEntregue(true);
        delivery.get().setDataDeEntrega(LocalDateTime.now());

        Drone drone = delivery.get().getDrone();

        drone.setDisponivel(true);

        droneRepository.save(drone);
        return repository.save(delivery.get());
    }
}