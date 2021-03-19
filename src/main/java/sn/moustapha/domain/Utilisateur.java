package sn.moustapha.domain;

public class Utilisateur {
    private int idUser;
    private String prenom;
    private String nom;
    private String login;
    private String password;
    private String email;
    private String tel;

    // Getteus
    public int getIdUser() {
        return idUser;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    // Setteurs

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
