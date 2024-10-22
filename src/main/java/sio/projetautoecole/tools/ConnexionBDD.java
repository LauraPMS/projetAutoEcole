package sio.projetautoecole.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnexionBDD {
    private static Connection cnx;

    public ConnexionBDD() throws ClassNotFoundException, SQLException {
        //String pilote = "com.mysql.jdbc.Driver";
        String pilote = "com.mysql.cj.jdbc.Driver";
        // chargement du pilote
        Class.forName("com.mysql.cj.jdbc.Driver");
        // L'objet connexion à la BDD avec le nom de la base, le user et le password
        cnx = DriverManager.getConnection("jdbc:mysql://localhost/autoecole?useSSL=true&serverTimezone="
                + TimeZone.getDefault().getID(), "root", "");
    }
    public static Connection getCnx() {
        return cnx;
    }
}
