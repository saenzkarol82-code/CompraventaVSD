package com.proyecto.AccesoUsuarios.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.AccesoUsuarios.model.Usuario;
import com.proyecto.AccesoUsuarios.service.UsuarioService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("usuario") Usuario usuario,
                          RedirectAttributes ra) {
        usuarioService.registrar(usuario);
        ra.addFlashAttribute("success", "Cuenta creada correctamente. Inicia sesión.");
        return "redirect:/login";
    }

}
