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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "concours")
@NamedQueries({
    @NamedQuery(name = "Concours.findAll", query = "SELECT c FROM Concours c"),
    @NamedQuery(name = "Concours.findById", query = "SELECT c FROM Concours c WHERE c.id = :id"),
    @NamedQuery(name = "Concours.findByDateDebut", query = "SELECT c FROM Concours c WHERE c.dateDebut = :dateDebut"),
    @NamedQuery(name = "Concours.findByDateFin", query = "SELECT c FROM Concours c WHERE c.dateFin = :dateFin"),
    @NamedQuery(name = "Concours.findByDescription", query = "SELECT c FROM Concours c WHERE c.description = :description")})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Concours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "concoursid")
    private List<PlannificationConcours> plannificationConcoursList;

    public Concours() {
    }

    public Concours(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PlannificationConcours> getPlannificationConcoursList() {
        return plannificationConcoursList;
    }

    public void setPlannificationConcoursList(List<PlannificationConcours> plannificationConcoursList) {
        this.plannificationConcoursList = plannificationConcoursList;
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
        if (!(object instanceof Concours)) {
            return false;
        }
        Concours other = (Concours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Concours[ id=" + id + " ]";
    }
    
}
