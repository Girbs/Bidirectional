/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Controller;


import fdsa.edu.PNUFDSA.Service.AnneeAcademiqueService;
import fdsa.edu.PNUFDSA.Model.AnneeAcademique;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnneeAcademiqueController {

   @Autowired
    private AnneeAcademiqueService anneeAcademiqueService;

   
     @GetMapping("/anneeAcademique")
    public Iterable<AnneeAcademique> getAnneeAcademique() {
       return   anneeAcademiqueService.getAnneeAcademique();
    }
  
}
