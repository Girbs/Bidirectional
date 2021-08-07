/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "matiere")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findById", query = "SELECT m FROM Matiere m WHERE m.id = :id"),
    @NamedQuery(name = "Matiere.findByContenu", query = "SELECT m FROM Matiere m WHERE m.contenu = :contenu"),
    @NamedQuery(name = "Matiere.findByCode", query = "SELECT m FROM Matiere m WHERE m.code = :code"),
    @NamedQuery(name = "Matiere.findByDescription", query = "SELECT m FROM Matiere m WHERE m.description = :description"),
    @NamedQuery(name = "Matiere.findByNombreDeCreditStandard", query = "SELECT m FROM Matiere m WHERE m.nombreDeCreditStandard = :nombreDeCreditStandard"),
    @NamedQuery(name = "Matiere.findByMatiereid", query = "SELECT m FROM Matiere m WHERE m.matiereid = :matiereid")})
 
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "nombre_de_credit_standard")
    private int nombreDeCreditStandard;
    @Basic(optional = false)
    @Column(name = "matiereid")
    private int matiereid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matiereid")
    private List<PlannificationConcours> plannificationConcoursList;
    @OneToMany(mappedBy = "matiereid")
    private List<Cours> coursList;

    public Matiere() {
    }

    public Matiere(Integer id) {
        this.id = id;
    }

    public Matiere(Integer id, int nombreDeCreditStandard, int matiereid) {
        this.id = id;
        this.nombreDeCreditStandard = nombreDeCreditStandard;
        this.matiereid = matiereid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreDeCreditStandard() {
        return nombreDeCreditStandard;
    }

    public void setNombreDeCreditStandard(int nombreDeCreditStandard) {
        this.nombreDeCreditStandard = nombreDeCreditStandard;
    }

    public int getMatiereid() {
        return matiereid;
    }

    public void setMatiereid(int matiereid) {
        this.matiereid = matiereid;
    }

    public List<PlannificationConcours> getPlannificationConcoursList() {
        return plannificationConcoursList;
    }

    public void setPlannificationConcoursList(List<PlannificationConcours> plannificationConcoursList) {
        this.plannificationConcoursList = plannificationConcoursList;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Matiere[ id=" + id + " ]";
    }
    
}
