//package DAO;
//
//import Model.Article;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArticleDAO {
//    private Connection connection;
//
//    public ArticleDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void create(String doi_A, String title, String accessMode, Timestamp yearRelease, String editor, String author, String FK_Magazine) throws SQLException {
//        String query = "INSERT INTO mtl.Article (Doi_A, Title, AccessMode, YearRelease, Editor, Author, FK_Magazine) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, doi_A);
//            statement.setString(2, title);
//            statement.setString(3, accessMode);
//            statement.setTimestamp(4, yearRelease);
//            statement.setString(5, editor);
//            statement.setString(6, author);
//            statement.setString(7, FK_Magazine);
//            statement.executeUpdate();
//        }
//    }
//
//    public List<Article> readAll() throws SQLException {
//        String query = "SELECT * FROM mtl.Article";
//        List<Article> articles = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String doi_A = resultSet.getString("Doi_A");
//                String title = resultSet.getString("Title");
//                String accessMode = resultSet.getString("AccessMode");
//                Timestamp yearRelease = resultSet.getTimestamp("YearRelease");
//                String editor = resultSet.getString("Editor");
//                String author = resultSet.getString("Author");
//                String FK_Magazine = resultSet.getString("FK_Magazine");
//                articles.add(new Article(doi_A, title, accessMode, yearRelease, editor, author, FK_Magazine));
//            }
//        }
//        return articles;
//    }
//
//    public Article read(String doi_A) throws SQLException {
//        String query = "SELECT * FROM mtl.Article WHERE Doi_A = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, doi_A);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String title = resultSet.getString("Title");
//                String accessMode = resultSet.getString("AccessMode");
//                Timestamp yearRelease = resultSet.getTimestamp("YearRelease");
//                String editor = resultSet.getString("Editor");
//                String author = resultSet.getString("Author");
//                String FK_Magazine = resultSet.getString("FK_Magazine");
//                return new Article(doi_A, title, accessMode, yearRelease, editor, author, FK_Magazine);
//            }
//        }
//        return null;
//    }
//
//    public void update(String doi_A, String title, String accessMode, Timestamp yearRelease, String editor, String author, String FK_Magazine) throws SQLException {
//        String query = "UPDATE mtl.Article SET Title = ?, AccessMode = ?, YearRelease = ?, Editor = ?, Author = ?, FK_Magazine = ? WHERE Doi_A = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, title);
//            statement.setString(2, accessMode);
//            statement.setTimestamp(3, yearRelease);
//            statement.setString(4, editor);
//            statement.setString(5, author);
//            statement.setString(6, FK_Magazine);
//            statement.setString(7, doi_A);
//            statement.executeUpdate();
//        }
//    }
//
//    public void delete(String doi_A) throws SQLException {
//        String query = "DELETE FROM mtl.Article WHERE Doi_A = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, doi_A);
//            statement.executeUpdate();
//        }
//    }
//}
