/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "promotion")
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findById", query = "SELECT p FROM Promotion p WHERE p.id = :id"),
    @NamedQuery(name = "Promotion.findByDateDedebut", query = "SELECT p FROM Promotion p WHERE p.dateDedebut = :dateDedebut"),
    @NamedQuery(name = "Promotion.findByMontantFraisSession", query = "SELECT p FROM Promotion p WHERE p.montantFraisSession = :montantFraisSession"),
    @NamedQuery(name = "Promotion.findByMontantfraisGeneraux", query = "SELECT p FROM Promotion p WHERE p.montantfraisGeneraux = :montantfraisGeneraux"),
    @NamedQuery(name = "Promotion.findByNomPromotion", query = "SELECT p FROM Promotion p WHERE p.nomPromotion = :nomPromotion")})

public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_dedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDedebut;
    @Basic(optional = false)
    @Column(name = "montant_frais_session")
    private double montantFraisSession;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montantfrais_generaux")
    private Double montantfraisGeneraux;
    @Column(name = "nom_promotion")
    private String nomPromotion;
    @JoinTable(name = "promotion_etudiant", joinColumns = {
        @JoinColumn(name = "promotionid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")})
    @ManyToMany
    private List<Etudiant> etudiantList;

    public Promotion() {
    }

    public Promotion(Integer id) {
        this.id = id;
    }

    public Promotion(Integer id, double montantFraisSession) {
        this.id = id;
        this.montantFraisSession = montantFraisSession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDedebut() {
        return dateDedebut;
    }

    public void setDateDedebut(Date dateDedebut) {
        this.dateDedebut = dateDedebut;
    }

    public double getMontantFraisSession() {
        return montantFraisSession;
    }

    public void setMontantFraisSession(double montantFraisSession) {
        this.montantFraisSession = montantFraisSession;
    }

    public Double getMontantfraisGeneraux() {
        return montantfraisGeneraux;
    }

    public void setMontantfraisGeneraux(Double montantfraisGeneraux) {
        this.montantfraisGeneraux = montantfraisGeneraux;
    }

    public String getNomPromotion() {
        return nomPromotion;
    }

    public void setNomPromotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
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
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Promotion[ id=" + id + " ]";
    }
    
}
