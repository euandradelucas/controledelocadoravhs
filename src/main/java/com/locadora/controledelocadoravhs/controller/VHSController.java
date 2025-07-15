package com.locadora.controledelocadoravhs.controller;

import com.locadora.controledelocadoravhs.entity.StatusVHS;
import com.locadora.controledelocadoravhs.entity.VHS;
import com.locadora.controledelocadoravhs.service.CategoriaService;
import com.locadora.controledelocadoravhs.service.VHSService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    private final VHSService vhsService;
    private final CategoriaService categoriaService;

    public VHSController(VHSService vhsService, CategoriaService categoriaService) {
        this.vhsService = vhsService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vhsList", vhsService.findAll());
        return "vhs/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("vhs", new VHS());
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("statusList", StatusVHS.values());
        return "vhs/form";
    }


    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute VHS vhs, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("categorias", categoriaService.findAll());
            model.addAttribute("statusList", StatusVHS.values());
            return "vhs/form";
        }
        if (vhs.getDataCadastro() == null) {
            vhs.setDataCadastro(LocalDate.now());
        }
        vhsService.save(vhs);
        return "redirect:/vhs";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<VHS> vhs = vhsService.findById(id);
        if (vhs.isPresent()) {
            model.addAttribute("vhs", vhs.get());
            model.addAttribute("categorias", categoriaService.findAll());
            model.addAttribute("statusList", StatusVHS.values());
            return "vhs/form";
        }
        return "redirect:/vhs";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }
}

