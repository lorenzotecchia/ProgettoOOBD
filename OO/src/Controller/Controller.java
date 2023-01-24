//package Controller;
//
//import DAO.*;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.List;
//
//
//public class Controller {
//    private Connection connection;
//    private EventDAO eventDAO;
//    private BookDAO bookDAO;
//    private ArticleDAO articleDAO;
//    private UserDAO userDAO;
//    private LoanDAO loanDAO;
//    private MagazineDAO magazineDAO;
//    private PresentationDAO presentationDAO;
//    private DiscussionDAO discussionDAO;
//    private SeriesDAO seriesDAO;
//    private DrawingDAO drawingDAO;
//
//    public Controller(Connection connection) {
//        this.connection = connection;
//        eventDAO = new EventDAO(connection);
//        bookDAO = new BookDAO(connection);
//        articleDAO = new ArticleDAO(connection);
//        userDAO = new UserDAO(connection);
//        loanDAO = new LoanDAO(connection);
//        magazineDAO = new MagazineDAO(connection);
//        presentationDAO = new PresentationDAO(connection);
//        discussionDAO = new DiscussionDAO(connection);
//        seriesDAO = new SeriesDAO(connection);
//        drawingDAO = new DrawingDAO(connection);
//    }
//
//    public void createEvent(Timestamp startDate, Timestamp endDate, String locationPromoter, String manager) throws SQLException {
//        eventDAO.create(startDate, endDate, locationPromoter, manager);
//    }
//
//    public List<Event> readAllEvents() throws SQLException {
//        return eventDAO.readAll();
//    }
//
//    public Event readEvent(int codEvent) throws SQLException {
//        return eventDAO.read(codEvent);
//    }
//
//    public void updateEvent(int codEvent, Timestamp startDate, Timestamp endDate, String locationPromoter, String manager) throws SQLException {
//        eventDAO.update(codEvent, startDate, endDate, locationPromoter, manager);
//    }
//
//    public void deleteEvent(int codEvent) throws SQLException {
//        eventDAO.delete(codEvent);
//    }
//
//    // similar methods for other DAO classes
//}
//
