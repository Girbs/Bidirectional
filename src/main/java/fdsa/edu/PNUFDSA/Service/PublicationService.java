/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Publication;
import fdsa.edu.PNUFDSA.Repository.PublicationDAO;
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
public class PublicationService {
     @Autowired
    private PublicationDAO publicationDAO;

    public Optional<Publication> getPublication(final int id) {
        return publicationDAO.findById(id);
    }

    public Iterable<Publication> getPublication() {
        return publicationDAO.findAll();
    }

    public void deletePublication(final int id) {
        publicationDAO.deleteById(id);
    }

    public Publication savePublication(Publication Publication) {
        Publication savedPublication = publicationDAO.save(Publication);
        return savedPublication;
    }
    
}

