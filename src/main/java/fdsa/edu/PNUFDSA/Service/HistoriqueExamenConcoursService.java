/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.HistoriqueExamenConcours;
import fdsa.edu.PNUFDSA.Repository.HistoriqueExamenConcoursDAO;
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
public class HistoriqueExamenConcoursService {
    
    @Autowired
    private HistoriqueExamenConcoursDAO historiqueExamenConcoursDAO;
    
    public Optional<HistoriqueExamenConcours> getHistoriqueExamenConcour(final int id) {
        return historiqueExamenConcoursDAO.findById(id);
    }
    
     public Iterable<HistoriqueExamenConcours> getHistoriqueExamenConcours() {
        return historiqueExamenConcoursDAO.findAll();
    }

    public void deleteHistoriqueExamenConcours(final int id) {
        historiqueExamenConcoursDAO.deleteById(id);
    }

    public HistoriqueExamenConcours saveHistoriqueExamenConcours(HistoriqueExamenConcours HistoriqueExamenConcours) {
        HistoriqueExamenConcours savedHistoriqueExamenConcours = historiqueExamenConcoursDAO.save(HistoriqueExamenConcours);
        return savedHistoriqueExamenConcours;
    }

    public Optional<HistoriqueExamenConcours> getHistoriqueExamenConcours(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
