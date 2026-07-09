package com.castores.inventario.controller;

import com.castores.inventario.model.User;
import com.castores.inventario.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.castores.inventario.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castores.inventario.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;

    }

    @GetMapping("/inventario")
    public String inventory(
            Model model,
            HttpSession session
    ) {

        User usuario = (User) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("productos", productService.getAllProducts());

        return "inventory";
    }

    @PostMapping("/inventario/agregar")
    public String saveProduct(Product product){

        productService.saveProduct(product);

        return "redirect:/inventario";

    }

    @GetMapping("/inventario/status/{id}")
    public String changeStatus(@PathVariable Long id){

        productService.changeStatus(id);

        return "redirect:/inventario";

    }

    @PostMapping("/inventario/entrada/{id}")
    public String addStock(
            @PathVariable Long id,
            @RequestParam Integer cantidad,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        User usuario = (User) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/";
        }

        if (!usuario.getRole().getNombre().equals("Administrador")) {
            return "redirect:/inventario";
        }

        String error = productService.addStock(id, cantidad, usuario.getNombre());

        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
        } else {
            redirectAttributes.addFlashAttribute("success", "Entrada registrada correctamente.");
        }

        return "redirect:/inventario";
    }

    @GetMapping("/salida")
    public String output(Model model, HttpSession session) {

        User usuario = (User) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/";
        }

        if (!usuario.getRole().getNombre().equals("Almacenista")) {
            return "redirect:/inventario";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("productos", productService.getActiveProducts());

        return "output";
    }

    @PostMapping("/salida/{id}")
    public String removeStock(
            @PathVariable Long id,
            @RequestParam Integer cantidad,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        User usuario = (User) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/";
        }

        if (!usuario.getRole().getNombre().equals("Almacenista")) {
            return "redirect:/inventario";
        }

        String error = productService.removeStock(id, cantidad, usuario.getNombre());

        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
        } else {
            redirectAttributes.addFlashAttribute("success", "Salida registrada correctamente.");
        }

        return "redirect:/salida";
    }

}