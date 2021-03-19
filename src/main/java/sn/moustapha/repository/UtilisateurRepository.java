package sn.moustapha.repository;

import sn.moustapha.domain.Utilisateur;

import javax.management.relation.Role;

public interface UtilisateurRepository {
    void createUser();
    Utilisateur[] getAllUsers();
    void setUserRole(Role role, int idUser);
    Utilisateur findUserByID(int id);

}
