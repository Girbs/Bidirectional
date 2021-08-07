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

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "plannification_concours")
@NamedQueries({
    @NamedQuery(name = "PlannificationConcours.findAll", query = "SELECT p FROM PlannificationConcours p"),
    @NamedQuery(name = "PlannificationConcours.findById", query = "SELECT p FROM PlannificationConcours p WHERE p.id = :id"),
    @NamedQuery(name = "PlannificationConcours.findByDate", query = "SELECT p FROM PlannificationConcours p WHERE p.date = :date"),
    @NamedQuery(name = "PlannificationConcours.findByNoteDePassage", query = "SELECT p FROM PlannificationConcours p WHERE p.noteDePassage = :noteDePassage"),
    @NamedQuery(name = "PlannificationConcours.findByQuotation", query = "SELECT p FROM PlannificationConcours p WHERE p.quotation = :quotation")})

public class PlannificationConcours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "note_de_passage")
    private double noteDePassage;
    @Basic(optional = false)
    @Column(name = "quotation")
    private double quotation;
    @JoinColumn(name = "concoursid", referencedColumnName = "id")
    @ManyToOne
    private Concours concoursid;
    @JoinColumn(name = "matiereid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Matiere matiereid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plannificationConcoursid")
    private List<HistoriqueExamenConcours> historiqueExamenConcoursList;

    public PlannificationConcours() {
    }

    public PlannificationConcours(Integer id) {
        this.id = id;
    }

    public PlannificationConcours(Integer id, double noteDePassage, double quotation) {
        this.id = id;
        this.noteDePassage = noteDePassage;
        this.quotation = quotation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNoteDePassage() {
        return noteDePassage;
    }

    public void setNoteDePassage(double noteDePassage) {
        this.noteDePassage = noteDePassage;
    }

    public double getQuotation() {
        return quotation;
    }

    public void setQuotation(double quotation) {
        this.quotation = quotation;
    }

    public Concours getConcoursid() {
        return concoursid;
    }

    public void setConcoursid(Concours concoursid) {
        this.concoursid = concoursid;
    }

    public Matiere getMatiereid() {
        return matiereid;
    }

    public void setMatiereid(Matiere matiereid) {
        this.matiereid = matiereid;
    }

    public List<HistoriqueExamenConcours> getHistoriqueExamenConcoursList() {
        return historiqueExamenConcoursList;
    }

    public void setHistoriqueExamenConcoursList(List<HistoriqueExamenConcours> historiqueExamenConcoursList) {
        this.historiqueExamenConcoursList = historiqueExamenConcoursList;
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
        if (!(object instanceof PlannificationConcours)) {
            return false;
        }
        PlannificationConcours other = (PlannificationConcours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.PlannificationConcours[ id=" + id + " ]";
    }
    
}
