package sn.moustapha.domain;

public class Parent extends Utilisateur{
    private int idParent;
    private String adresseParent;
    private String profession;

    // Getteurs
    public int getIdParent() {
        return idParent;
    }

    public String getAdresseParent() {
        return adresseParent;
    }

    public String getProfession() {
        return profession;
    }

    // Setteus

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public void setAdresseParent(String adresseParent) {
        this.adresseParent = adresseParent;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
