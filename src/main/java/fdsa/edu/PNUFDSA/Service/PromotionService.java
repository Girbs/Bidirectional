/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Promotion;
import fdsa.edu.PNUFDSA.Repository.PromotionDAO;
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
public class PromotionService {
     @Autowired
    private PromotionDAO promotionDAO;

    public Optional<Promotion> getPromotion(final int id) {
        return promotionDAO.findById(id);
    }

    public Iterable<Promotion> getPromotion() {
        return promotionDAO.findAll();
    }

    public void deletePromotion(final int id) {
        promotionDAO.deleteById(id);
    }

    public Promotion savePromotion(Promotion Promotion) {
        Promotion savedPromotion = promotionDAO.save(Promotion);
        return savedPromotion;
    }
    
}
