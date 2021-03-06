/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Cours;
import fdsa.edu.PNUFDSA.Repository.CoursDAO;
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
public class CoursService {
     @Autowired
    private CoursDAO coursDAO;

    /**
     *
     * @param id
     * @return
     */
    public Optional<Cours> getCours(final int id) {
        return coursDAO.findById(id);
    }

    public Iterable<Cours> getCours() {
        return coursDAO.findAll();
    }

    public void deleteCours(final int id) {
        coursDAO.deleteById(id);
    }

    public Cours saveCours(Cours Cours) {
        Cours savedCours = coursDAO.save(Cours);
        return savedCours;
    }

  
}
