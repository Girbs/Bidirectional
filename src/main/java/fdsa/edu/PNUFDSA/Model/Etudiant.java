/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByCodeEtudiant", query = "SELECT e FROM Etudiant e WHERE e.codeEtudiant = :codeEtudiant"),
    @NamedQuery(name = "Etudiant.findByMatricule", query = "SELECT e FROM Etudiant e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Etudiant.findByPersonneid", query = "SELECT e FROM Etudiant e WHERE e.personneid = :personneid")})
 
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "code_etudiant")
    private String codeEtudiant;
    @Column(name = "matricule")
    private String matricule;
    @Id
    @Basic(optional = false)
    @Column(name = "personneid")
    private Integer personneid;
    @ManyToMany(mappedBy = "etudiantList")
    private List<Promotion> promotionList;
    @ManyToMany(mappedBy = "etudiantList")
    private List<Programme> programmeList;
    @ManyToMany(mappedBy = "etudiantList")
    private List<Cours> coursList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantPersonneid")
    private List<Paiement> paiementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantPersonneid")
    private List<Requete> requeteList;
    @JoinColumn(name = "personneid", referencedColumnName = "personneid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utlilisateur utlilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantPersonneid")
    private List<HistoriqueExam> historiqueExamList;
    @OneToMany(mappedBy = "etudiantPersonneid")
    private List<PaiementSession> paiementSessionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantPersonneid")
    private List<Stage> stageList;

    public Etudiant() {
    }

    public Etudiant(Integer personneid) {
        this.personneid = personneid;
    }

    public String getCodeEtudiant() {
        return codeEtudiant;
    }

    public void setCodeEtudiant(String codeEtudiant) {
        this.codeEtudiant = codeEtudiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Integer getPersonneid() {
        return personneid;
    }

    public void setPersonneid(Integer personneid) {
        this.personneid = personneid;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    public List<Programme> getProgrammeList() {
        return programmeList;
    }

    public void setProgrammeList(List<Programme> programmeList) {
        this.programmeList = programmeList;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public List<Requete> getRequeteList() {
        return requeteList;
    }

    public void setRequeteList(List<Requete> requeteList) {
        this.requeteList = requeteList;
    }

    public Utlilisateur getUtlilisateur() {
        return utlilisateur;
    }

    public void setUtlilisateur(Utlilisateur utlilisateur) {
        this.utlilisateur = utlilisateur;
    }

    public List<HistoriqueExam> getHistoriqueExamList() {
        return historiqueExamList;
    }

    public void setHistoriqueExamList(List<HistoriqueExam> historiqueExamList) {
        this.historiqueExamList = historiqueExamList;
    }

    public List<PaiementSession> getPaiementSessionList() {
        return paiementSessionList;
    }

    public void setPaiementSessionList(List<PaiementSession> paiementSessionList) {
        this.paiementSessionList = paiementSessionList;
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.personneid == null && other.personneid != null) || (this.personneid != null && !this.personneid.equals(other.personneid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Etudiant[ personneid=" + personneid + " ]";
    }
    
}
