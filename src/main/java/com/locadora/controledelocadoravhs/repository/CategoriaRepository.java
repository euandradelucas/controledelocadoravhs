package com.locadora.controledelocadoravhs.repository;

import com.locadora.controledelocadoravhs.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
