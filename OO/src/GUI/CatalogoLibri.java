package GUI;

import Database.ConnessioneDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CatalogoLibri {
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JList list3;

    public CatalogoLibri() {
        JFrame frame = new JFrame("CatalogoLibri");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ArrayList<String> libri_title = new ArrayList<String>();
        ArrayList<String> libri_author = new ArrayList<String>();
        ArrayList<String> libri_genre = new ArrayList<String>();


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
            String query = "SELECT * FROM mtl.book";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            DefaultListModel<String> listModel_1 = new DefaultListModel<String>();
            DefaultListModel<String> listModel_2 = new DefaultListModel<String>();
            DefaultListModel<String> listModel_3 = new DefaultListModel<String>();

            // Aggiunge le password al ArrayList
            while (rs.next()) {
                libri_title.add(rs.getString("title"));
                libri_author.add(rs.getString("author"));
                libri_genre.add(rs.getString("argument"));
            }

            for (String s : libri_title) {
                listModel_1.addElement(s);
            }
//            for (String s : libri_author) {
//                listModel_2.addElement(s);
//            }
//
//            for (String s : libri_genre) {
//                listModel_3.addElement(s);
//            }

            list1.setModel(listModel_1);
//            list2.setModel(listModel_2);
//            list3.setModel(listModel_3);

            //add a scollable pane
            JScrollPane scrollPane = new JScrollPane(list1);
            panel1.add(scrollPane);

            // Chiude la connessione al database
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new CatalogoLibri();
    }
}
