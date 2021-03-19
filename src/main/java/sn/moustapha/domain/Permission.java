package sn.moustapha.domain;

public class Permission {
    private int idPermission;
    private String nomPermission;
    private int idRole;

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public String getNomPermission() {
        return nomPermission;
    }

    public void setNomPermission(String nomPermission) {
        this.nomPermission = nomPermission;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
