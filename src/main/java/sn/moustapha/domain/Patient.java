package sn.moustapha.domain;
import sn.moustapha.repository.PatientRepository;

import java.util.Date;
public class Patient {
    private int idPatient;
    private String prenomPatient;
    private String nomPatient;
    private Date dateNaiss;
    private String sexe;
    private String patologie;
    private String commentaire;
    private int parent;

    //Getteurs

    public int getIdPatient() {
        return idPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public String getPatologie() {
        return patologie;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getParent(){ return parent; }

    // Setteurs

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setPatologie(String patologie) {
        this.patologie = patologie;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setParent(int idParent){ this.parent = idParent;}
}
