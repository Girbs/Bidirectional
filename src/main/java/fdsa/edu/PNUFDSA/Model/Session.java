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

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "session")
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findById", query = "SELECT s FROM Session s WHERE s.id = :id"),
    @NamedQuery(name = "Session.findByCodeSession", query = "SELECT s FROM Session s WHERE s.codeSession = :codeSession"),
    @NamedQuery(name = "Session.findByDescriptionSession", query = "SELECT s FROM Session s WHERE s.descriptionSession = :descriptionSession"),
    @NamedQuery(name = "Session.findByOrdre", query = "SELECT s FROM Session s WHERE s.ordre = :ordre")})
 
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code_session")
    private String codeSession;
    @Column(name = "description_session")
    private String descriptionSession;
    @Basic(optional = false)
    @Column(name = "ordre")
    private int ordre;
    @JoinTable(name = "cours_session", joinColumns = {
        @JoinColumn(name = "sessionid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "coursid", referencedColumnName = "id")})
    @ManyToMany
    private List<Cours> coursList;
    @OneToMany(mappedBy = "sessionid")
    private List<Paiement> paiementList;
    @JoinColumn(name = "programmeid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Programme programmeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionid")
    private List<PaiementSession> paiementSessionList;

    public Session() {
    }

    public Session(Integer id) {
        this.id = id;
    }

    public Session(Integer id, int ordre) {
        this.id = id;
        this.ordre = ordre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeSession() {
        return codeSession;
    }

    public void setCodeSession(String codeSession) {
        this.codeSession = codeSession;
    }

    public String getDescriptionSession() {
        return descriptionSession;
    }

    public void setDescriptionSession(String descriptionSession) {
        this.descriptionSession = descriptionSession;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
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

    public Programme getProgrammeid() {
        return programmeid;
    }

    public void setProgrammeid(Programme programmeid) {
        this.programmeid = programmeid;
    }

    public List<PaiementSession> getPaiementSessionList() {
        return paiementSessionList;
    }

    public void setPaiementSessionList(List<PaiementSession> paiementSessionList) {
        this.paiementSessionList = paiementSessionList;
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
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Session[ id=" + id + " ]";
    }
    
}
