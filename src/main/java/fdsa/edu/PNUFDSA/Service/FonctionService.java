/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Fonction;
import fdsa.edu.PNUFDSA.Repository.FonctionDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EstherA
 */
@Data
@Service
public class FonctionService {
       @Autowired
    private FonctionDAO fonctionDAO;

    public Optional<Fonction> getFonction(final int id) {
        return fonctionDAO.findById(id);
    }

    public Iterable<Fonction> getFonction() {
        return fonctionDAO.findAll();
    }

    public void deleteFonction(final int id) {
        fonctionDAO.deleteById(id);
    }

    public Fonction saveFonction(Fonction Fonction) {
        Fonction savedFonction = fonctionDAO.save(Fonction);
        return savedFonction;
    }

    public void deletefonction(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
