/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Professeur;
import fdsa.edu.PNUFDSA.Repository.ProfesseurDAO;
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


public class ProfesseurService {
    
    @Autowired
    
    
    private ProfesseurDAO professeurDAO;
    
    public Optional<Professeur> getProfesseur(final int id) {
        return professeurDAO.findById(id);
    }
    
     public Iterable<Professeur> getProfesseur() {
        return professeurDAO.findAll();
    }

    public void deleteProfesseur(final int id) {
        professeurDAO.deleteById(id);
    }

    public Professeur saveProfesseur(Professeur Professeur) {
        Professeur savedProfesseur = professeurDAO.save(Professeur);
        return savedProfesseur;
    }
    
}
