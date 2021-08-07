/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "stage")
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
    @NamedQuery(name = "Stage.findById", query = "SELECT s FROM Stage s WHERE s.id = :id"),
    @NamedQuery(name = "Stage.findByCommentaire", query = "SELECT s FROM Stage s WHERE s.commentaire = :commentaire"),
    @NamedQuery(name = "Stage.findByDateDebut", query = "SELECT s FROM Stage s WHERE s.dateDebut = :dateDebut"),
    @NamedQuery(name = "Stage.findByDateFin", query = "SELECT s FROM Stage s WHERE s.dateFin = :dateFin"),
    @NamedQuery(name = "Stage.findByTitre", query = "SELECT s FROM Stage s WHERE s.titre = :titre")})
 
public class Stage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "titre")
    private String titre;
    @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")
    @ManyToOne(optional = false)
    private Etudiant etudiantPersonneid;
    @JoinColumn(name = "institutionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    
    private Institution institutionid;

    public Stage() {
    }

    public Stage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Etudiant getEtudiantPersonneid() {
        return etudiantPersonneid;
    }

    public void setEtudiantPersonneid(Etudiant etudiantPersonneid) {
        this.etudiantPersonneid = etudiantPersonneid;
    }

    public Institution getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(Institution institutionid) {
        this.institutionid = institutionid;
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
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Stage[ id=" + id + " ]";
    }
    
}
