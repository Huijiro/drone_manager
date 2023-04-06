package com.dci.drone_manager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dci.drone_manager.controllers.DroneController;
import com.dci.drone_manager.models.Drone;

@SpringBootTest
class DroneControllerTest {

  @Autowired
  private DroneController controller;

  @Test
  void controllerExists() {
    assertThat(controller).isNotNull();
  }

  @Test
  void createExists(Drone drone) {
    assertThat(controller.create(drone)).isNotNull();
  }

  @Test
  void allExists() {
    assertThat(controller.all()).isNotNull();
  }

  @Test
  void getByIdExists(Integer droneId) {
    assertThat(controller.getById(droneId)).isNotNull();
  }

  @Test
  void updateExists(Integer droneId) {
    assertThat(controller.update(droneId)).isNotNull();
  }

  @Test
  void deleteExists(Integer droneId) {
    assertThat(controller.delete(droneId)).isNotNull();
  }
}
