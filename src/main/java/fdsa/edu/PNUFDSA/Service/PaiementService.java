/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Paiement;
import fdsa.edu.PNUFDSA.Repository.PaiementDAO;
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
public class PaiementService {

    @Autowired
    private PaiementDAO paiementDAO;

    public Optional<Paiement> getPaiement(final int id) {
        return paiementDAO.findById(id);
    }

    public Iterable<Paiement> getPaiements() {
        return paiementDAO.findAll();
    }

    public void deletePaiement(final int id) {
        paiementDAO.deleteById(id);
    }

    public Paiement savePaiement(Paiement Paiement) {
        Paiement savedPaiement = paiementDAO.save(Paiement);
        return savedPaiement;
    }

}