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

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // tu plantilla de registro (o el fragmento si usas modal)
    }

   @PostMapping("/guardar")
public String guardar(@ModelAttribute("usuario") @Valid Usuario usuario,
                      BindingResult result,
                      RedirectAttributes ra,
                      Model model) {
    if (result.hasErrors()) {
        return "registro";
    }
    usuarioService.registrar(usuario);
    ra.addFlashAttribute("success", "Cuenta creada correctamente. Inicia sesión.");
    return "redirect:/login";
}

}
