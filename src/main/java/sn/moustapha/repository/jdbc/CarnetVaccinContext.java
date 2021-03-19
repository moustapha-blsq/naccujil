package sn.moustapha.repository.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
public class CarnetVaccinContext {
    public Connection createConnection() {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.getConstructor().newInstance();
            // enregistrement du pilote auprès du DriverManager
            DriverManager.registerDriver(pilote);
            // Protocole de connexion
            String protocole = "jdbc:mysql:";
            // Adresse IP de l’hôte de la base et port
            String ip = "localhost";  // dépend du contexte
            String port = "3306";  // port MySQL par défaut
            // Nom de la base ;
            String nomBase = "carnet_vaccination";  // dépend du contexte
            // Chaîne de connexion
            String chaineDeConnexion = protocole + "//" + ip + ":" + port + "/" + nomBase;
            // Identifiants de connexion et mot de passe
            String dbUser = "root";  // dépend du contexte
            String dbPassword = "";  // dépend du contexte
            // Connexion
            return DriverManager.getConnection(chaineDeConnexion, dbUser, dbPassword);
        } catch (Exception ex) {
            System.err.println("Une erreur est survenue lors de la création de la connexion: ");
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
