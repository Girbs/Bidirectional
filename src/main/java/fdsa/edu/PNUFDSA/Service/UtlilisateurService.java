/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Utlilisateur;
import fdsa.edu.PNUFDSA.Repository.UtlilisateurDAO;
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
public class UtlilisateurService {
     @Autowired
    private UtlilisateurDAO utlilisateurDAO;

    public Optional<Utlilisateur> getUtlilisateur(final int id) {
        return utlilisateurDAO.findById(id);
    }

    public Iterable<Utlilisateur> getUtlilisateur() {
        return utlilisateurDAO.findAll();
    }

    public void deleteUtlilisateur(final int id) {
        utlilisateurDAO.deleteById(id);
    }

    public Utlilisateur saveUtlilisateur(Utlilisateur Utlilisateur) {
        Utlilisateur savedUtlilisateur = utlilisateurDAO.save(Utlilisateur);
        return savedUtlilisateur;
    }
    
}
