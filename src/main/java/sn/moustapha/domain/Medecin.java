package sn.moustapha.domain;

public class Medecin extends Utilisateur{
    private int idMedecin;
    private String specialite;

    public int getIdMedecin() {
        return idMedecin;
    }

    public String getSpecialite() {
        return specialite;
    }
    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
