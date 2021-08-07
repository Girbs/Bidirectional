/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "personnel")
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findByPersonneid", query = "SELECT p FROM Personnel p WHERE p.personneid = :personneid")})

public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "personneid")
    private Integer personneid;
    @JoinColumn(name = "fonctionid", referencedColumnName = "id")
    @ManyToOne
    private Fonction fonctionid;
    @JoinColumn(name = "personneid", referencedColumnName = "personneid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utlilisateur utlilisateur;

    public Personnel() {
    }

    public Personnel(Integer personneid) {
        this.personneid = personneid;
    }

    public Integer getPersonneid() {
        return personneid;
    }

    public void setPersonneid(Integer personneid) {
        this.personneid = personneid;
    }

    public Fonction getFonctionid() {
        return fonctionid;
    }

    public void setFonctionid(Fonction fonctionid) {
        this.fonctionid = fonctionid;
    }

    public Utlilisateur getUtlilisateur() {
        return utlilisateur;
    }

    public void setUtlilisateur(Utlilisateur utlilisateur) {
        this.utlilisateur = utlilisateur;
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
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.personneid == null && other.personneid != null) || (this.personneid != null && !this.personneid.equals(other.personneid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Personnel[ personneid=" + personneid + " ]";
    }
    
}
