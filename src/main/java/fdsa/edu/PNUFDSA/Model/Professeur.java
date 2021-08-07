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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "professeur")
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p"),
    @NamedQuery(name = "Professeur.findByCodeProfesseur", query = "SELECT p FROM Professeur p WHERE p.codeProfesseur = :codeProfesseur"),
    @NamedQuery(name = "Professeur.findByLienCv", query = "SELECT p FROM Professeur p WHERE p.lienCv = :lienCv"),
    @NamedQuery(name = "Professeur.findByTitre", query = "SELECT p FROM Professeur p WHERE p.titre = :titre"),
    @NamedQuery(name = "Professeur.findByPersonneid", query = "SELECT p FROM Professeur p WHERE p.personneid = :personneid")})

public class Professeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "code_professeur")
    private String codeProfesseur;
    @Column(name = "lien_cv")
    private String lienCv;
    @Column(name = "titre")
    private String titre;
    @Id
    @Basic(optional = false)
    @Column(name = "personneid")
    private Integer personneid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professeurPersonneid")
    private List<Publication> publicationList;
    @JoinColumn(name = "personneid", referencedColumnName = "personneid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utlilisateur utlilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professeurPersonneid")
    private List<Cours> coursList;

    public Professeur() {
    }

    public Professeur(Integer personneid) {
        this.personneid = personneid;
    }

    public String getCodeProfesseur() {
        return codeProfesseur;
    }

    public void setCodeProfesseur(String codeProfesseur) {
        this.codeProfesseur = codeProfesseur;
    }

    public String getLienCv() {
        return lienCv;
    }

    public void setLienCv(String lienCv) {
        this.lienCv = lienCv;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getPersonneid() {
        return personneid;
    }

    public void setPersonneid(Integer personneid) {
        this.personneid = personneid;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

    public Utlilisateur getUtlilisateur() {
        return utlilisateur;
    }

    public void setUtlilisateur(Utlilisateur utlilisateur) {
        this.utlilisateur = utlilisateur;
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
        hash += (personneid != null ? personneid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.personneid == null && other.personneid != null) || (this.personneid != null && !this.personneid.equals(other.personneid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Professeur[ personneid=" + personneid + " ]";
    }
    
}
