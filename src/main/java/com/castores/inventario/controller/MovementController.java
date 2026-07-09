package com.castores.inventario.controller;

import com.castores.inventario.model.User;
import com.castores.inventario.service.MovementService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping("/historial")
    public String history(
            @RequestParam(required = false) String tipo,
            HttpSession session,
            Model model
    ) {
        User usuario = (User) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/";
        }

        if (!usuario.getRole().getNombre().equals("Administrador")) {
            return "redirect:/inventario";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("movimientos", movementService.getMovements(tipo));
        model.addAttribute("tipoSeleccionado", tipo);

        return "history";
    }
}