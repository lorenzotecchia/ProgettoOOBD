package DAO;

import Model.Series;

import java.io.Serial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDAO {
    private Connection connection;

    public SeriesDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(String ISSN_S, String Curator, int Edition, String NameS, Serial Code) throws SQLException {
        String query = "INSERT INTO mtl.Series (ISSN_S, Curator, Edition, NameS, Code) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_S);
            statement.setString(2, Curator);
            statement.setInt(3, Edition);
            statement.setString(4, NameS);
            statement.setString(5, String.valueOf(Code));
            statement.executeUpdate();
        }
    }

    public List<Series> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Series";
        List<Series> series = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ISSN_S = resultSet.getString("ISSN_S");
                String Curator = resultSet.getString("Curator");
                int Edition = resultSet.getInt("Edition");
                String NameS = resultSet.getString("NameS");
                String Code = resultSet.getString("Code");
                series.add(new Series(ISSN_S, Curator, Edition, NameS, Code));
            }
        }
        return series;
    }

    public Series read(String ISSN_S) throws SQLException {
        String query = "SELECT * FROM mtl.Series WHERE ISSN_S = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_S);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ISSN_S = resultSet.getString("ISSN_S");
                String Curator = resultSet.getString("Curator");
                int Edition = resultSet.getInt("Edition");
                String NameS = resultSet.getString("NameS");
                String Code = resultSet.getString("Code");
                return new Series(ISSN_S, Curator, Edition, NameS, Code);
            }
        }
        return null;
    }

    public void update(String ISSN_S, String Curator, int Edition, String NameS, Serial Code) throws SQLException {
        String query = "UPDATE mtl.Series SET Curator = ?, Edition = ?, NameS = ?, Code = ? WHERE ISSN_S = ?";
        try (PreparedStatement statement = connection.
                prepareStatement(query)) {
            statement.setString(1, ISSN_S);
            statement.setString(2, Curator);
            statement.setInt(3, Edition);
            statement.setString(4, NameS);
            statement.setString(5, String.valueOf(Code));

            statement.executeUpdate();
        }
    }

    public void delete(String ISSN_S, String Curator, int Edition, String NameS, Serial Code) throws SQLException {
        String query = "DELETE FROM mtl.Series WHERE Curator = ?, Edition = ?, NameS = ?, Code = ? WHERE ISSN_S = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ISSN_S);
            statement.setString(2, Curator);
            statement.setInt(3, Edition);
            statement.setString(4, NameS);
            statement.setString(5, String.valueOf(Code));
            statement.executeUpdate();
        }
    }
}
