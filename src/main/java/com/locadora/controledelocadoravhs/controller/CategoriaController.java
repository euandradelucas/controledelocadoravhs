package com.locadora.controledelocadoravhs.controller;

import com.locadora.controledelocadoravhs.entity.Categoria;
import com.locadora.controledelocadoravhs.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categoria/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Categoria categoria, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("categoria", categoria);
            return "categoria/form";
        }
        categoriaService.save(categoria);
        return "redirect:/categoria";
    }


    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        var cat = categoriaService.findById(id);
        if (cat.isPresent()) {
            model.addAttribute("categoria", cat.get());
            return "categoria/form";
        }
        return "redirect:/categoria";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return "redirect:/categoria";
    }
}

