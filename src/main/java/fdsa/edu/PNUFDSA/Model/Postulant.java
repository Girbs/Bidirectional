/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ing.Girbson BIJOU
 */
@Entity
@Table(name = "postulant")
@NamedQueries({
    @NamedQuery(name = "Postulant.findAll", query = "SELECT p FROM Postulant p"),
    @NamedQuery(name = "Postulant.findById", query = "SELECT p FROM Postulant p WHERE p.id = :id"),
    @NamedQuery(name = "Postulant.findByNifcin", query = "SELECT p FROM Postulant p WHERE p.nifcin = :nifcin"),
    @NamedQuery(name = "Postulant.findByAdresse", query = "SELECT p FROM Postulant p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Postulant.findByAdresseDernireInstitutionFrquente", query = "SELECT p FROM Postulant p WHERE p.adresseDernireInstitutionFrquente = :adresseDernireInstitutionFrquente"),
    @NamedQuery(name = "Postulant.findByAdresseEtudeUniversitaire", query = "SELECT p FROM Postulant p WHERE p.adresseEtudeUniversitaire = :adresseEtudeUniversitaire"),
    @NamedQuery(name = "Postulant.findByAdressedelhopitalClinique", query = "SELECT p FROM Postulant p WHERE p.adressedelhopitalClinique = :adressedelhopitalClinique"),
    @NamedQuery(name = "Postulant.findByAutreMaladie", query = "SELECT p FROM Postulant p WHERE p.autreMaladie = :autreMaladie"),
    @NamedQuery(name = "Postulant.findByAutreNationalite", query = "SELECT p FROM Postulant p WHERE p.autreNationalite = :autreNationalite"),
    @NamedQuery(name = "Postulant.findByAvezvousdjsoumisunedemandedadmi", query = "SELECT p FROM Postulant p WHERE p.avezvousdjsoumisunedemandedadmi = :avezvousdjsoumisunedemandedadmi"),
    @NamedQuery(name = "Postulant.findByCitoyennet", query = "SELECT p FROM Postulant p WHERE p.citoyennet = :citoyennet"),
    @NamedQuery(name = "Postulant.findByCommune", query = "SELECT p FROM Postulant p WHERE p.commune = :commune"),
    @NamedQuery(name = "Postulant.findByConsentementdupostulant", query = "SELECT p FROM Postulant p WHERE p.consentementdupostulant = :consentementdupostulant"),
    @NamedQuery(name = "Postulant.findByCurrentGenerators", query = "SELECT p FROM Postulant p WHERE p.currentGenerators = :currentGenerators"),
    @NamedQuery(name = "Postulant.findByDateAncienneDemande", query = "SELECT p FROM Postulant p WHERE p.dateAncienneDemande = :dateAncienneDemande"),
    @NamedQuery(name = "Postulant.findByDatedelademande", query = "SELECT p FROM Postulant p WHERE p.datedelademande = :datedelademande"),
    @NamedQuery(name = "Postulant.findByDatedenaissance", query = "SELECT p FROM Postulant p WHERE p.datedenaissance = :datedenaissance"),
    @NamedQuery(name = "Postulant.findByDatedobtentionbacci", query = "SELECT p FROM Postulant p WHERE p.datedobtentionbacci = :datedobtentionbacci"),
    @NamedQuery(name = "Postulant.findByDatedobtentionbaccii", query = "SELECT p FROM Postulant p WHERE p.datedobtentionbaccii = :datedobtentionbaccii"),
    @NamedQuery(name = "Postulant.findByDbutEtudeProfessionnelles", query = "SELECT p FROM Postulant p WHERE p.dbutEtudeProfessionnelles = :dbutEtudeProfessionnelles"),
    @NamedQuery(name = "Postulant.findByDebutEtudeUniversitaire", query = "SELECT p FROM Postulant p WHERE p.debutEtudeUniversitaire = :debutEtudeUniversitaire"),
    @NamedQuery(name = "Postulant.findByDepratement", query = "SELECT p FROM Postulant p WHERE p.depratement = :depratement"),
    @NamedQuery(name = "Postulant.findByDirecteurDernireInstitutionFrquent", query = "SELECT p FROM Postulant p WHERE p.directeurDernireInstitutionFrquent = :directeurDernireInstitutionFrquent"),
    @NamedQuery(name = "Postulant.findByDirecteurEtudeProfessionnelles", query = "SELECT p FROM Postulant p WHERE p.directeurEtudeProfessionnelles = :directeurEtudeProfessionnelles"),
    @NamedQuery(name = "Postulant.findByDiscplineEtudeSecondaire", query = "SELECT p FROM Postulant p WHERE p.discplineEtudeSecondaire = :discplineEtudeSecondaire"),
    @NamedQuery(name = "Postulant.findByEmail", query = "SELECT p FROM Postulant p WHERE p.email = :email"),
    @NamedQuery(name = "Postulant.findByEmploiDateDebut1", query = "SELECT p FROM Postulant p WHERE p.emploiDateDebut1 = :emploiDateDebut1"),
    @NamedQuery(name = "Postulant.findByEmploiDateDebut2", query = "SELECT p FROM Postulant p WHERE p.emploiDateDebut2 = :emploiDateDebut2"),
    @NamedQuery(name = "Postulant.findByEmploiDateDebut3", query = "SELECT p FROM Postulant p WHERE p.emploiDateDebut3 = :emploiDateDebut3"),
    @NamedQuery(name = "Postulant.findByEmploiDateFin1", query = "SELECT p FROM Postulant p WHERE p.emploiDateFin1 = :emploiDateFin1"),
    @NamedQuery(name = "Postulant.findByEmploiDateFin2", query = "SELECT p FROM Postulant p WHERE p.emploiDateFin2 = :emploiDateFin2"),
    @NamedQuery(name = "Postulant.findByEmploiDateFin3", query = "SELECT p FROM Postulant p WHERE p.emploiDateFin3 = :emploiDateFin3"),
    @NamedQuery(name = "Postulant.findByEtesvousreconnupourunepersonnemala", query = "SELECT p FROM Postulant p WHERE p.etesvousreconnupourunepersonnemala = :etesvousreconnupourunepersonnemala"),
    @NamedQuery(name = "Postulant.findByEtudeUniversitaireTelephone", query = "SELECT p FROM Postulant p WHERE p.etudeUniversitaireTelephone = :etudeUniversitaireTelephone"),
    @NamedQuery(name = "Postulant.findByFilliere", query = "SELECT p FROM Postulant p WHERE p.filliere = :filliere"),
    @NamedQuery(name = "Postulant.findByFinEtudeProfessionnelles", query = "SELECT p FROM Postulant p WHERE p.finEtudeProfessionnelles = :finEtudeProfessionnelles"),
    @NamedQuery(name = "Postulant.findByFinEtudeUniversitaire", query = "SELECT p FROM Postulant p WHERE p.finEtudeUniversitaire = :finEtudeUniversitaire"),
    @NamedQuery(name = "Postulant.findByFonctionEmploi1", query = "SELECT p FROM Postulant p WHERE p.fonctionEmploi1 = :fonctionEmploi1"),
    @NamedQuery(name = "Postulant.findByFonctionEmploi2", query = "SELECT p FROM Postulant p WHERE p.fonctionEmploi2 = :fonctionEmploi2"),
    @NamedQuery(name = "Postulant.findByFonctionEmploi3", query = "SELECT p FROM Postulant p WHERE p.fonctionEmploi3 = :fonctionEmploi3"),
    @NamedQuery(name = "Postulant.findByHpitalClinique", query = "SELECT p FROM Postulant p WHERE p.hpitalClinique = :hpitalClinique"),
    @NamedQuery(name = "Postulant.findByIndiqueznousvotremaladie", query = "SELECT p FROM Postulant p WHERE p.indiqueznousvotremaladie = :indiqueznousvotremaladie"),
    @NamedQuery(name = "Postulant.findByInstititionEtudeUniversitaire", query = "SELECT p FROM Postulant p WHERE p.instititionEtudeUniversitaire = :instititionEtudeUniversitaire"),
    @NamedQuery(name = "Postulant.findByInstitutionEtudeProfessionnelles", query = "SELECT p FROM Postulant p WHERE p.institutionEtudeProfessionnelles = :institutionEtudeProfessionnelles"),
    @NamedQuery(name = "Postulant.findByJedsireentreprendremestudesla", query = "SELECT p FROM Postulant p WHERE p.jedsireentreprendremestudesla = :jedsireentreprendremestudesla"),
    @NamedQuery(name = "Postulant.findByLangueMaternelle", query = "SELECT p FROM Postulant p WHERE p.langueMaternelle = :langueMaternelle"),
    @NamedQuery(name = "Postulant.findByLanguedusage", query = "SELECT p FROM Postulant p WHERE p.languedusage = :languedusage"),
    @NamedQuery(name = "Postulant.findByLieunaissance", query = "SELECT p FROM Postulant p WHERE p.lieunaissance = :lieunaissance"),
    @NamedQuery(name = "Postulant.findByListedevosmdicamentshabituels", query = "SELECT p FROM Postulant p WHERE p.listedevosmdicamentshabituels = :listedevosmdicamentshabituels"),
    @NamedQuery(name = "Postulant.findByMatricle", query = "SELECT p FROM Postulant p WHERE p.matricle = :matricle"),
    @NamedQuery(name = "Postulant.findByMdecindeFamille", query = "SELECT p FROM Postulant p WHERE p.mdecindeFamille = :mdecindeFamille"),
    @NamedQuery(name = "Postulant.findByNom", query = "SELECT p FROM Postulant p WHERE p.nom = :nom"),
    @NamedQuery(name = "Postulant.findByNomDernireInstitutionFrquente", query = "SELECT p FROM Postulant p WHERE p.nomDernireInstitutionFrquente = :nomDernireInstitutionFrquente"),
    @NamedQuery(name = "Postulant.findByNomDuDoyenEtudeUnirversitaire", query = "SELECT p FROM Postulant p WHERE p.nomDuDoyenEtudeUnirversitaire = :nomDuDoyenEtudeUnirversitaire"),
    @NamedQuery(name = "Postulant.findByNomEmployeur1", query = "SELECT p FROM Postulant p WHERE p.nomEmployeur1 = :nomEmployeur1"),
    @NamedQuery(name = "Postulant.findByNomEmployeur2", query = "SELECT p FROM Postulant p WHERE p.nomEmployeur2 = :nomEmployeur2"),
    @NamedQuery(name = "Postulant.findByNomEmployeur3", query = "SELECT p FROM Postulant p WHERE p.nomEmployeur3 = :nomEmployeur3"),
    @NamedQuery(name = "Postulant.findByNombredanneedeServicedelHopital", query = "SELECT p FROM Postulant p WHERE p.nombredanneedeServicedelHopital = :nombredanneedeServicedelHopital"),
    @NamedQuery(name = "Postulant.findByNumberofLocations", query = "SELECT p FROM Postulant p WHERE p.numberofLocations = :numberofLocations"),
    @NamedQuery(name = "Postulant.findByPourquelsemestre", query = "SELECT p FROM Postulant p WHERE p.pourquelsemestre = :pourquelsemestre"),
    @NamedQuery(name = "Postulant.findByPrenom", query = "SELECT p FROM Postulant p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Postulant.findByPrimaire", query = "SELECT p FROM Postulant p WHERE p.primaire = :primaire"),
    @NamedQuery(name = "Postulant.findByProductInterest", query = "SELECT p FROM Postulant p WHERE p.productInterest = :productInterest"),
    @NamedQuery(name = "Postulant.findBySexe", query = "SELECT p FROM Postulant p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Postulant.findBySiOuiPrecisezladatedelademande", query = "SELECT p FROM Postulant p WHERE p.siOuiPrecisezladatedelademande = :siOuiPrecisezladatedelademande"),
    @NamedQuery(name = "Postulant.findBySpecialiteHopitalClinique", query = "SELECT p FROM Postulant p WHERE p.specialiteHopitalClinique = :specialiteHopitalClinique"),
    @NamedQuery(name = "Postulant.findByStatutDiplomeUniversitaire", query = "SELECT p FROM Postulant p WHERE p.statutDiplomeUniversitaire = :statutDiplomeUniversitaire"),
    @NamedQuery(name = "Postulant.findByTelephone1", query = "SELECT p FROM Postulant p WHERE p.telephone1 = :telephone1"),
    @NamedQuery(name = "Postulant.findByTelephone2", query = "SELECT p FROM Postulant p WHERE p.telephone2 = :telephone2"),
    @NamedQuery(name = "Postulant.findByTelephoneHopital", query = "SELECT p FROM Postulant p WHERE p.telephoneHopital = :telephoneHopital"),
    @NamedQuery(name = "Postulant.findByTitreDiplomeEtudeProfessionnelles", query = "SELECT p FROM Postulant p WHERE p.titreDiplomeEtudeProfessionnelles = :titreDiplomeEtudeProfessionnelles"),
    @NamedQuery(name = "Postulant.findByTlphoneDernireInstitutionFrquent", query = "SELECT p FROM Postulant p WHERE p.tlphoneDernireInstitutionFrquent = :tlphoneDernireInstitutionFrquent"),
    @NamedQuery(name = "Postulant.findByTlphoneEtudeProfessionnelles", query = "SELECT p FROM Postulant p WHERE p.tlphoneEtudeProfessionnelles = :tlphoneEtudeProfessionnelles"),
    @NamedQuery(name = "Postulant.findByTypeDetudeSollicite", query = "SELECT p FROM Postulant p WHERE p.typeDetudeSollicite = :typeDetudeSollicite"),
    @NamedQuery(name = "Postulant.findByTypedemploi", query = "SELECT p FROM Postulant p WHERE p.typedemploi = :typedemploi"),
    @NamedQuery(name = "Postulant.findByTypedemploi2", query = "SELECT p FROM Postulant p WHERE p.typedemploi2 = :typedemploi2"),
    @NamedQuery(name = "Postulant.findByTypedemploi3", query = "SELECT p FROM Postulant p WHERE p.typedemploi3 = :typedemploi3"),
    @NamedQuery(name = "Postulant.findByUrgenceNom1", query = "SELECT p FROM Postulant p WHERE p.urgenceNom1 = :urgenceNom1"),
    @NamedQuery(name = "Postulant.findByUrgenceNom2", query = "SELECT p FROM Postulant p WHERE p.urgenceNom2 = :urgenceNom2"),
    @NamedQuery(name = "Postulant.findByUrgencePrnom1", query = "SELECT p FROM Postulant p WHERE p.urgencePrnom1 = :urgencePrnom1"),
    @NamedQuery(name = "Postulant.findByUrgencePrnom2", query = "SELECT p FROM Postulant p WHERE p.urgencePrnom2 = :urgencePrnom2"),
    @NamedQuery(name = "Postulant.findByVacationsollicite", query = "SELECT p FROM Postulant p WHERE p.vacationsollicite = :vacationsollicite")})
 
public class Postulant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nifcin")
    private String nifcin;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "adresse_dernire_institution_frquente")
    private String adresseDernireInstitutionFrquente;
    @Column(name = "adresse_etude_universitaire")
    private String adresseEtudeUniversitaire;
    @Column(name = "adressedelhopital_clinique")
    private String adressedelhopitalClinique;
    @Column(name = "autre_maladie")
    private String autreMaladie;
    @Column(name = "autre_nationalite")
    private String autreNationalite;
    @Column(name = "avezvousdjsoumisunedemandedadmi")
    private String avezvousdjsoumisunedemandedadmi;
    @Column(name = "citoyennet")
    private String citoyennet;
    @Column(name = "commune")
    private String commune;
    @Column(name = "consentementdupostulant")
    private String consentementdupostulant;
    @Column(name = "current_generators")
    private String currentGenerators;
    @Column(name = "date_ancienne_demande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAncienneDemande;
    @Column(name = "datedelademande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedelademande;
    @Column(name = "datedenaissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedenaissance;
    @Column(name = "datedobtentionbacci")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedobtentionbacci;
    @Column(name = "datedobtentionbaccii")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedobtentionbaccii;
    @Column(name = "dbut_etude_professionnelles")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbutEtudeProfessionnelles;
    @Column(name = "debut_etude_universitaire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutEtudeUniversitaire;
    @Column(name = "depratement")
    private String depratement;
    @Column(name = "directeur_dernire_institution_frquent")
    private String directeurDernireInstitutionFrquent;
    @Column(name = "directeur_etude_professionnelles")
    private String directeurEtudeProfessionnelles;
    @Column(name = "discpline_etude_secondaire")
    private String discplineEtudeSecondaire;
    @Column(name = "email")
    private String email;
    @Column(name = "emploi_date_debut1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emploiDateDebut1;
    @Column(name = "emploi_date_debut2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emploiDateDebut2;
    @Column(name = "emploi_date_debut3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emploiDateDebut3;
    @Column(name = "emploi_date_fin1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emploiDateFin1;
    @Column(name = "emploi_date_fin2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emploiDateFin2;
    @Column(name = "emploi_date_fin3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emploiDateFin3;
    @Column(name = "etesvousreconnupourunepersonnemala")
    private String etesvousreconnupourunepersonnemala;
    @Column(name = "etude_universitaire_telephone")
    private String etudeUniversitaireTelephone;
    @Column(name = "filliere")
    private String filliere;
    @Column(name = "fin_etude_professionnelles")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finEtudeProfessionnelles;
    @Column(name = "fin_etude_universitaire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finEtudeUniversitaire;
    @Column(name = "fonction_emploi1")
    private String fonctionEmploi1;
    @Column(name = "fonction_emploi2")
    private String fonctionEmploi2;
    @Column(name = "fonction_emploi3")
    private String fonctionEmploi3;
    @Column(name = "hpital_clinique")
    private String hpitalClinique;
    @Column(name = "indiqueznousvotremaladie")
    private String indiqueznousvotremaladie;
    @Column(name = "institition_etude_universitaire")
    private String instititionEtudeUniversitaire;
    @Column(name = "institution_etude_professionnelles")
    private String institutionEtudeProfessionnelles;
    @Column(name = "jedsireentreprendremestudesla")
    private String jedsireentreprendremestudesla;
    @Column(name = "langue_maternelle")
    private String langueMaternelle;
    @Column(name = "languedusage")
    private String languedusage;
    @Column(name = "lieunaissance")
    private String lieunaissance;
    @Column(name = "listedevosmdicamentshabituels")
    private String listedevosmdicamentshabituels;
    @Column(name = "matricle")
    private String matricle;
    @Column(name = "mdecinde_famille")
    private String mdecindeFamille;
    @Column(name = "nom")
    private String nom;
    @Column(name = "nom_dernire_institution_frquente")
    private String nomDernireInstitutionFrquente;
    @Column(name = "nom_du_doyen_etude_unirversitaire")
    private String nomDuDoyenEtudeUnirversitaire;
    @Column(name = "nom_employeur1")
    private String nomEmployeur1;
    @Column(name = "nom_employeur2")
    private String nomEmployeur2;
    @Column(name = "nom_employeur3")
    private String nomEmployeur3;
    @Column(name = "nombredanneede_servicedel_hopital")
    private String nombredanneedeServicedelHopital;
    @Column(name = "numberof_locations")
    private Integer numberofLocations;
    @Column(name = "pourquelsemestre")
    private String pourquelsemestre;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "primaire")
    private String primaire;
    @Column(name = "product_interest")
    private String productInterest;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "si_oui_precisezladatedelademande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siOuiPrecisezladatedelademande;
    @Column(name = "specialite_hopital_clinique")
    private String specialiteHopitalClinique;
    @Column(name = "statut_diplome_universitaire")
    private String statutDiplomeUniversitaire;
    @Column(name = "telephone1")
    private String telephone1;
    @Column(name = "telephone2")
    private String telephone2;
    @Column(name = "telephone_hopital")
    private String telephoneHopital;
    @Column(name = "titre_diplome_etude_professionnelles")
    private String titreDiplomeEtudeProfessionnelles;
    @Column(name = "tlphone_dernire_institution_frquent")
    private String tlphoneDernireInstitutionFrquent;
    @Column(name = "tlphone_etude_professionnelles")
    private String tlphoneEtudeProfessionnelles;
    @Column(name = "type_detude_sollicite")
    private String typeDetudeSollicite;
    @Column(name = "typedemploi")
    private String typedemploi;
    @Column(name = "typedemploi2")
    private String typedemploi2;
    @Column(name = "typedemploi3")
    private String typedemploi3;
    @Column(name = "urgence_nom1")
    private String urgenceNom1;
    @Column(name = "urgence_nom2")
    private String urgenceNom2;
    @Column(name = "urgence_prnom1")
    private String urgencePrnom1;
    @Column(name = "urgence_prnom2")
    private String urgencePrnom2;
    @Column(name = "vacationsollicite")
    private String vacationsollicite;
    @JoinColumn(name = "utlilisateur_personneid", referencedColumnName = "personneid")
    @OneToOne(optional = false)
    private Utlilisateur utlilisateurPersonneid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postulantid")
    private List<HistoriqueExamenConcours> historiqueExamenConcoursList;

    public Postulant() {
    }

    public Postulant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNifcin() {
        return nifcin;
    }

    public void setNifcin(String nifcin) {
        this.nifcin = nifcin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresseDernireInstitutionFrquente() {
        return adresseDernireInstitutionFrquente;
    }

    public void setAdresseDernireInstitutionFrquente(String adresseDernireInstitutionFrquente) {
        this.adresseDernireInstitutionFrquente = adresseDernireInstitutionFrquente;
    }

    public String getAdresseEtudeUniversitaire() {
        return adresseEtudeUniversitaire;
    }

    public void setAdresseEtudeUniversitaire(String adresseEtudeUniversitaire) {
        this.adresseEtudeUniversitaire = adresseEtudeUniversitaire;
    }

    public String getAdressedelhopitalClinique() {
        return adressedelhopitalClinique;
    }

    public void setAdressedelhopitalClinique(String adressedelhopitalClinique) {
        this.adressedelhopitalClinique = adressedelhopitalClinique;
    }

    public String getAutreMaladie() {
        return autreMaladie;
    }

    public void setAutreMaladie(String autreMaladie) {
        this.autreMaladie = autreMaladie;
    }

    public String getAutreNationalite() {
        return autreNationalite;
    }

    public void setAutreNationalite(String autreNationalite) {
        this.autreNationalite = autreNationalite;
    }

    public String getAvezvousdjsoumisunedemandedadmi() {
        return avezvousdjsoumisunedemandedadmi;
    }

    public void setAvezvousdjsoumisunedemandedadmi(String avezvousdjsoumisunedemandedadmi) {
        this.avezvousdjsoumisunedemandedadmi = avezvousdjsoumisunedemandedadmi;
    }

    public String getCitoyennet() {
        return citoyennet;
    }

    public void setCitoyennet(String citoyennet) {
        this.citoyennet = citoyennet;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getConsentementdupostulant() {
        return consentementdupostulant;
    }

    public void setConsentementdupostulant(String consentementdupostulant) {
        this.consentementdupostulant = consentementdupostulant;
    }

    public String getCurrentGenerators() {
        return currentGenerators;
    }

    public void setCurrentGenerators(String currentGenerators) {
        this.currentGenerators = currentGenerators;
    }

    public Date getDateAncienneDemande() {
        return dateAncienneDemande;
    }

    public void setDateAncienneDemande(Date dateAncienneDemande) {
        this.dateAncienneDemande = dateAncienneDemande;
    }

    public Date getDatedelademande() {
        return datedelademande;
    }

    public void setDatedelademande(Date datedelademande) {
        this.datedelademande = datedelademande;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public Date getDatedobtentionbacci() {
        return datedobtentionbacci;
    }

    public void setDatedobtentionbacci(Date datedobtentionbacci) {
        this.datedobtentionbacci = datedobtentionbacci;
    }

    public Date getDatedobtentionbaccii() {
        return datedobtentionbaccii;
    }

    public void setDatedobtentionbaccii(Date datedobtentionbaccii) {
        this.datedobtentionbaccii = datedobtentionbaccii;
    }

    public Date getDbutEtudeProfessionnelles() {
        return dbutEtudeProfessionnelles;
    }

    public void setDbutEtudeProfessionnelles(Date dbutEtudeProfessionnelles) {
        this.dbutEtudeProfessionnelles = dbutEtudeProfessionnelles;
    }

    public Date getDebutEtudeUniversitaire() {
        return debutEtudeUniversitaire;
    }

    public void setDebutEtudeUniversitaire(Date debutEtudeUniversitaire) {
        this.debutEtudeUniversitaire = debutEtudeUniversitaire;
    }

    public String getDepratement() {
        return depratement;
    }

    public void setDepratement(String depratement) {
        this.depratement = depratement;
    }

    public String getDirecteurDernireInstitutionFrquent() {
        return directeurDernireInstitutionFrquent;
    }

    public void setDirecteurDernireInstitutionFrquent(String directeurDernireInstitutionFrquent) {
        this.directeurDernireInstitutionFrquent = directeurDernireInstitutionFrquent;
    }

    public String getDirecteurEtudeProfessionnelles() {
        return directeurEtudeProfessionnelles;
    }

    public void setDirecteurEtudeProfessionnelles(String directeurEtudeProfessionnelles) {
        this.directeurEtudeProfessionnelles = directeurEtudeProfessionnelles;
    }

    public String getDiscplineEtudeSecondaire() {
        return discplineEtudeSecondaire;
    }

    public void setDiscplineEtudeSecondaire(String discplineEtudeSecondaire) {
        this.discplineEtudeSecondaire = discplineEtudeSecondaire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEmploiDateDebut1() {
        return emploiDateDebut1;
    }

    public void setEmploiDateDebut1(Date emploiDateDebut1) {
        this.emploiDateDebut1 = emploiDateDebut1;
    }

    public Date getEmploiDateDebut2() {
        return emploiDateDebut2;
    }

    public void setEmploiDateDebut2(Date emploiDateDebut2) {
        this.emploiDateDebut2 = emploiDateDebut2;
    }

    public Date getEmploiDateDebut3() {
        return emploiDateDebut3;
    }

    public void setEmploiDateDebut3(Date emploiDateDebut3) {
        this.emploiDateDebut3 = emploiDateDebut3;
    }

    public Date getEmploiDateFin1() {
        return emploiDateFin1;
    }

    public void setEmploiDateFin1(Date emploiDateFin1) {
        this.emploiDateFin1 = emploiDateFin1;
    }

    public Date getEmploiDateFin2() {
        return emploiDateFin2;
    }

    public void setEmploiDateFin2(Date emploiDateFin2) {
        this.emploiDateFin2 = emploiDateFin2;
    }

    public Date getEmploiDateFin3() {
        return emploiDateFin3;
    }

    public void setEmploiDateFin3(Date emploiDateFin3) {
        this.emploiDateFin3 = emploiDateFin3;
    }

    public String getEtesvousreconnupourunepersonnemala() {
        return etesvousreconnupourunepersonnemala;
    }

    public void setEtesvousreconnupourunepersonnemala(String etesvousreconnupourunepersonnemala) {
        this.etesvousreconnupourunepersonnemala = etesvousreconnupourunepersonnemala;
    }

    public String getEtudeUniversitaireTelephone() {
        return etudeUniversitaireTelephone;
    }

    public void setEtudeUniversitaireTelephone(String etudeUniversitaireTelephone) {
        this.etudeUniversitaireTelephone = etudeUniversitaireTelephone;
    }

    public String getFilliere() {
        return filliere;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    public Date getFinEtudeProfessionnelles() {
        return finEtudeProfessionnelles;
    }

    public void setFinEtudeProfessionnelles(Date finEtudeProfessionnelles) {
        this.finEtudeProfessionnelles = finEtudeProfessionnelles;
    }

    public Date getFinEtudeUniversitaire() {
        return finEtudeUniversitaire;
    }

    public void setFinEtudeUniversitaire(Date finEtudeUniversitaire) {
        this.finEtudeUniversitaire = finEtudeUniversitaire;
    }

    public String getFonctionEmploi1() {
        return fonctionEmploi1;
    }

    public void setFonctionEmploi1(String fonctionEmploi1) {
        this.fonctionEmploi1 = fonctionEmploi1;
    }

    public String getFonctionEmploi2() {
        return fonctionEmploi2;
    }

    public void setFonctionEmploi2(String fonctionEmploi2) {
        this.fonctionEmploi2 = fonctionEmploi2;
    }

    public String getFonctionEmploi3() {
        return fonctionEmploi3;
    }

    public void setFonctionEmploi3(String fonctionEmploi3) {
        this.fonctionEmploi3 = fonctionEmploi3;
    }

    public String getHpitalClinique() {
        return hpitalClinique;
    }

    public void setHpitalClinique(String hpitalClinique) {
        this.hpitalClinique = hpitalClinique;
    }

    public String getIndiqueznousvotremaladie() {
        return indiqueznousvotremaladie;
    }

    public void setIndiqueznousvotremaladie(String indiqueznousvotremaladie) {
        this.indiqueznousvotremaladie = indiqueznousvotremaladie;
    }

    public String getInstititionEtudeUniversitaire() {
        return instititionEtudeUniversitaire;
    }

    public void setInstititionEtudeUniversitaire(String instititionEtudeUniversitaire) {
        this.instititionEtudeUniversitaire = instititionEtudeUniversitaire;
    }

    public String getInstitutionEtudeProfessionnelles() {
        return institutionEtudeProfessionnelles;
    }

    public void setInstitutionEtudeProfessionnelles(String institutionEtudeProfessionnelles) {
        this.institutionEtudeProfessionnelles = institutionEtudeProfessionnelles;
    }

    public String getJedsireentreprendremestudesla() {
        return jedsireentreprendremestudesla;
    }

    public void setJedsireentreprendremestudesla(String jedsireentreprendremestudesla) {
        this.jedsireentreprendremestudesla = jedsireentreprendremestudesla;
    }

    public String getLangueMaternelle() {
        return langueMaternelle;
    }

    public void setLangueMaternelle(String langueMaternelle) {
        this.langueMaternelle = langueMaternelle;
    }

    public String getLanguedusage() {
        return languedusage;
    }

    public void setLanguedusage(String languedusage) {
        this.languedusage = languedusage;
    }

    public String getLieunaissance() {
        return lieunaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public String getListedevosmdicamentshabituels() {
        return listedevosmdicamentshabituels;
    }

    public void setListedevosmdicamentshabituels(String listedevosmdicamentshabituels) {
        this.listedevosmdicamentshabituels = listedevosmdicamentshabituels;
    }

    public String getMatricle() {
        return matricle;
    }

    public void setMatricle(String matricle) {
        this.matricle = matricle;
    }

    public String getMdecindeFamille() {
        return mdecindeFamille;
    }

    public void setMdecindeFamille(String mdecindeFamille) {
        this.mdecindeFamille = mdecindeFamille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDernireInstitutionFrquente() {
        return nomDernireInstitutionFrquente;
    }

    public void setNomDernireInstitutionFrquente(String nomDernireInstitutionFrquente) {
        this.nomDernireInstitutionFrquente = nomDernireInstitutionFrquente;
    }

    public String getNomDuDoyenEtudeUnirversitaire() {
        return nomDuDoyenEtudeUnirversitaire;
    }

    public void setNomDuDoyenEtudeUnirversitaire(String nomDuDoyenEtudeUnirversitaire) {
        this.nomDuDoyenEtudeUnirversitaire = nomDuDoyenEtudeUnirversitaire;
    }

    public String getNomEmployeur1() {
        return nomEmployeur1;
    }

    public void setNomEmployeur1(String nomEmployeur1) {
        this.nomEmployeur1 = nomEmployeur1;
    }

    public String getNomEmployeur2() {
        return nomEmployeur2;
    }

    public void setNomEmployeur2(String nomEmployeur2) {
        this.nomEmployeur2 = nomEmployeur2;
    }

    public String getNomEmployeur3() {
        return nomEmployeur3;
    }

    public void setNomEmployeur3(String nomEmployeur3) {
        this.nomEmployeur3 = nomEmployeur3;
    }

    public String getNombredanneedeServicedelHopital() {
        return nombredanneedeServicedelHopital;
    }

    public void setNombredanneedeServicedelHopital(String nombredanneedeServicedelHopital) {
        this.nombredanneedeServicedelHopital = nombredanneedeServicedelHopital;
    }

    public Integer getNumberofLocations() {
        return numberofLocations;
    }

    public void setNumberofLocations(Integer numberofLocations) {
        this.numberofLocations = numberofLocations;
    }

    public String getPourquelsemestre() {
        return pourquelsemestre;
    }

    public void setPourquelsemestre(String pourquelsemestre) {
        this.pourquelsemestre = pourquelsemestre;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrimaire() {
        return primaire;
    }

    public void setPrimaire(String primaire) {
        this.primaire = primaire;
    }

    public String getProductInterest() {
        return productInterest;
    }

    public void setProductInterest(String productInterest) {
        this.productInterest = productInterest;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getSiOuiPrecisezladatedelademande() {
        return siOuiPrecisezladatedelademande;
    }

    public void setSiOuiPrecisezladatedelademande(Date siOuiPrecisezladatedelademande) {
        this.siOuiPrecisezladatedelademande = siOuiPrecisezladatedelademande;
    }

    public String getSpecialiteHopitalClinique() {
        return specialiteHopitalClinique;
    }

    public void setSpecialiteHopitalClinique(String specialiteHopitalClinique) {
        this.specialiteHopitalClinique = specialiteHopitalClinique;
    }

    public String getStatutDiplomeUniversitaire() {
        return statutDiplomeUniversitaire;
    }

    public void setStatutDiplomeUniversitaire(String statutDiplomeUniversitaire) {
        this.statutDiplomeUniversitaire = statutDiplomeUniversitaire;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTelephoneHopital() {
        return telephoneHopital;
    }

    public void setTelephoneHopital(String telephoneHopital) {
        this.telephoneHopital = telephoneHopital;
    }

    public String getTitreDiplomeEtudeProfessionnelles() {
        return titreDiplomeEtudeProfessionnelles;
    }

    public void setTitreDiplomeEtudeProfessionnelles(String titreDiplomeEtudeProfessionnelles) {
        this.titreDiplomeEtudeProfessionnelles = titreDiplomeEtudeProfessionnelles;
    }

    public String getTlphoneDernireInstitutionFrquent() {
        return tlphoneDernireInstitutionFrquent;
    }

    public void setTlphoneDernireInstitutionFrquent(String tlphoneDernireInstitutionFrquent) {
        this.tlphoneDernireInstitutionFrquent = tlphoneDernireInstitutionFrquent;
    }

    public String getTlphoneEtudeProfessionnelles() {
        return tlphoneEtudeProfessionnelles;
    }

    public void setTlphoneEtudeProfessionnelles(String tlphoneEtudeProfessionnelles) {
        this.tlphoneEtudeProfessionnelles = tlphoneEtudeProfessionnelles;
    }

    public String getTypeDetudeSollicite() {
        return typeDetudeSollicite;
    }

    public void setTypeDetudeSollicite(String typeDetudeSollicite) {
        this.typeDetudeSollicite = typeDetudeSollicite;
    }

    public String getTypedemploi() {
        return typedemploi;
    }

    public void setTypedemploi(String typedemploi) {
        this.typedemploi = typedemploi;
    }

    public String getTypedemploi2() {
        return typedemploi2;
    }

    public void setTypedemploi2(String typedemploi2) {
        this.typedemploi2 = typedemploi2;
    }

    public String getTypedemploi3() {
        return typedemploi3;
    }

    public void setTypedemploi3(String typedemploi3) {
        this.typedemploi3 = typedemploi3;
    }

    public String getUrgenceNom1() {
        return urgenceNom1;
    }

    public void setUrgenceNom1(String urgenceNom1) {
        this.urgenceNom1 = urgenceNom1;
    }

    public String getUrgenceNom2() {
        return urgenceNom2;
    }

    public void setUrgenceNom2(String urgenceNom2) {
        this.urgenceNom2 = urgenceNom2;
    }

    public String getUrgencePrnom1() {
        return urgencePrnom1;
    }

    public void setUrgencePrnom1(String urgencePrnom1) {
        this.urgencePrnom1 = urgencePrnom1;
    }

    public String getUrgencePrnom2() {
        return urgencePrnom2;
    }

    public void setUrgencePrnom2(String urgencePrnom2) {
        this.urgencePrnom2 = urgencePrnom2;
    }

    public String getVacationsollicite() {
        return vacationsollicite;
    }

    public void setVacationsollicite(String vacationsollicite) {
        this.vacationsollicite = vacationsollicite;
    }

    public Utlilisateur getUtlilisateurPersonneid() {
        return utlilisateurPersonneid;
    }

    public void setUtlilisateurPersonneid(Utlilisateur utlilisateurPersonneid) {
        this.utlilisateurPersonneid = utlilisateurPersonneid;
    }

    public List<HistoriqueExamenConcours> getHistoriqueExamenConcoursList() {
        return historiqueExamenConcoursList;
    }

    public void setHistoriqueExamenConcoursList(List<HistoriqueExamenConcours> historiqueExamenConcoursList) {
        this.historiqueExamenConcoursList = historiqueExamenConcoursList;
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
        if (!(object instanceof Postulant)) {
            return false;
        }
        Postulant other = (Postulant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fdsa.edu.PNUFDSA.Model.Postulant[ id=" + id + " ]";
    }
    
}
