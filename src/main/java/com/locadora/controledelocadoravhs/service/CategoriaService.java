package com.locadora.controledelocadoravhs.service;

import com.locadora.controledelocadoravhs.entity.Categoria;
import com.locadora.controledelocadoravhs.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<Categoria> findAll() {
        return repo.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return repo.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return repo.save(categoria);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
