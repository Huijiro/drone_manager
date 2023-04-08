package com.dci.drone_manager.models;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  Float latitude;
  Float longitude;

  LocalDateTime dataDeEnvio;
  LocalDateTime dataDeEntrega;

  Boolean entregado;
  String videoString;

  @ManyToOne
  Drone drone;

  public Delivery() {
    this.dataDeEnvio = LocalDateTime.now();
    this.entregado = false;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Float getLatitude() {
    return latitude;
  }

  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  public Float getLongitude() {
    return longitude;
  }

  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  public LocalDateTime getDataDeEntrega() {
    return dataDeEntrega;
  }

  public void setDataDeEntrega(LocalDateTime dataDeEntrega) {
    this.dataDeEntrega = dataDeEntrega;
  }

  public String getVideoString() {
    return videoString;
  }

  public void setVideoString(String videoString) {
    this.videoString = videoString;
  }

  public LocalDateTime getDataDeEnvio() {
    return dataDeEnvio;
  }

  public void setDataDeEnvio(LocalDateTime dataDeEnvio) {
    this.dataDeEnvio = dataDeEnvio;
  }

  public Boolean getEntregado() {
    return entregado;
  }

  public void setEntregado(Boolean entregado) {
    this.entregado = entregado;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }
}
