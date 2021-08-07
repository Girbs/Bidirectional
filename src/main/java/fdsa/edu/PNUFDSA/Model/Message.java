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
@Table(name = "message")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id"),
    @NamedQuery(name = "Message.findByAttachement", query = "SELECT m FROM Message m WHERE m.attachement = :attachement"),
    @NamedQuery(name = "Message.findByContenu", query = "SELECT m FROM Message m WHERE m.contenu = :contenu")})
 
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "attachement")
    private String attachement;
    @Column(name = "contenu")
    private String contenu;
    @JoinColumn(name = "discussionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Discussion discussionid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageid")
    private List<Message> messageList;
    @JoinColumn(name = "messageid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Message messageid;
    @JoinColumn(name = "etudiant_personneid", referencedColumnName = "personneid")
    @ManyToOne(optional = false)
    private Utlilisateur etudiantPersonneid;

    public Message() {
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Discussion getDiscussionid() {
        return discussionid;
    }

    public void setDiscussionid(Discussion discussionid) {
        this.discussionid = discussionid;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Message getMessageid() {
        return messageid;
    }

    public void setMessageid(Message messageid) {
        this.messageid = messageid;
    }

    public Utlilisateur getEtudiantPersonneid() {
        return etudiantPersonneid;
    }

    public void setEtudiantPersonneid(Utlilisateur etudiantPersonneid) {
        this.etudiantPersonneid = etudiantPersonneid;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Message[ id=" + id + " ]";
    }
    
}
