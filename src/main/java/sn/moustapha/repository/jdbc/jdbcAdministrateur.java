package sn.moustapha.repository.jdbc;
import sn.moustapha.domain.Patient;
import sn.moustapha.repository.AdminReporsitory;
import sn.moustapha.repository.UtilisateurRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcAdministrateur implements AdminReporsitory {
    private CarnetContext context;
    public jdbcAdministrateur(){
        context = new CarnetContext();
    }
    @Override
    public void schendleRendezVous() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la date :");
        String dateRv = sc.next();
        System.out.println("Traitemets prevu :");
        String traitementPrevu = sc.next();
        int statut  = 0;
        Connection cnx = context.getConnection();
        jdbcPatient pat = new jdbcPatient();
        pat.getAllPatient();
        System.out.println("Choisir un patient sur la liste (saisir l'ID)");
        int patient = sc.nextInt();

        try  {
            Statement st = cnx.createStatement();
            String  med = "SELECT * FROM Utilisateur u, medecin m WHERE u.idUser = m.utilisateur";
            ResultSet result = st.executeQuery(med);
            System.out.println("Liste des medecin, choisir un par son ID");
            while (result.next()){
                System.out.println("ID :"+result.getInt("idMedecin"));
                System.out.println("Prénom : "+result.getString("prenomUser"));
                System.out.println("Nom : "+result.getString("nomUser"));
                System.out.println("Spécialité : "+result.getString("specialite"));
            }
            System.out.println("Choisir un medecin");
            int medecin = sc.nextInt();

            String rv = "INSERT INTO `rendez_vous`(`date_rv`, `traitements_prevu`, `status`, `medecin`, `patient`)" +
                    "VALUES(?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(rv);
            stmt.setString(1, dateRv);
            stmt.setString(2, traitementPrevu);
            stmt.setInt(3, statut);
            stmt.setInt(4, medecin);
            stmt.setInt(5, patient);
            if(stmt.executeUpdate() > 0)
                System.out.println("Enregistrement RV OK");
            else System.out.println("Echec de l'enregistrement du RV");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
