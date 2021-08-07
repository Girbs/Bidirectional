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
@Table(name = "historique_examen_concours")
@NamedQueries({
    @NamedQuery(name = "HistoriqueExamenConcours.findAll", query = "SELECT h FROM HistoriqueExamenConcours h"),
    @NamedQuery(name = "HistoriqueExamenConcours.findById", query = "SELECT h FROM HistoriqueExamenConcours h WHERE h.id = :id"),
    @NamedQuery(name = "HistoriqueExamenConcours.findByNoteObtenue", query = "SELECT h FROM HistoriqueExamenConcours h WHERE h.noteObtenue = :noteObtenue")})
 
public class HistoriqueExamenConcours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "note_obtenue")
    private double noteObtenue;
    @JoinColumn(name = "plannification_concoursid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlannificationConcours plannificationConcoursid;
    @JoinColumn(name = "postulantid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Postulant postulantid;

    public HistoriqueExamenConcours() {
    }

    public HistoriqueExamenConcours(Integer id) {
        this.id = id;
    }

    public HistoriqueExamenConcours(Integer id, double noteObtenue) {
        this.id = id;
        this.noteObtenue = noteObtenue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(double noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    public PlannificationConcours getPlannificationConcoursid() {
        return plannificationConcoursid;
    }

    public void setPlannificationConcoursid(PlannificationConcours plannificationConcoursid) {
        this.plannificationConcoursid = plannificationConcoursid;
    }

    public Postulant getPostulantid() {
        return postulantid;
    }

    public void setPostulantid(Postulant postulantid) {
        this.postulantid = postulantid;
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
        if (!(object instanceof HistoriqueExamenConcours)) {
            return false;
        }
        HistoriqueExamenConcours other = (HistoriqueExamenConcours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.HistoriqueExamenConcours[ id=" + id + " ]";
    }
    
}
