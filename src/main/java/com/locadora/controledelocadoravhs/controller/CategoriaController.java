package com.locadora.controledelocadoravhs.controller;

import com.locadora.controledelocadoravhs.entity.Categoria;
import com.locadora.controledelocadoravhs.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categorialist";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoriaform";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<Categoria> cat = categoriaService.findById(id);
        if (cat.isPresent()) {
            model.addAttribute("categoria", cat.get());
            return "categoriaform";
        }
        return "redirect:/categoria";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return "redirect:/categoria";
    }
}
