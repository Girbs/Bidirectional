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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "groupe")
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findById", query = "SELECT g FROM Groupe g WHERE g.id = :id"),
    @NamedQuery(name = "Groupe.findByNom", query = "SELECT g FROM Groupe g WHERE g.nom = :nom"),
    @NamedQuery(name = "Groupe.findByPhoto", query = "SELECT g FROM Groupe g WHERE g.photo = :photo"),
    @NamedQuery(name = "Groupe.findByUtlilisateurPersonneid", query = "SELECT g FROM Groupe g WHERE g.utlilisateurPersonneid = :utlilisateurPersonneid")})

public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "utlilisateur_personneid")
    private int utlilisateurPersonneid;
    @ManyToMany(mappedBy = "groupeList")
    private List<Utlilisateur> utlilisateurList;
    @OneToMany(mappedBy = "groupeId")
    private List<Discussion> discussionList;

    public Groupe() {
    }

    public Groupe(Integer id) {
        this.id = id;
    }

    public Groupe(Integer id, int utlilisateurPersonneid) {
        this.id = id;
        this.utlilisateurPersonneid = utlilisateurPersonneid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getUtlilisateurPersonneid() {
        return utlilisateurPersonneid;
    }

    public void setUtlilisateurPersonneid(int utlilisateurPersonneid) {
        this.utlilisateurPersonneid = utlilisateurPersonneid;
    }

    public List<Utlilisateur> getUtlilisateurList() {
        return utlilisateurList;
    }

    public void setUtlilisateurList(List<Utlilisateur> utlilisateurList) {
        this.utlilisateurList = utlilisateurList;
    }

    public List<Discussion> getDiscussionList() {
        return discussionList;
    }

    public void setDiscussionList(List<Discussion> discussionList) {
        this.discussionList = discussionList;
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
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Groupe[ id=" + id + " ]";
    }
    
}
