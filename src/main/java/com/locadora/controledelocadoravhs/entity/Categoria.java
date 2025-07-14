package com.locadora.controledelocadoravhs.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento com VHS
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<VHS> vhsList;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<VHS> getVhsList() { return vhsList; }
    public void setVhsList(List<VHS> vhsList) { this.vhsList = vhsList; }
}
