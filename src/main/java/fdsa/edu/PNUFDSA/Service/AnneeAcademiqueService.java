/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import java.util.Optional;
import fdsa.edu.PNUFDSA.Model.AnneeAcademique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fdsa.edu.PNUFDSA.Repository.AnneeAcademiqueDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Service
public class AnneeAcademiqueService  {

    @Autowired
    private AnneeAcademiqueDAO anneeAcademiqueDAO;

    public Iterable<AnneeAcademique> getAnneeAcademique() {
      return   anneeAcademiqueDAO.findAll();
    }

}
