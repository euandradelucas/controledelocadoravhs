package com.locadora.controledelocadoravhs.controller;

import com.locadora.controledelocadoravhs.entity.VHS;
import com.locadora.controledelocadoravhs.entity.Categoria;
import com.locadora.controledelocadoravhs.service.VHSService;
import com.locadora.controledelocadoravhs.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    @Autowired
    private VHSService vhsService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarVHS(Model model) {
        List<VHS> lista = vhsService.findAll();
        model.addAttribute("vhsList", lista);
        return "vhslist";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("vhs", new VHS());
        model.addAttribute("categorias", categoriaService.findAll());
        return "vhsform";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute VHS vhs, @RequestParam Long categoriaId) {
        Categoria categoria = categoriaService.findById(categoriaId)
            .orElseThrow(() -> new IllegalArgumentException("Categoria inválida"));
        vhs.setCategoria(categoria);
        vhsService.save(vhs);
        return "redirect:/vhs";
}


    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<VHS> vhs = vhsService.findById(id);
        if (vhs.isPresent()) {
            model.addAttribute("vhs", vhs.get());
            model.addAttribute("categorias", categoriaService.findAll());
            return "vhsform";
        }
        return "redirect:/vhs";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }
}
