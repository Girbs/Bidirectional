/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Matiere;
import fdsa.edu.PNUFDSA.Repository.MatiereDAO;
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

public class MatiereService {
    
    @Autowired
    
    private MatiereDAO matiereDAO;
    
    public Optional<Matiere> getMatiere(final int id) {
        return matiereDAO.findById(id);
    }
    
     public Iterable<Matiere> getMatiere() {
        return matiereDAO.findAll();
    }

    public void deleteMatiere(final int id) {
        matiereDAO.deleteById(id);
    }

    public Matiere saveMatiere(Matiere Matiere) {
        Matiere savedMatiere = matiereDAO.save(Matiere);
        return savedMatiere;
    }
    
}
