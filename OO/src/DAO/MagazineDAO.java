package DAO;

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

    public void create(String ISSN_M, String argument, String manager, Timestamp yearRelease, String nameM, String accessMode) throws SQLException {
        String query = "INSERT INTO mtl.Magazine (ISSN_M, Argument, Manager, YearRelease, NameM, AccessMode) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_M);
            statement.setString(2, argument);
            statement.setString(3, manager);
            statement.setTimestamp(4, yearRelease);
            statement.setString(5, nameM);
            statement.setString(6, accessMode);
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
                String argument = resultSet.getString("Argument");
                String manager = resultSet.getString("Manager");
                Timestamp yearRelease = resultSet.getTimestamp("YearRelease");
                String nameM = resultSet.getString("NameM");
                String accessMode = resultSet.getString("AccessMode");
                magazines.add(new Magazine(ISSN_M, argument, manager, yearRelease, nameM, accessMode));
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
                String argument = resultSet.getString("Argument");
                String manager = resultSet.getString("Manager");
                Timestamp yearRelease = resultSet.getTimestamp("YearRelease");
                String nameM = resultSet.getString("NameM");
                String accessMode = resultSet.getString("AccessMode");
                return new Magazine(ISSN_M, argument, manager, yearRelease, nameM, accessMode);
            }
        }
        return null;
    }

    public void update(String ISSN_M, String argument, String manager, Timestamp yearRelease, String nameM, String accessMode) throws SQLException {
        String query = "UPDATE mtl.Magazine SET Argument = ?, Manager = ?, YearRelease = ?, NameM = ?, AccessMode = ? WHERE ISSN_M = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, argument);
            statement.setString(2, manager);
            statement.setTimestamp(3, yearRelease);
            statement.setString(4, nameM);
            statement.setString(5, accessMode);
            statement.setString(6, ISSN_M);
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