/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;


import fdsa.edu.PNUFDSA.Model.Postulant;
import fdsa.edu.PNUFDSA.Repository.PostulantDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Data
@Service
public class PostulantService {

    @Autowired
    private PostulantDAO postulantDAO;

    public Iterable<Postulant> getPostulant() {
        return postulantDAO.findAll();
    }

    public Postulant savePostulant(Postulant postulant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Optional<Postulant> getPostulant(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletePostulant(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
