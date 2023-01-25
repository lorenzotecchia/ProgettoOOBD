package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Database.*;

public class ImportPasswords {
    public static void main(String[] args) {
        ArrayList<String> passwords = new ArrayList<String>();


        // Sostituire "username" e "password" con le credenziali di accesso al database
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "0000";

        try {
            // Carica il driver JDBC
            Class.forName("org.postgresql.Driver");
            // Crea una connessione al database

            // Apri la connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Esegue la query di selezione delle password
            String query = "SELECT doi_b FROM mtl.book";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Aggiunge le password al ArrayList
            while (rs.next()) {
                passwords.add(rs.getString("doi_b"));
                System.out.println(rs.getString("doi_b"));
            }

            // Chiude la connessione al database
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}