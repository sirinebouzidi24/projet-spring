package spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spring.jpa.dto.InscriptionForm;
import spring.jpa.model.Cours;
import spring.jpa.model.Etudiant;
import spring.jpa.model.Inscription;
import spring.jpa.service.CourService;
import spring.jpa.service.EtudiantService;
import spring.jpa.service.InscriptionService;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private CourService courService;

    // Liste
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("inscriptions", inscriptionService.getAll());
        return "inscriptions";
    }

    // Formulaire
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("etudiants", etudiantService.getAll());
        model.addAttribute("cours", courService.getAllCours());
        return "formInscription";
    }

    // Save
    @PostMapping("/save")
    public String save(
            @RequestParam("etudiantId") String etudiantId,
            @RequestParam("coursId") Long coursId
    ) {
        Etudiant etudiant = etudiantService.getById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        Cours cours = courService.getCoursByID(coursId)
                .orElseThrow(() -> new RuntimeException("Cours introuvable"));

        Inscription inscription = new Inscription();
        inscription.setEtudiant(etudiant);
        inscription.setCours(cours);

        inscriptionService.save(inscription);

        return "redirect:/inscription/index";
    }
 // Delete
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        inscriptionService.delete(id);
        return "redirect:/inscription/index";
    }
}
