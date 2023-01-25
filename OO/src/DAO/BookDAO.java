package DAO;

import Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(String doi_B, String ISBN_B, int edition, Timestamp releaseDate, String publishingHouse, String author, String accessMode, String title, String argument, boolean reprint, String FK_Series) throws SQLException {
        String query = "INSERT INTO mtl.Book (Doi_B, ISBN_B, Edition, ReleaseDate, PublishingHouse, Author, AccessMode, Title, Argument, Reprint, FK_Series) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doi_B);
            statement.setString(2, ISBN_B);
            statement.setInt(3, edition);
            statement.setTimestamp(4, releaseDate);
            statement.setString(5, publishingHouse);
            statement.setString(6, author);
            statement.setString(7, accessMode);
            statement.setString(8, title);
            statement.setString(9, argument);
            statement.setBoolean(10, reprint);
            statement.setString(11, FK_Series);
            statement.executeUpdate();
        }
    }

    public List<Book> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Book";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String doi_B = resultSet.getString("Doi_B");
                String ISBN_B = resultSet.getString("ISBN_B");
                int edition = resultSet.getInt("Edition");
                Timestamp releaseDate = resultSet.getTimestamp("ReleaseDate");
                String publishingHouse = resultSet.getString("PublishingHouse");
                String author = resultSet.getString("Author");
                String accessMode = resultSet.getString("AccessMode");
                String title = resultSet.getString("Title");
                String argument = resultSet.getString("Argument");
                boolean reprint = resultSet.getBoolean("Reprint");
                String FK_Series = resultSet.getString("FK_Series");
                books.add(new Book(doi_B, ISBN_B, edition, releaseDate, publishingHouse, author, accessMode, title, argument, reprint, FK_Series));
            }
        }
        return books;
    }
}