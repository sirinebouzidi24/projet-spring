package spring.jpa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.jpa.model.Etudiant;
import spring.jpa.service.EtudiantService;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Liste des étudiants
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("etudiants", etudiantService.getAll());
        return "etudiants";
    }

    // Formulaire ajout
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "formEtudiant";
    }

    // Sauvegarde
    @PostMapping("/save")
    public String save(@Valid Etudiant etudiant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formEtudiant";
        }
        etudiantService.save(etudiant);
        return "redirect:/etudiant/index";
    }

    // Edition
    @GetMapping("/edit")
    public String edit(@RequestParam String matricule, Model model) {
        Etudiant e = etudiantService.getById(matricule)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));
        model.addAttribute("etudiant", e);
        return "editEtudiant";
    }

    // Mise à jour
    @PostMapping("/update")
    public String update(@Valid Etudiant etudiant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editEtudiant";
        }
        etudiantService.save(etudiant);
        return "redirect:/etudiant/index";
    }

    // Suppression
    @GetMapping("/delete")
    public String delete(@RequestParam String matricule) {
        etudiantService.delete(matricule);
        return "redirect:/etudiant/index";
    }
}

