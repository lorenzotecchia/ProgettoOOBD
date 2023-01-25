//package DAO;
//
//import Model.Discussion;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//// This class is used to access the database and retrieve the data
//
//
//public class DiscussionDAO {
//    private Connection connection;
//
//    public DiscussionDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void create(int FK_Event, String FK_Article) throws SQLException {
//        String query = "INSERT INTO mtl.Discussion (FK_Event, FK_Article) VALUES (?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, FK_Event);
//            statement.setString(2, FK_Article);
//            statement.executeUpdate();
//        }
//    }
//
//    public List<Discussion> readAll() throws SQLException {
//        String query = "SELECT * FROM mtl.Discussion";
//        List<Discussion> discussions = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int FK_Event = resultSet.getInt("FK_Event ");
//
//                String FK_Article = resultSet.getString("FK_Article");
//                discussions.add(new Discussion(FK_Event, FK_Article));
//            }
//        }
//        return discussions;
//    }
//
//    public Discussion read(int FK_Event) throws SQLException {
//        String query = "SELECT * FROM mtl.Discussion WHERE FK_Event = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, FK_Event);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String FK_Article = resultSet.getString("FK_Article");
//                return new Discussion(FK_Event, FK_Article);
//            }
//        }
//        return null;
//    }
//
//    public void update(int FK_Event, String FK_Article) throws SQLException {
//        String query = "UPDATE mtl.Discussion SET FK_Article = ? WHERE FK_Event = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, FK_Article);
//            statement.setInt(2, FK_Event);
//            statement.executeUpdate();
//        }
//    }
//
//    public void delete(int FK_Event) throws SQLException {
//        String query = "DELETE FROM mtl.Discussion WHERE FK_Event = ?";
//        try (PreparedStatement statement =
//                     connection.prepareStatement(query)) {
//            statement.setInt(1, FK_Event);
//            statement.executeUpdate();
//        }
//    }
//}
