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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "requete")
@NamedQueries({
    @NamedQuery(name = "Requete.findAll", query = "SELECT r FROM Requete r"),
    @NamedQuery(name = "Requete.findById", query = "SELECT r FROM Requete r WHERE r.id = :id"),
    @NamedQuery(name = "Requete.findByDescription", query = "SELECT r FROM Requete r WHERE r.description = :description"),
    @NamedQuery(name = "Requete.findByDate", query = "SELECT r FROM Requete r WHERE r.date = :date"),
    @NamedQuery(name = "Requete.findByStatut", query = "SELECT r FROM Requete r WHERE r.statut = :statut")})

public class Requete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "statut")
    private String statut;
    @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")
    @ManyToOne(optional = false)
    private Etudiant etudiantPersonneid;
    @JoinColumn(name = "paiementid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paiement paiementid;
    @JoinColumn(name = "type_requeteid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeRequete typeRequeteid;

    public Requete() {
    }

    public Requete(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Etudiant getEtudiantPersonneid() {
        return etudiantPersonneid;
    }

    public void setEtudiantPersonneid(Etudiant etudiantPersonneid) {
        this.etudiantPersonneid = etudiantPersonneid;
    }

    public Paiement getPaiementid() {
        return paiementid;
    }

    public void setPaiementid(Paiement paiementid) {
        this.paiementid = paiementid;
    }

    public TypeRequete getTypeRequeteid() {
        return typeRequeteid;
    }

    public void setTypeRequeteid(TypeRequete typeRequeteid) {
        this.typeRequeteid = typeRequeteid;
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
        if (!(object instanceof Requete)) {
            return false;
        }
        Requete other = (Requete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Requete[ id=" + id + " ]";
    }
    
}
