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
@Table(name = "historique_exam")
@NamedQueries({
    @NamedQuery(name = "HistoriqueExam.findAll", query = "SELECT h FROM HistoriqueExam h"),
    @NamedQuery(name = "HistoriqueExam.findById", query = "SELECT h FROM HistoriqueExam h WHERE h.id = :id"),
    @NamedQuery(name = "HistoriqueExam.findByNote", query = "SELECT h FROM HistoriqueExam h WHERE h.note = :note")})
 
public class HistoriqueExam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "note")
    private double note;
    @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")
    @ManyToOne(optional = false)
    private Etudiant etudiantPersonneid;
    @JoinColumn(name = "evaluationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evaluation evaluationid;

    public HistoriqueExam() {
    }

    public HistoriqueExam(Integer id) {
        this.id = id;
    }

    public HistoriqueExam(Integer id, double note) {
        this.id = id;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Etudiant getEtudiantPersonneid() {
        return etudiantPersonneid;
    }

    public void setEtudiantPersonneid(Etudiant etudiantPersonneid) {
        this.etudiantPersonneid = etudiantPersonneid;
    }

    public Evaluation getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(Evaluation evaluationid) {
        this.evaluationid = evaluationid;
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
        if (!(object instanceof HistoriqueExam)) {
            return false;
        }
        HistoriqueExam other = (HistoriqueExam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.HistoriqueExam[ id=" + id + " ]";
    }
    
}
