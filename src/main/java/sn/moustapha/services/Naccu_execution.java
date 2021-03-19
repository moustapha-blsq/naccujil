package sn.moustapha.services;

import sn.moustapha.domain.Patient;
import sn.moustapha.repository.jdbc.CarnetContext;
import sn.moustapha.repository.jdbc.jdbcMedecin;
import sn.moustapha.repository.jdbc.jdbcPatient;
import sn.moustapha.repository.jdbc.jdbcAdministrateur;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Naccu_execution {
    public static void main(String[] args) {

        MenuService menu = new MenuService();
        String reponse = "";
        do{
            menu.showMenu();
            Scanner sc = new Scanner(System.in);
            System.out.println("- - - Faites votre choix - - - ");
            String choix = sc.next();
            jdbcPatient patient = new jdbcPatient();


            if (choix.equalsIgnoreCase("A")){
               patient.getAllPatient();
            }

            if (choix.equalsIgnoreCase("B")){
                patient.createPatient();
            }

            if (choix.equalsIgnoreCase("C")){
                System.out.println("Entrez l'ID");
                int id = sc.nextInt();
                Patient patientFound = patient.findPatientByID(id);
                if(patientFound == null){
                    System.out.println("Patient avec ce ID introuvable");
                }
                else{
                    System.out.println(" - - - Résultat de recherche - - - ");
                    System.out.println("Id patient :" + patientFound.getIdPatient());
                    System.out.println("Prenom :" + patientFound.getPrenomPatient());
                    System.out.println("Nom :" + patientFound.getNomPatient());
                    System.out.println("Sexe :" + patientFound.getSexe());
                    System.out.println("Date de naissance :" + patientFound.getDateNaiss());
                    System.out.println("Patologie :" + patientFound.getPatologie());
                    System.out.println("Parent :" + patientFound.getParent());
                    System.out.println("Commentaire :" + patientFound.getCommentaire());
                }
            }
            if (choix.equalsIgnoreCase("D")) {
                System.out.println("Option vide");
            }
            if (choix.equalsIgnoreCase("E")) {
                 System.out.println("Entrez l'ID");
                 int id = sc.nextInt();
                 Patient patientFound = patient.findPatientByID(id);

            }
            if (choix.equalsIgnoreCase("H")){
                jdbcMedecin med = new jdbcMedecin();
                med.addDoctor();
            }
            if (choix.equalsIgnoreCase("J")){
                jdbcAdministrateur admin = new jdbcAdministrateur();
                admin.schendleRendezVous();
            }
            System.out.println("Retourner au menu principal ?");
           reponse = sc.next();
        }while(reponse.equalsIgnoreCase("O"));
        System.out.println("BYE BYE :)");
    }
}
