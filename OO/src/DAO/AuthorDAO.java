package DAO;

import Model.Author;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(String authorID, String fName, String lName) throws SQLException {
        String query = "INSERT INTO mtl.Book (AuthorID, FName, LName) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, authorID);
            statement.setString(2, fName);
            statement.setString(3, lName);
            statement.executeUpdate();
        }
    }

    public List<Author> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Book";
        List<Author> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String authorID = resultSet.getString("authorID");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                books.add(new Author(authorID, fName, lName));
            }
        }
        return books;
    }
}
