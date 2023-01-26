package DAO;

import Model.Magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MagazineDAO {
    private Connection connection;

    public MagazineDAO(Connection connection) {
        this.connection = connection;
    }
    public void create(String ISSN_M, String name_M, String argument, String manager, Timestamp yearRelease, String publicationPeriod, String publishingHouse, String accessMode, String FK_author) throws SQLException {
        String query = "INSERT INTO mtl.Magazine (ISSN_M, Name_M, Argument, Manager, YearRelease, PublicationPeriod, PublishingHouse, AccessMode, FK_author) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_M);
            statement.setString(2, name_M);
            statement.setString(3, argument);
            statement.setString(4, manager);
            statement.setTimestamp(5, yearRelease);
            statement.setString(6, publicationPeriod);
            statement.setString(7, publishingHouse);
            statement.setString(8, accessMode);
            statement.setString(9, FK_author);
            statement.executeUpdate();
        }
    }

    public List<Magazine> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Magazine";
        List<Magazine> magazines = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ISSN_M = resultSet.getString("ISSN_M");
                String name_M = resultSet.getString("NameM");
                String argument = resultSet.getString("Argument");
                String manager = resultSet.getString("Manager");
                Timestamp yearRelease = resultSet.getTimestamp("YearRelease");
                String publicationPeriod = resultSet.getString("publicationPeriod");
                String publishingHouse = resultSet.getString("publishingHouse");
                String accessMode = resultSet.getString("AccessMode");
                String FK_author = resultSet.getString("FK_author");
                magazines.add(new Magazine(ISSN_M, name_M, argument, manager, yearRelease, publicationPeriod, publishingHouse, accessMode, FK_author));
            }
        }
        return magazines;
    }
    public Magazine read(String ISSN_M) throws SQLException {
        String query = "SELECT * FROM mtl.Magazine WHERE ISSN_M = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_M);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ISSN_M = resultSet.getString("ISSN_M");
                String name_M = resultSet.getString("NameM");
                String argument = resultSet.getString("Argument");
                String manager = resultSet.getString("Manager");
                Timestamp yearRelease = resultSet.getTimestamp("YearRelease");
                String publicationPeriod = resultSet.getString("publicationPeriod");
                String publishingHouse = resultSet.getString("publishingHouse");
                String accessMode = resultSet.getString("AccessMode");
                String FK_author = resultSet.getString("FK_author");
                return new Magazine(ISSN_M, name_M, argument, manager, yearRelease, publicationPeriod, publishingHouse, accessMode, FK_author);
            }
        }
        return null;
    }

    public void update(String ISSN_M, String name_M, String argument, String manager, Timestamp yearRelease, String publicationPeriod, String publishingHouse, String accessMode, String FK_author) throws SQLException {
        String query = "UPDATE mtl.Magazine SET Name_M = ?, Argument = ?, Manager = ?, YearRelease = ?, PublicationPeriod = ?, PublishingHouse = ?, AccessMode = ?, FK_author = ? WHERE ISSN_M = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_M);
            statement.setString(2, name_M);
            statement.setString(3, argument);
            statement.setString(4, manager);
            statement.setTimestamp(5, yearRelease);
            statement.setString(6, publicationPeriod);
            statement.setString(7, publishingHouse);
            statement.setString(8, accessMode);
            statement.setString(9, FK_author);
            statement.executeUpdate();
        }
    }

    public void delete(String ISSN_M) throws SQLException {
        String query = "DELETE FROM mtl.Magazine WHERE ISSN_M = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_M);
            statement.executeUpdate();
        }
    }
}