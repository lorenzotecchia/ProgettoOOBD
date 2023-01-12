package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class EventDAO {
    private Connection connection;

    public EventDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Timestamp startDate, Timestamp endDate, String locationPromoter, String manager) throws SQLException {
        String query = "INSERT INTO mtl.Event (StartDate, EndDate, LocationPromoter, Manager) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setTimestamp(1, startDate);
            statement.setTimestamp(2, endDate);
            statement.setString(3, locationPromoter);
            statement.setString(4, manager);
            statement.executeUpdate();
        }
    }

    public List<Event> readAll() throws SQLException {
        String query = "SELECT * FROM mtl.Event";
        List<Event> events = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int codEvent = resultSet.getInt("CodEvent");
                Timestamp startDate = resultSet.getTimestamp("StartDate");
                Timestamp endDate = resultSet.getTimestamp("EndDate");
                String locationPromoter = resultSet.getString("LocationPromoter");
                String manager = resultSet.getString("Manager");
                events.add(new Event(codEvent, startDate, endDate, locationPromoter, manager));
            }
        }
        return events;
    }

    public Event read(int codEvent) throws SQLException {
        String query = "SELECT * FROM mtl.Event WHERE CodEvent = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, codEvent);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Timestamp startDate = resultSet.getTimestamp("StartDate");
                Timestamp endDate = resultSet.getTimestamp("EndDate");
                String locationPromoter = resultSet.getString("LocationPromoter");
                String manager = resultSet.getString("Manager");
                return new Event(codEvent, startDate, endDate, locationPromoter, manager);
            }
        }
        return null;
    }

    public void update(int codEvent, Timestamp startDate, Timestamp endDate, String locationProm, String manager