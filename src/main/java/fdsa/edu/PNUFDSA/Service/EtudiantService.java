/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Etudiant;
import fdsa.edu.PNUFDSA.Repository.EtudiantDAO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author EstherA
 */
public class EtudiantService {
     @Autowired
    private EtudiantDAO etudiantDAO;

    public Optional<Etudiant> getEtudiant(final int id) {
        return etudiantDAO.findById(id);
    }

    public Iterable<Etudiant> getEtudiant() {
        return etudiantDAO.findAll();
    }

    public void deleteEtudiant(final int id) {
        etudiantDAO.deleteById(id);
    }

    public Etudiant saveEtudiant(Etudiant Etudiant) {
        Etudiant savedEtudiant = etudiantDAO.save(Etudiant);
        return savedEtudiant;
    }
}
