package com.dci.drone_manager.controllers;

import com.dci.drone_manager.models.Delivery;
import com.dci.drone_manager.service.DeliveryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    public ResponseEntity<Delivery> create(@RequestParam Float latitude, @RequestParam Float longitude) {
        return ResponseEntity.ok().body(droneDeliveryService.create(latitude, longitude));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Delivery>> all() {
        return ResponseEntity.ok().body(droneDeliveryService.all());
    }

    @PatchMapping("/recebido/{deliveryId}")
    public ResponseEntity<String> recebido(@RequestParam String deliveryId) {
        droneDeliveryService.recebido(deliveryId);
        return ResponseEntity.ok().body("Entrega atualizada com sucesso!");
    }
}
