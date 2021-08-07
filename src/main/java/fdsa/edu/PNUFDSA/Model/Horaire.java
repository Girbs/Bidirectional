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
@Table(name = "horaire")
@NamedQueries({
    @NamedQuery(name = "Horaire.findAll", query = "SELECT h FROM Horaire h"),
    @NamedQuery(name = "Horaire.findById", query = "SELECT h FROM Horaire h WHERE h.id = :id"),
    @NamedQuery(name = "Horaire.findByDatePremierCours", query = "SELECT h FROM Horaire h WHERE h.datePremierCours = :datePremierCours"),
    @NamedQuery(name = "Horaire.findByHeure", query = "SELECT h FROM Horaire h WHERE h.heure = :heure"),
    @NamedQuery(name = "Horaire.findByJour", query = "SELECT h FROM Horaire h WHERE h.jour = :jour")})
 
public class Horaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_premier_cours")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePremierCours;
    @Column(name = "heure")
    private String heure;
    @Column(name = "jour")
    private String jour;
    @JoinColumn(name = "coursid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cours coursid;

    public Horaire() {
    }

    public Horaire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePremierCours() {
        return datePremierCours;
    }

    public void setDatePremierCours(Date datePremierCours) {
        this.datePremierCours = datePremierCours;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Cours getCoursid() {
        return coursid;
    }

    public void setCoursid(Cours coursid) {
        this.coursid = coursid;
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
        if (!(object instanceof Horaire)) {
            return false;
        }
        Horaire other = (Horaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Horaire[ id=" + id + " ]";
    }
    
}
