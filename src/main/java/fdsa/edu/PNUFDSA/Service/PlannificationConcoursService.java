/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.PlannificationConcours;
import fdsa.edu.PNUFDSA.Repository.PlannificationConcoursDAO;
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


public class PlannificationConcoursService {
    
   @Autowired 
    
    private PlannificationConcoursDAO plannificationConcoursDAO;
    
    public Optional<PlannificationConcours> getPlannificationConcours(final int id) {
        return plannificationConcoursDAO.findById(id);
    }
    
     public Iterable<PlannificationConcours> getPlannificationConcours() {
        return plannificationConcoursDAO.findAll();
    }

    public void deletePlannificationConcours(final int id) {
        plannificationConcoursDAO.deleteById(id);
    }

    public PlannificationConcours savePlannificationConcours(PlannificationConcours PlannificationConcours) {
        PlannificationConcours savedPlannificationConcours = plannificationConcoursDAO.save(PlannificationConcours);
        return savedPlannificationConcours;
    }
    
    
    
}
