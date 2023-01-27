package Controller;

import DAO.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


public class Controller {
    private Connection connection;
    private BookDAO bookDAO;
    private ArticleDAO articleDAO;
    private MagazineDAO magazineDAO;
    private SeriesDAO seriesDAO;

    public Controller(Connection connection) {
        this.connection = connection;
        bookDAO = new BookDAO(connection);
        articleDAO = new ArticleDAO(connection);
        magazineDAO = new MagazineDAO(connection);
        seriesDAO = new SeriesDAO(connection);
    }





    public void closeConnection() throws SQLException {
        connection.close();
    }
}

