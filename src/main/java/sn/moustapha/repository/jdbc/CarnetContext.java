package sn.moustapha.repository.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CarnetContext {
    public Connection getConnection(){

        Connection con = null;
        try {
            // chargement de la classe par son nom
            Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
            Driver pilote = (Driver)c.getConstructor().newInstance() ;
            // enregistrement du pilote auprès du DriverManager
            DriverManager.registerDriver(pilote);
            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
            // Adresse IP de l’hôte de la base et port
            String ip =  "localhost" ;  // dépend du contexte
            String port =  "3306" ;  // port MySQL par défaut
            // Nom de la base ;
            String nomBase =  "carnet_vaccination" ;  // dépend du contexte
            // Chaîne de connexion
            String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;  // dépend du contexte
            String motDePasse = "root" ;  // dépend du contexte
            // Connexion
            con = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse) ;

            // Envoi d’un requête générique
           /* String sql =  "select * from patient" ;
            Statement smt = con.createStatement() ;
            ResultSet rs = smt.executeQuery(sql) ;
            while (rs.next()) {
                System.out.println(rs.getString("nomPatient")) ;
                System.out.println(rs.getString("prenomPatient")) ;
            }*/
        }  catch (Exception e) {
            System.out.println("JDBC ne parvient pas a se connecter a la base "+ e.getMessage());
        }
        return con;
    }
}

