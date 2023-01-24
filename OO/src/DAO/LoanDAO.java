//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LoanDAO {
//    private Connection connection;
//
//    public LoanDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void create(Timestamp startLoan, Timestamp endLoan, String FK_User) throws SQLException {
//        String query = "INSERT INTO mtl.Loan (StartLoan, EndLoan, FK_User) VALUES (?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setTimestamp(1, startLoan);
//            statement.setTimestamp(2, endLoan);
//            statement.setString(3, FK_User);
//            statement.executeUpdate();
//        }
//    }
//
//    public List<Loan> readAll() throws SQLException {
//        String query = "SELECT * FROM mtl.Loan";
//        List<Loan> loans = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int loanCode = resultSet.getInt("LoanCode");
//                Timestamp startLoan = resultSet.getTimestamp("StartLoan");
//                Timestamp endLoan = resultSet.getTimestamp("EndLoan");
//                String FK_User = resultSet.getString("FK_User");
//                loans.add(new Loan(loanCode, startLoan, endLoan, FK_User));
//            }
//        }
//        return loans;
//    }
//
//    public Loan read(int loanCode) throws SQLException {
//        String query = "SELECT * FROM mtl.Loan WHERE LoanCode = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, loanCode);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                Timestamp startLoan = resultSet.getTimestamp("StartLoan");
//                Timestamp endLoan = resultSet.getTimestamp("EndLoan");
//                String FK_User = resultSet.getString("FK_User");
//                return new Loan(loanCode, startLoan, endLoan, FK_User);
//            }
//        }
//        return null;
//    }
//
//    public void update(int loanCode, Timestamp startLoan, Timestamp endLoan, String FK_User) throws SQLException {
//        String query = "UPDATE mtl.Loan SET StartLoan = ?, EndLoan = ?, FK_User = ? WHERE LoanCode = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setTimestamp(1, startLoan);
//            statement.setTimestamp(2, endLoan);
//            statement.setString(3, FK_User);
//            statement.setInt(4, loanCode);
//            statement.executeUpdate();
//        }
//    }
//
//    public void delete(int loanCode) throws SQLException {
//        String query = "DELETE FROM mtl.Loan WHERE LoanCode = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, loanCode);
//            statement.executeUpdate();
//        }
//    }
//}