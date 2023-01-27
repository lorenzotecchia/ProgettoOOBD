package DAO;

import Model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private Connection connection;

    public ArticleDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(String doi_A, String title, String accessMode, String editor, String topic, Timestamp releaseDate, String releaseLocation, String conferenceName, String FK_author, String FK_Magazine) throws SQLException {
        String query = "INSERT INTO mtl.Article (Doi_A, Title, AccessMode, Editor, Topic, ReleaseDate, ReleaseLocation, ConferenceName, FK_Author, FK_Magazine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doi_A);
            statement.setString(2, title);
            statement.setString(3, accessMode);
            statement.setString(4, editor);
            statement.setString(5, topic);
            statement.setTimestamp(6, releaseDate);
            statement.setString(7, releaseLocation);
            statement.setString(8, conferenceName);
            statement.setString(9, FK_author);
            statement.setString(10, FK_Magazine);
            statement.executeUpdate();
        }
    }

    public List<Article> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Article";
        List<Article> articles = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String doi_A = resultSet.getString("Doi_A");
                String title = resultSet.getString("Title");
                String accessMode = resultSet.getString("AccessMode");
                String editor = resultSet.getString("Editor");
                String topic = resultSet.getString("Topic");
                Timestamp releaseDate = resultSet.getTimestamp("ReleaseDate");
                String releaseLocation = resultSet.getString("ReleaseLocation");
                String conferenceName = resultSet.getString("ConferenceName");
                String FK_author = resultSet.getString("FK_Author");
                String FK_Magazine = resultSet.getString("FK_Magazine");
                articles.add(new Article(doi_A, title, accessMode, editor, topic, releaseDate, releaseLocation, conferenceName, FK_author, FK_Magazine));
            }
        }
        return articles;
    }

    public Article read(String doi_A) throws SQLException {
        String query = "SELECT * FROM mtl.Article WHERE Doi_A = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doi_A);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 doi_A = resultSet.getString("Doi_A");
                String title = resultSet.getString("Title");
                String accessMode = resultSet.getString("AccessMode");
                String editor = resultSet.getString("Editor");
                String topic = resultSet.getString("Topic");
                Timestamp releaseDate = resultSet.getTimestamp("ReleaseDate");
                String releaseLocation = resultSet.getString("ReleaseLocation");
                String conferenceName = resultSet.getString("ConferenceName");
                String FK_author = resultSet.getString("FK_Author");
                String FK_Magazine = resultSet.getString("FK_Magazine");
                return new Article(doi_A, title, accessMode, editor, topic, releaseDate, releaseLocation, conferenceName, FK_author, FK_Magazine);
            }
        }
        return null;
    }

    public void update(String doi_A, String title, String accessMode, String editor, String topic, Timestamp releaseDate, String releaseLocation, String conferenceName, String FK_author, String FK_Magazine) throws SQLException {
        String query = "UPDATE mtl.Article SET Title = ?, AccessMode = ?, Editor = ?, Author = ?, FK_Magazine = ? WHERE Doi_A = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doi_A);
            statement.setString(2, title);
            statement.setString(3, accessMode);
            statement.setString(4, editor);
            statement.setString(5, topic);
            statement.setTimestamp(6, releaseDate);
            statement.setString(7, releaseLocation);
            statement.setString(8, conferenceName);
            statement.setString(9, FK_author);
            statement.setString(10, FK_Magazine);
            statement.executeUpdate();
        }
    }

    public void delete(String doi_A) throws SQLException {
        String query = "DELETE FROM mtl.Article WHERE Doi_A = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doi_A);
            statement.executeUpdate();
        }
    }
}
