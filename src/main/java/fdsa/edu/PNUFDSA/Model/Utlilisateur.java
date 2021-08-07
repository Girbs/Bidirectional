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
import javax.persistence.JoinTable;
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
@Table(name = "utlilisateur")
@NamedQueries({
    @NamedQuery(name = "Utlilisateur.findAll", query = "SELECT u FROM Utlilisateur u"),
    @NamedQuery(name = "Utlilisateur.findByPassword", query = "SELECT u FROM Utlilisateur u WHERE u.password = :password"),
    @NamedQuery(name = "Utlilisateur.findByStatus", query = "SELECT u FROM Utlilisateur u WHERE u.status = :status"),
    @NamedQuery(name = "Utlilisateur.findByUsername", query = "SELECT u FROM Utlilisateur u WHERE u.username = :username"),
    @NamedQuery(name = "Utlilisateur.findByPersonneid", query = "SELECT u FROM Utlilisateur u WHERE u.personneid = :personneid")})

public class Utlilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Column(name = "username")
    private String username;
    @Id
    @Basic(optional = false)
    @Column(name = "personneid")
    private Integer personneid;
    @JoinTable(name = "utlilisateur_groupe", joinColumns = {
        @JoinColumn(name = "utlilisateur_personneid", referencedColumnName = "personneid")}, inverseJoinColumns = {
        @JoinColumn(name = "groupeid", referencedColumnName = "id")})
    @ManyToMany
    private List<Groupe> groupeList;
    @ManyToMany(mappedBy = "utlilisateurList")
    private List<Role> roleList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utlilisateurPersonneid")
    private Postulant postulant;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utlilisateur")
    private Etudiant etudiant;
    @JoinColumn(name = "personneid", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utlilisateur")
    private Professeur professeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantPersonneid")
    private List<Message> messageList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utlilisateur")
    private Personnel personnel;

    public Utlilisateur() {
    }

    public Utlilisateur(Integer personneid) {
        this.personneid = personneid;
    }

    public Utlilisateur(Integer personneid, boolean status) {
        this.personneid = personneid;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPersonneid() {
        return personneid;
    }

    public void setPersonneid(Integer personneid) {
        this.personneid = personneid;
    }

    public List<Groupe> getGroupeList() {
        return groupeList;
    }

    public void setGroupeList(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
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
        if (!(object instanceof Utlilisateur)) {
            return false;
        }
        Utlilisateur other = (Utlilisateur) object;
        if ((this.personneid == null && other.personneid != null) || (this.personneid != null && !this.personneid.equals(other.personneid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Utlilisateur[ personneid=" + personneid + " ]";
    }
    
}
