package com.dci.drone_manager.models;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Optional<String> nome;

  Boolean disponivel;

  @OneToMany
  List<Delivery> delivery;

  public Drone() {};

  public Drone(Optional<String> nome) {
    this.disponivel = true;
    this.nome = nome;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Delivery> getDelivery() {
    return delivery;
  }

  public void setDelivery(List<Delivery> delivery) {
    this.delivery = delivery;
  }

  public Boolean getDisponivel() {
    return disponivel;
  }

  public void setDisponivel(Boolean disponivel) {
    this.disponivel = disponivel;
  }

  public Optional<String> getNome() {
    return nome;
  }

  public void setNome(Optional<String> nome) {
    this.nome = nome;
  }
}
