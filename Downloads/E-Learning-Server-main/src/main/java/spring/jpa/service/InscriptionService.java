package spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.jpa.model.Inscription;
import spring.jpa.repository.InscriptionsRepository;

import java.util.Date;
import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionsRepository repository;

    public List<Inscription> getAll() {
        return repository.findAll();
    }

    public Inscription save(Inscription inscription) {
        if (inscription.getDate() == null) {
            inscription.setDate(new Date()); 
        }
        return repository.save(inscription);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
