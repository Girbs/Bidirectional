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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "departement_geographique")
@NamedQueries({
    @NamedQuery(name = "DepartementGeographique.findAll", query = "SELECT d FROM DepartementGeographique d"),
    @NamedQuery(name = "DepartementGeographique.findById", query = "SELECT d FROM DepartementGeographique d WHERE d.id = :id"),
    @NamedQuery(name = "DepartementGeographique.findByDescription", query = "SELECT d FROM DepartementGeographique d WHERE d.description = :description")})
 
public class DepartementGeographique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departementGeographiqueid")
    private List<Commune> communeList;

    public DepartementGeographique() {
    }

    public DepartementGeographique(Integer id) {
        this.id = id;
    }

    public DepartementGeographique(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Commune> getCommuneList() {
        return communeList;
    }

    public void setCommuneList(List<Commune> communeList) {
        this.communeList = communeList;
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
        if (!(object instanceof DepartementGeographique)) {
            return false;
        }
        DepartementGeographique other = (DepartementGeographique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.DepartementGeographique[ id=" + id + " ]";
    }
    
}
