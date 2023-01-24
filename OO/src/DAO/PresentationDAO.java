//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
///*
//* In questa classe, ci sono i metodi per creare, leggere, aggiornare
//*  e cancellare presentazioni dalla tabella mtl.Presentation.
//* Il metodo "create" utilizza una query SQL per inserire una nuova presentazione nella tabella,
//*  il metodo "readAll" utilizza una query SQL per leggere tutte le presentazioni dalla tabella e
//*  restituirli come una lista di oggetti Presentation, il metodo "read" utilizza una query SQL per
//*  leggere una singola presentazione dalla tabella in base al suo FK_Event, il metodo "update" utilizza una
//*  query SQL per aggiornare una presentazione esistente nella tabella e il metodo "delete" utilizza una query SQL per
//* cancellare una presentazione dalla tabella in base al suo FK_Event
//*
//* */
//
//public class PresentationDAO {
//    private Connection connection;
//
//    public PresentationDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void create(int FK_Event, String FK_Book) throws SQLException {
//        String query = "INSERT INTO mtl.Presentation (FK_Event, FK_Book) VALUES (?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, FK_Event);
//            statement.setString(2, FK_Book);
//            statement.executeUpdate();
//        }
//    }
//
//    public List<Presentation> readAll() throws SQLException {
//        String query = "SELECT * FROM mtl.Presentation";
//        List<Presentation> presentations = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int FK_Event = resultSet.getInt("FK_Event");
//                String FK_Book = resultSet.getString("FK_Book");
//                presentations.add(new Presentation(FK_Event, FK_Book));
//            }
//        }
//        return presentations;
//    }
//
//    public Presentation read(int FK_Event) throws SQLException {
//        String query = "SELECT * FROM mtl.Presentation WHERE FK_Event = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, FK_Event);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String FK_Book = resultSet.getString("FK_Book");
//                return new Presentation(FK_Event, FK_Book);
//            }
//        }
//        return null;
//    }
//
//    public void update(int FK_Event, String FK_Book) throws SQLException {
//        String query = "UPDATE mtl.Presentation SET FK_Book = ? WHERE FK_Event = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, FK_Book);
//            statement.setInt(2, FK_Event);
//            statement.executeUpdate();
//        }
//    }
//
//
//    public void delete(int FK_Event) throws SQLException {
//        String query = "DELETE FROM mtl.Presentation WHERE FK_Event = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, FK_Event);
//            statement.executeUpdate();
//        }
//    }
//}
//
