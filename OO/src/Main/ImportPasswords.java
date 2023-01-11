package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ImportPasswords {
    public static void main(String[] args) {
        ArrayList<String> passwords = new ArrayList<String>();

        // Sostituire "username" e "password" con le credenziali di accesso al database
        String url = "jdbc:postgresql://localhost:5342/postgres";
        String user = "postgres";
        String password = "0000";

        try {
            // Carica il driver JDBC
            Class.forName("org.postgresql.Driver");

            // Apri la connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Esegue la query di selezione delle password
            String query = "SELECT password FROM mtl.User";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Aggiunge le password al ArrayList
            while (rs.next()) {
                passwords.add(rs.getString("password"));
            }

            // Chiude la connessione al database
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

