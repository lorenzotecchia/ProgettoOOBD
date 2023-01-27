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

    public void create(String doi_B, String ISBN_B, int edition, String publishingHouse,
                       String language, String title, String accessMode, String argument,
                       boolean reprint, Timestamp releaseDate, String releaseLocation, String PresentationName,
                       String FK_author, String FK_Series) throws SQLException {
        String query = "INSERT INTO mtl.Book (Doi_B, ISBN_B, Edition, PublishingHouse, Language, Title, Argument, AccessMode, " +
                "Reprint, ReleaseDate, ReleaseLocation, PresentationName, FK_author, FK_Series) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doi_B);
            statement.setString(2, ISBN_B);
            statement.setInt(3, edition);
            statement.setString(4, publishingHouse);
            statement.setString(5, language);
            statement.setString(6, title);
            statement.setString(7, argument);
            statement.setString(8, accessMode);
            statement.setBoolean(9, reprint);
            statement.setTimestamp(10, releaseDate);
            statement.setString(11, releaseLocation);
            statement.setString(12, PresentationName);
            statement.setString(13, FK_author);
            statement.setString(14, FK_Series);
            statement.executeUpdate();
        }
    }

    public ArrayList<Book> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Book b ";
        ArrayList<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String doi_B = resultSet.getString("Doi_B");
                String ISBN_B = resultSet.getString("ISBN_B");
                int edition = resultSet.getInt("Edition");
                String publishingHouse = resultSet.getString("PublishingHouse");
                String language = resultSet.getString("Language");
                String title = resultSet.getString("Title");
                String argument = resultSet.getString("Argument");
                String accessMode = resultSet.getString("AccessMode");
                boolean reprint = resultSet.getBoolean("Reprint");
                Timestamp releaseDate = resultSet.getTimestamp("ReleaseDate");
                String releaseLocation = resultSet.getString("ReleaseLocation");
                String presentationName = resultSet.getString("PresentationName");
                String Fk_author = resultSet.getString("FK_author");
                String FK_Series = resultSet.getString("FK_Series");
                books.add(new Book(doi_B, ISBN_B, edition, publishingHouse, language, title,
                        argument, accessMode, reprint, releaseDate, releaseLocation,
                        presentationName, Fk_author, FK_Series));
            }
        }
        return books;
    }

}