package com.dci.drone_manager.controllers;

import com.dci.drone_manager.exception.NoDelivery;
import com.dci.drone_manager.exception.NoDroneAvailable;
import com.dci.drone_manager.exception.NoField;
import com.dci.drone_manager.models.Delivery;
import com.dci.drone_manager.service.DeliveryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService droneDeliveryService;

    @PostMapping("/create")
    public ResponseEntity<Delivery> create(@RequestParam Float latitude, @RequestParam Float longitude)
            throws NoDroneAvailable, NoField {
        return ResponseEntity.ok().body(droneDeliveryService.create(latitude, longitude));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Delivery>> all() {
        return ResponseEntity.ok().body(droneDeliveryService.all());
    }

    @PatchMapping("/recebido/{deliveryId}")
    public ResponseEntity<Delivery> recebido(@PathVariable String deliveryId) throws NoDelivery {
        return ResponseEntity.ok().body(droneDeliveryService.recebido(deliveryId));
    }
}
