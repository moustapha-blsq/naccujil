package sn.moustapha.domain;
import java.util.Date;

public class RendezVous {
    private int idRV;
    private Date dateRV;
    private String traitementPrevu;
    private String status;
    private int patient;
    private int medecin;

    //Getteurs

    public int getIdRV() {
        return idRV;
    }

    public Date getDateRV() {
        return dateRV;
    }

    public String getTraitementPrevu() {
        return traitementPrevu;
    }

    public String getStatus() {
        return status;
    }

    public int getPatient() {
        return patient;
    }

    public int getMedecin() {
        return medecin;
    }
    //Setteurs

    public void setIdRV(int idRV) {
        this.idRV = idRV;
    }

    public void setDateRV(Date dateRV) {
        this.dateRV = dateRV;
    }

    public void setTraitementPrevu(String traitementPrevu) {
        this.traitementPrevu = traitementPrevu;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public void setMedecin(int medecin) {
        this.medecin = medecin;
    }
}
