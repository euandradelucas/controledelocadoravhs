package com.locadora.controledelocadoravhs.service;

import com.locadora.controledelocadoravhs.entity.VHS;
import com.locadora.controledelocadoravhs.repository.VHSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VHSService {

    @Autowired
    private VHSRepository vhsRepository;

    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }

    public Optional<VHS> findById(Long id) {
        return vhsRepository.findById(id);
    }

    public VHS save(VHS vhs) {
        return vhsRepository.save(vhs);
    }

    public void deleteById(Long id) {
        vhsRepository.deleteById(id);
    }
}
