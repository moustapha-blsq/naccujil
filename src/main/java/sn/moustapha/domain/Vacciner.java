package sn.moustapha.domain;
import java.util.Date;
public class Vacciner {
    private int idVaccination;
    private Date dateVaccination;
    private String soinsEffectues;
    private int medecin;
    private int vaccin;
    private int patient;

    //Getteurs

    public int getIdVaccination() {
        return idVaccination;
    }

    public Date getDateVaccination() {
        return dateVaccination;
    }

    public String getSoinsEffectues() {
        return soinsEffectues;
    }

    public int getMedecin() {
        return medecin;
    }

    public int getVaccin() {
        return vaccin;
    }

    public int getPatient() {
        return patient;
    }
    //Setteurs

    public void setIdVaccination(int idVaccination) {
        this.idVaccination = idVaccination;
    }

    public void setDateVaccination(Date dateVaccination) {
        this.dateVaccination = dateVaccination;
    }

    public void setSoinsEffectues(String soinsEffectues) {
        this.soinsEffectues = soinsEffectues;
    }

    public void setMedecin(int medecin) {
        this.medecin = medecin;
    }

    public void setVaccin(int vaccin) {
        this.vaccin = vaccin;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }
}
