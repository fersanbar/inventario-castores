package com.castores.inventario.controller;

import com.castores.inventario.model.User;
import com.castores.inventario.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String correo,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        User user = userService.login(correo, password);

        if (user == null) {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login";
        }

        session.setAttribute("usuario", user);

        return "redirect:/inventario";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}