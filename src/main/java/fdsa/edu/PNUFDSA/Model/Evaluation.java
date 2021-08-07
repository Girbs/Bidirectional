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
@Table(name = "evaluation")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findById", query = "SELECT e FROM Evaluation e WHERE e.id = :id"),
    @NamedQuery(name = "Evaluation.findByCotationPourcentage", query = "SELECT e FROM Evaluation e WHERE e.cotationPourcentage = :cotationPourcentage"),
    @NamedQuery(name = "Evaluation.findByDateEvaluation", query = "SELECT e FROM Evaluation e WHERE e.dateEvaluation = :dateEvaluation"),
    @NamedQuery(name = "Evaluation.findBySession", query = "SELECT e FROM Evaluation e WHERE e.session = :session"),
    @NamedQuery(name = "Evaluation.findByTypeEvaluation", query = "SELECT e FROM Evaluation e WHERE e.typeEvaluation = :typeEvaluation")})
 
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cotation_pourcentage")
    private BigInteger cotationPourcentage;
    @Basic(optional = false)
    @Column(name = "date_evaluation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEvaluation;
    @Column(name = "session")
    private String session;
    @Column(name = "type_evaluation")
    private String typeEvaluation;
    @JoinColumn(name = "coursid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cours coursid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationid")
    private List<HistoriqueExam> historiqueExamList;

    public Evaluation() {
    }

    public Evaluation(Integer id) {
        this.id = id;
    }

    public Evaluation(Integer id, Date dateEvaluation) {
        this.id = id;
        this.dateEvaluation = dateEvaluation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getCotationPourcentage() {
        return cotationPourcentage;
    }

    public void setCotationPourcentage(BigInteger cotationPourcentage) {
        this.cotationPourcentage = cotationPourcentage;
    }

    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(String typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public Cours getCoursid() {
        return coursid;
    }

    public void setCoursid(Cours coursid) {
        this.coursid = coursid;
    }

    public List<HistoriqueExam> getHistoriqueExamList() {
        return historiqueExamList;
    }

    public void setHistoriqueExamList(List<HistoriqueExam> historiqueExamList) {
        this.historiqueExamList = historiqueExamList;
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
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Evaluation[ id=" + id + " ]";
    }
    
}
