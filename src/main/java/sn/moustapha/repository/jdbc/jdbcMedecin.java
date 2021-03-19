package sn.moustapha.repository.jdbc;

import sn.moustapha.repository.MedecinReporsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcMedecin implements MedecinReporsitory {
    private CarnetContext context;
    public jdbcMedecin(){
        context = new CarnetContext();
    }
    @Override
    public void addDoctor() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enregistrement medecin");
        System.out.println(" - - - - - - - - - - - ");

        System.out.println("Prenom");
        String prenom = scan.next();

        System.out.println("Nom");
        String nom = scan.next();

        System.out.println("login");
        String login = scan.next();

        System.out.println("Mot de passe");
        String pw = scan.next();

        System.out.println("Email");
        String mail = scan.next();

        System.out.println("Tel");
        String tel = scan.next();

        Connection cnx = context.getConnection();
        try {
            String query = "INSERT INTO Utilisateur (`prenomUser`, `nomUser`, `login`, `password`, `email`, `tel`)" +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setString(1, prenom);
            statement.setString(2, nom);
            statement.setString(3, login);
            statement.setString(4, pw);
            statement.setString(5, mail);
            statement.setString(6, tel);
            statement.executeUpdate();

            Statement st = cnx.createStatement();
            String lastUser = "SELECT MAX(idUser) as maxId FROM Utilisateur";
            ResultSet result = st.executeQuery(lastUser);
            if (result.next())
                System.out.println("Find user = "+result.getString("maxId"));
            else
                System.out.println("Not find");

            System.out.println("- - - Informations supplémentaires médicin");
            System.out.println("Specialite");
            String specialite = scan.next();

            String insert = " INSERT INTO medecin (`specialite`, `utilisateur`) VALUES (?,?)";
            PreparedStatement exe = cnx.prepareStatement(insert);
            exe.setString(1, specialite);
            exe.setInt(2, result.getInt("maxId"));
            exe.executeUpdate();

        }catch (Exception e){
            System.out.println("Connexion a la base non etablie" + e.getMessage());
        }
    }

    @Override
    public void showDoctorByID(int id) {

    }

    @Override
    public void plannifierRV() {

    }

    @Override
    public void showRendezVousJour(int idMedecin) {

    }
}
