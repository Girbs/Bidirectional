/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Controller;

import fdsa.edu.PNUFDSA.Model.Institution;
import fdsa.edu.PNUFDSA.Service.InstitutionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Richard
 */

@RestController
public class InstitutionController {
    
    @Autowired 
    public InstitutionService institutionService;
    
    /**
     * Afficher tous les Institution
     *
     * @return 
     */
    @GetMapping(value = "/AllInstitutions")
    public List<Institution> getAllInstitution() {
        return (List<Institution>) institutionService.getInstitution();
    }
    
    
    /**
     * Creer un nouveau Institution
     *
     *
     * @param institution
     * @return
     */
    @PostMapping("/nouveauInstitution")
    public Institution createInstitution(@RequestBody Institution institution) {
        return institutionService.saveInstitution(institution);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/UneInstitution/{id}")
    public Institution getinstitution(@PathVariable("id") int id) {
        Optional<Institution> institution = institutionService.getInstitution(id);
        if ( institution.isPresent() ) {
            return institution.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un institution
     * @param id 
     */
    
    @DeleteMapping("/supprimerInstitution")
    public void deleteInstitution(@PathVariable("id") final int id) {
        institutionService.deleteInstitution(id);
    }
    
    
}
