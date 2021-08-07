/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "paiement")
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p"),
    @NamedQuery(name = "Paiement.findById", query = "SELECT p FROM Paiement p WHERE p.id = :id"),
    @NamedQuery(name = "Paiement.findByDatePaiement", query = "SELECT p FROM Paiement p WHERE p.datePaiement = :datePaiement"),
    @NamedQuery(name = "Paiement.findByMontant", query = "SELECT p FROM Paiement p WHERE p.montant = :montant"),
    @NamedQuery(name = "Paiement.findByNumeroPaiement", query = "SELECT p FROM Paiement p WHERE p.numeroPaiement = :numeroPaiement"),
    @NamedQuery(name = "Paiement.findByRemarque", query = "SELECT p FROM Paiement p WHERE p.remarque = :remarque")})
@AllArgsConstructor
@NoArgsConstructor
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_paiement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;
    @Column(name = "montant")
    private BigInteger montant;
    @Column(name = "numero_paiement")
    private String numeroPaiement;
    @Column(name = "remarque")
    private String remarque;
    @JoinColumn(name = "annee_academiqueid", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnoreProperties("paiementList")
    private AnneeAcademique anneeAcademiqueid;
    @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")
    @ManyToOne(optional = false)
    private Etudiant etudiantPersonneid;
    @JoinColumn(name = "sessionid", referencedColumnName = "id")
    @ManyToOne
    private Session sessionid;
    @JoinColumn(name = "type_paiementid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypePaiement typePaiementid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paiementid")
    private List<Requete> requeteList;

  
    public Paiement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public String getNumeroPaiement() {
        return numeroPaiement;
    }

    public void setNumeroPaiement(String numeroPaiement) {
        this.numeroPaiement = numeroPaiement;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public AnneeAcademique getAnneeAcademiqueid() {
        return anneeAcademiqueid;
    }

    public void setAnneeAcademiqueid(AnneeAcademique anneeAcademiqueid) {
        this.anneeAcademiqueid = anneeAcademiqueid;
    }

    public Etudiant getEtudiantPersonneid() {
        return etudiantPersonneid;
    }

    public void setEtudiantPersonneid(Etudiant etudiantPersonneid) {
        this.etudiantPersonneid = etudiantPersonneid;
    }

    public Session getSessionid() {
        return sessionid;
    }

    public void setSessionid(Session sessionid) {
        this.sessionid = sessionid;
    }

    public TypePaiement getTypePaiementid() {
        return typePaiementid;
    }

    public void setTypePaiementid(TypePaiement typePaiementid) {
        this.typePaiementid = typePaiementid;
    }

    public List<Requete> getRequeteList() {
        return requeteList;
    }

    public void setRequeteList(List<Requete> requeteList) {
        this.requeteList = requeteList;
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
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Paiement[ id=" + id + " ]";
    }
    
}
