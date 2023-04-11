package com.dci.drone_manager.repository;

import com.dci.drone_manager.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {

}
