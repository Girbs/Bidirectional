/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Stage;
import fdsa.edu.PNUFDSA.Repository.StageDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jephthé Gédéon
 */
@Data
@Service
public class StageService {
     @Autowired
    private StageDAO stageDAO;

    public Optional<Stage> getStage(final int id) {
        return stageDAO.findById(id);
    }

    public Iterable<Stage> getStage() {
        return stageDAO.findAll();
    }

    public void deleteStage(final int id) {
        stageDAO.deleteById(id);
    }

    public Stage saveStage(Stage Stage) {
        Stage savedStage = stageDAO.save(Stage);
        return savedStage;
    }
    
}
