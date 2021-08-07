/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "cours")
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findById", query = "SELECT c FROM Cours c WHERE c.id = :id"),
    @NamedQuery(name = "Cours.findByCodeCours", query = "SELECT c FROM Cours c WHERE c.codeCours = :codeCours"),
    @NamedQuery(name = "Cours.findByCreditReel", query = "SELECT c FROM Cours c WHERE c.creditReel = :creditReel"),
    @NamedQuery(name = "Cours.findByDescriptionCours", query = "SELECT c FROM Cours c WHERE c.descriptionCours = :descriptionCours"),
    @NamedQuery(name = "Cours.findByDuree", query = "SELECT c FROM Cours c WHERE c.duree = :duree"),
    @NamedQuery(name = "Cours.findByMatiereDesc", query = "SELECT c FROM Cours c WHERE c.matiereDesc = :matiereDesc"),
    @NamedQuery(name = "Cours.findByResponsable", query = "SELECT c FROM Cours c WHERE c.responsable = :responsable")})
@AllArgsConstructor

public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code_cours")
    private String codeCours;
    @Column(name = "credit_reel")
    private Integer creditReel;
    @Column(name = "description_cours")
    private String descriptionCours;
    @Column(name = "duree")
    private String duree;
    @Column(name = "matiere_desc")
    private String matiereDesc;
    @Column(name = "responsable")
    private String responsable;
    @ManyToMany(mappedBy = "coursList")
   @JsonIgnoreProperties("coursList")
    private List<AnneeAcademique> anneeAcademiqueList;
    @ManyToMany(mappedBy = "coursList")
    private List<Session> sessionList;
    @JoinTable(name = "cours_etudiant", joinColumns = {
        @JoinColumn(name = "coursid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")})
    @ManyToMany
    private List<Etudiant> etudiantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coursid")
    private List<Horaire> horaireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coursid")
    private List<Discussion> discussionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coursid")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "matiereid", referencedColumnName = "id")
    @ManyToOne
    private Matiere matiereid;
    @JoinColumn(name = "professeur_personneid", referencedColumnName = "personneid")
    @ManyToOne(optional = false)
    private Professeur professeurPersonneid;

    public Cours() {
    }

    public Cours(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(String codeCours) {
        this.codeCours = codeCours;
    }

    public Integer getCreditReel() {
        return creditReel;
    }

    public void setCreditReel(Integer creditReel) {
        this.creditReel = creditReel;
    }

    public String getDescriptionCours() {
        return descriptionCours;
    }

    public void setDescriptionCours(String descriptionCours) {
        this.descriptionCours = descriptionCours;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getMatiereDesc() {
        return matiereDesc;
    }

    public void setMatiereDesc(String matiereDesc) {
        this.matiereDesc = matiereDesc;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<AnneeAcademique> getAnneeAcademiqueList() {
        return anneeAcademiqueList;
    }

    public void setAnneeAcademiqueList(List<AnneeAcademique> anneeAcademiqueList) {
        this.anneeAcademiqueList = anneeAcademiqueList;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public List<Horaire> getHoraireList() {
        return horaireList;
    }

    public void setHoraireList(List<Horaire> horaireList) {
        this.horaireList = horaireList;
    }

    public List<Discussion> getDiscussionList() {
        return discussionList;
    }

    public void setDiscussionList(List<Discussion> discussionList) {
        this.discussionList = discussionList;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Matiere getMatiereid() {
        return matiereid;
    }

    public void setMatiereid(Matiere matiereid) {
        this.matiereid = matiereid;
    }

    public Professeur getProfesseurPersonneid() {
        return professeurPersonneid;
    }

    public void setProfesseurPersonneid(Professeur professeurPersonneid) {
        this.professeurPersonneid = professeurPersonneid;
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
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Cours[ id=" + id + " ]";
    }
    
}
