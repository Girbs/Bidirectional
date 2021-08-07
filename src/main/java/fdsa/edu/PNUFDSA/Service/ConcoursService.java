/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Concours;
import fdsa.edu.PNUFDSA.Repository.ConcoursDAO;
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
public class ConcoursService {
     @Autowired
    private ConcoursDAO concoursDAO;

    public Optional<Concours> getConcours(final int id) {
        return concoursDAO.findById(id);
    }

    public Iterable<Concours> getConcours() {
        return concoursDAO.findAll();
    }

    public void deleteConcours(final int id) {
        concoursDAO.deleteById(id);
    }

    public Concours saveConcours(Concours Concours) {
        Concours savedConcours = concoursDAO.save(Concours);
        return savedConcours;
    }
    
}
