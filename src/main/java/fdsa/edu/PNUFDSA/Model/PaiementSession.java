/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigInteger;
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

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "paiement_session")
@NamedQueries({
    @NamedQuery(name = "PaiementSession.findAll", query = "SELECT p FROM PaiementSession p"),
    @NamedQuery(name = "PaiementSession.findById", query = "SELECT p FROM PaiementSession p WHERE p.id = :id"),
    @NamedQuery(name = "PaiementSession.findByAttribute", query = "SELECT p FROM PaiementSession p WHERE p.attribute = :attribute"),
    @NamedQuery(name = "PaiementSession.findByCommentaire", query = "SELECT p FROM PaiementSession p WHERE p.commentaire = :commentaire"),
    @NamedQuery(name = "PaiementSession.findByMontantPaiement", query = "SELECT p FROM PaiementSession p WHERE p.montantPaiement = :montantPaiement")})
 
public class PaiementSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "attribute")
    private int attribute;
    @Column(name = "commentaire")
    private String commentaire;
    @Basic(optional = false)
    @Column(name = "montant_paiement")
    private BigInteger montantPaiement;
    @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")
    @ManyToOne
    private Etudiant etudiantPersonneid;
    @JoinColumn(name = "sessionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Session sessionid;

    public PaiementSession() {
    }

    public PaiementSession(Integer id) {
        this.id = id;
    }

    public PaiementSession(Integer id, int attribute, BigInteger montantPaiement) {
        this.id = id;
        this.attribute = attribute;
        this.montantPaiement = montantPaiement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public BigInteger getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(BigInteger montantPaiement) {
        this.montantPaiement = montantPaiement;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaiementSession)) {
            return false;
        }
        PaiementSession other = (PaiementSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.PaiementSession[ id=" + id + " ]";
    }
    
}
