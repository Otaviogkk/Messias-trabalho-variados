package br.edu.ifpi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome(){
    return this.nome;
  }
  public String getEmail(){
    return this.email;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setEmail(String email){
    this.email = email;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
