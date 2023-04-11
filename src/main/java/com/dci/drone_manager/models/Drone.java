package com.dci.drone_manager.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

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

  @JsonInclude(JsonInclude.Include.NON_NULL)
  String nome;

  Boolean disponivel;

  @OneToMany
  @JsonIgnore
  List<Delivery> delivery;

  public Drone() {
    this.disponivel = true;
  }

  public Drone(String nome) {
    this.nome = nome;
    this.disponivel = true;
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
