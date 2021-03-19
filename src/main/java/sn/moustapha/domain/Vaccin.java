package sn.moustapha.domain;

public class Vaccin {
    private int idVaccin;
    private String nomVaccin;
    private String description;

    // Getteurs

    public int getIdVaccin() {
        return idVaccin;
    }

    public String getNomVaccin() {
        return nomVaccin;
    }

    public String getDescription() {
        return description;
    }

    //Setteus

    public void setIdVaccin(int idVaccin) {
        this.idVaccin = idVaccin;
    }

    public void setNomVaccin(String nomVaccin) {
        this.nomVaccin = nomVaccin;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
