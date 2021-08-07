/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Personne;;
import fdsa.edu.PNUFDSA.Repository.PersonneDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Richard
 */

@Data
@Service


public class PersonneService {
    
    
    @Autowired
    
    private PersonneDAO personneDAO;
    
    public Optional<Personne> getPersonne(final int id) {
        return personneDAO.findById(id);
    }
    
     public Iterable<Personne> getHoraire() {
        return personneDAO.findAll();
    }

    public void deletePersonne(final int id) {
        personneDAO.deleteById(id);
    }

    public Personne saveHoraire(Personne Personne) {
        Personne savedPersonne = personneDAO.save(Personne);
        return savedPersonne;
    }
    
    
}
