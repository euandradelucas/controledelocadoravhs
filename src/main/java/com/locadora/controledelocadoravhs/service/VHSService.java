package com.locadora.controledelocadoravhs.service;

import com.locadora.controledelocadoravhs.entity.VHS;
import com.locadora.controledelocadoravhs.repository.VHSRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VHSService {

    private final VHSRepository repo;

    public VHSService(VHSRepository repo) {
        this.repo = repo;
    }

    public List<VHS> findAll() {
        return repo.findAll();
    }

    public Optional<VHS> findById(Long id) {
        return repo.findById(id);
    }

    public VHS save(VHS vhs) {
        return repo.save(vhs);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

