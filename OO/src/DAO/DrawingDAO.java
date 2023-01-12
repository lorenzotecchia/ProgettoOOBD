package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrawingDAO {
    private Connection connection;

    public DrawingDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(int FK_LoanCode, String FK_Article, String FK_Series, String FK_Magazine, String FK_Book) throws SQLException {
        String query = "INSERT INTO mtl.Drawing (FK_LoanCode, FK_Article, FK_Series, FK_Magazine, FK_Book) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, FK_LoanCode);
            statement.setString(2, FK_Article);
            statement.setString(3, FK_Series);
            statement.setString(4, FK_Magazine);
            statement.setString(5, FK_Book);
            statement.executeUpdate();
        }
    }

    public List<Drawing> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Drawing";
        List<Drawing> drawings = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int FK_LoanCode = resultSet.getInt("FK_LoanCode");
                String FK_Article = resultSet.getString("FK_Article");
                String FK_Series = resultSet.getString("FK_Series");
                String FK_Magazine = resultSet.getString("FK_Magazine");
                String FK_Book = resultSet.getString("FK_Book");
                drawings.add(new Drawing(FK_LoanCode, FK_Article, FK_Series, FK_Magazine, FK_Book));
            }
        }
        return drawings;
    }

    public Drawing read(int FK_LoanCode) throws SQLException {
        String query = "SELECT * FROM mtl.Drawing WHERE FK_LoanCode = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, FK_LoanCode);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String FK_Article = resultSet.getString("FK_Article");
                String FK_Series = resultSet.getString("FK_Series");
                String FK_Magazine = resultSet.getString("FK_Magazine");
                String FK_Book = resultSet.getString("FK_Book");
                return new Drawing(FK_LoanCode, FK_Article, FK_Series, FK_Magazine, FK_Book);
            }
        }
        return null;
    }

    public void update(int FK_LoanCode, String FK_Article, String FK_Series, String FK_Magazine, String FK_Book) throws SQLException {
        String query = "UPDATE mtl.Drawing SET FK_Article = ?, FK_Series = ?, FK_Magazine = ?, FK_Book = ? WHERE FK_LoanCode = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, FK_Article);
            statement.setString(2, FK_Series);
            statement.setString(3, FK_Magazine);
            statement.setString(4, FK_Book);
            statement.setInt(5, FK_LoanCode);
            statement.executeUpdate();
        }
    }

    public void delete(int FK_LoanCode) throws SQLException {
        String query = "DELETE FROM mtl.Drawing WHERE FK_LoanCode = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, FK_LoanCode);
            statement.executeUpdate();
        }
    }
}