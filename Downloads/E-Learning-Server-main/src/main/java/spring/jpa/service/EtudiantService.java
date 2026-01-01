package spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.jpa.model.Etudiant;
import spring.jpa.repository.EtudiantsRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantsRepository repository;

    public List<Etudiant> getAll() {
        return repository.findAll();
    }
  
    public Optional<Etudiant> getById(String id) {
        return repository.findById(id);
    }

    public List<Etudiant> findAllById(List<String> ids) {
        return repository.findAllById(ids);
    }

    public Etudiant save(Etudiant etudiant) {
        if (etudiant.getDateInscription() == null) {
            etudiant.setDateInscription(
                Date.valueOf(java.time.LocalDate.now())
            );
        }
        return repository.save(etudiant);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}



