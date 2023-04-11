package com.dci.drone_manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dci.drone_manager.controllers.DroneController;

@SpringBootTest
class DroneControllerTest {

  @Autowired
  private DroneController controller;

  @Test
  void controllerExists() {
    assertThat(controller).isNotNull();
  }

  @Test
  void createExists() throws Exception {
    Optional<String> nome = Optional.of("Drone 1");
    assertThat(controller.create(nome)).isNotNull();
  }

  @Test
  void allExists() {
    assertThat(controller.all()).isNotNull();
  }

  @Test
  void getByIdExists() throws Exception {
    assertThat(controller.getById("12b")).isNotNull();
  }

  @Test
  void updateExists() {
    assertThat(controller.update("12b")).isNotNull();
  }

  @Test
  void deleteExists() {
    assertThat(controller.delete("12b")).isNotNull();
  }
}
