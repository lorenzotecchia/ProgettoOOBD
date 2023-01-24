//package DAO;
//
//import Model.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class UserDAO {
//    private Connection connection;
//
//    public UserDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void create(String SSN, String password) throws SQLException {
//        String query = "INSERT INTO mtl.User(SSN, password) VALUES (?,?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, SSN);
//            statement.setString(2, password);
//            statement.executeUpdate();
//        }
//    }
//
//    public List<User> readAll() throws SQLException {
//        String query = "SELECT SSN, password FROM mtl.User";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            ResultSet resultSet = statement.executeQuery();
//            List<User> users = new ArrayList<>();
//            while (resultSet.next()) {
//                String SSN = resultSet.getString("SSN");
//                String password = resultSet.getString("password");
//                users.add(new User(SSN, password));
//            }
//            return users;
//        }
//    }
//
//    public User read(String SSN) throws SQLException {
//        String query = "SELECT password FROM mtl.User WHERE SSN = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, SSN);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String password = resultSet.getString("password");
//                return new User(SSN, password);
//            }
//        }
//        return null;
//    }
//
//    public void update(String SSN, String password) throws SQLException {
//        String query = "UPDATE mtl.User SET password = ? WHERE SSN = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, password);
//            statement.setString(2, SSN);
//            statement.executeUpdate();
//        }
//    }
//
//    public void delete(String SSN) throws SQLException {
//        String query = "DELETE FROM mtl.User WHERE SSN = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, SSN);
//            statement.executeUpdate();
//        }
//    }
//}
//
