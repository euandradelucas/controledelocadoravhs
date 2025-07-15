package com.locadora.controledelocadoravhs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class VHS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    private String imagemUrl;

    @NotBlank(message = "Diretor é obrigatório")
    private String diretor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @NotNull(message = "Categoria é obrigatória")
    private Categoria categoria;

    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status é obrigatório")
    private StatusVHS status;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getImagemUrl() { return imagemUrl; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }

    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public StatusVHS getStatus() { return status; }
    public void setStatus(StatusVHS status) { this.status = status; }
}
