package sn.moustapha.repository.jdbc;

import sn.moustapha.domain.Patient;
import sn.moustapha.repository.PatientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class jdbcPatient implements PatientRepository {
    private CarnetContext context;

    /*Constructor*/
    public jdbcPatient(){
        context = new CarnetContext();
    }
    /* End constructor*/

    @Override
    public void getAllPatient() {
        Connection cnx = context.getConnection();
        String query = "SELECT * FROM patient";
        try {
            Statement st = cnx.createStatement();
           // st.execute(query);
            ResultSet result = st.executeQuery(query);
            int i = 1;
            while (result.next()){
                System.out.println("- - - - - Patient "+i + " - - - - -");
                System.out.println("ID patient : "+ result.getInt("idPatient"));
                System.out.println("Nom patient : "+ result.getString("nomPatient"));
                System.out.println("prenom patient :"+ result.getString("prenomPatient"));
                System.out.println("Date de naissance :"+ result.getString("dateNaiss"));
                System.out.println("Sexe:"+ result.getString("sexe"));
                System.out.println("Patologie :"+ result.getString("patologie"));
                System.out.println("Commentaires sur le patient :"+ result.getString("commentaire"));
                i+=1;
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }


    }

    @Override
    public Patient showCarnetPatient(int id) {
        return null;
    }

    @Override
    public void createPatient() {
        CarnetContext context = new CarnetContext();
        Connection cnx = context.getConnection();
        Scanner sc =  new Scanner(System.in);
        System.out.println("Saisir les informations du patient");

        System.out.println("Nom :");
        String nom = sc.next();

        System.out.println("Prenom :");
        String prenom = sc.next();

        System.out.println("Date de naissance :");
        String datenaiss = sc.next();

        System.out.println("Sexe :");
        String sexe = sc.next();

        System.out.println("Patologie remarquee :");
        String patologie = sc.next();

        System.out.println("Commentaire :");
        String comment = sc.next();

        System.out.println("Id du parent :");
        int parent = sc.nextInt();

        String query = "INSERT INTO patient (`prenomPatient`, `nomPatient`, `dateNaiss`, `sexe`, `patologie`, `commentaire`, parent)" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, prenom);
            st.setString(2, nom);
            st.setString(3, datenaiss);
            st.setString(4, sexe);
            st.setString(5, patologie);
            st.setString(6, comment);
            st.setInt   (7, parent);
            if (st.executeUpdate() > 0)
                System.out.println("SUCCESS");
            else System.out.println("ERROR");

        }
        catch (Exception e){
            System.out.println("Not connected to the base "+e.getMessage());
        }



    }

    @Override
    public void updatePatient() {

    }

    @Override
    public Patient findPatientByID(int id) {
        Connection cnx = context.getConnection();
        String query = "SELECT * FROM patient WHERE idPatient = "+id;
        Patient patient = new Patient();
        try {
            Statement st = cnx.createStatement();
            // st.execute(query);
            ResultSet result = st.executeQuery(query);
            int i = 1;

            while (result.next()){
                //prenomPatient`, `nomPatient`, `dateNaiss`, `sexe`, `patologie`, `commentaire`, parent)
                patient.setIdPatient(result.getInt("idPatient"));
                patient.setNomPatient(result.getString("nomPatient"));
                patient.setPrenomPatient(result.getString("prenomPatient"));
                patient.setDateNaiss(result.getDate("dateNaiss"));
                patient.setSexe(result.getString("sexe"));
                patient.setPatologie(result.getString("patologie"));
                patient.setCommentaire(result.getString("commentaire"));
                patient.setParent(result.getInt("parent"));
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return patient;
    }

    @Override
    public Patient findPatientByParent(int idParent) {
        return null;
    }

    @Override
    public void showcarnetPatient(int id) {
        Connection cnx = context.getConnection();
        String query = "SELECT * FROM patient p, vaccination vc, vaccin v, medecin m " +
                " WHERE p.idPatient = vc.patient AND v.id_vac = vc.id_vaccination AND " +
                " m.idMedecin = vc.medecin AND idPatient = "+id;
        try  {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(query);
            if (result.next()){
                System.out.println("- - - - Informations du Patient - - - - ");
                System.out.println("Prenom et nom :" +result.getString("prenomPatient") +" "+ result.getString("nomPatient"));
                System.out.println("Sexe :" +result.getString("sexe"));
                System.out.println("Date de naissance :" +result.getString("dateNaiss"));
                System.out.println("Patologie :" +result.getString("patologie"));
                System.out.println("Parent :" +result.getString("parent"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
