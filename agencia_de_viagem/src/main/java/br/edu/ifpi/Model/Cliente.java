package br.edu.ifpi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Cliente extends Pessoa {
  
  @Column(unique = true, nullable = false)
  private String cpf;
  
  @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Reserva> reservas = new ArrayList<>();

  public void setCpf(String cpf){
    this.cpf = cpf;
  }
  public String getCPF(){
    return this.cpf;
  } 

  public List<Reserva> getReservas() {
      return reservas;
  }

  public void setReservas(List<Reserva> reservas) {
      this.reservas = reservas;
  }
}
