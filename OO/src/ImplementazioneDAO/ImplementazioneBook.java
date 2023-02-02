package ImplementazioneDAO;

import DAO.BookDAO;
import Database.ConnessioneDatabase;
import Model.Book;

import java.sql.*;
import java.util.ArrayList;

public class ImplementazioneBook implements BookDAO {
    private static final String GET_ALL_ACCESS = "SELECT DISTINCT accessmode FROM mtl.book;";
    private static final String GET_ALL_ARGUMENTS = "SELECT  DISTINCT argument FROM mtl.book;";
    private static final String GET_ALL_LANGUAGES = "SELECT DISTINCT language FROM mtl.book;";
    public static String INSERT_BOOK = "INSERT INTO mtl.Book (Doi_B, ISBN_B, Edition, PublishingHouse, Language, Title, Argument, AccessMode, " +
            "Reprint, ReleaseDate, ReleaseLocation, PresentationName, FK_author, FK_Series) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static String READ_ALL_BOOK = "SELECT * FROM mtl.Book b JOIN mtl.author a on b.fk_author=a.codauthor " +
            "WHERE b.argument=? AND b.language=? AND b.accessmode=? AND b.reprint =? AND b.title LIKE '%'|| ? ||'%' AND a.fname like '%'|| ? ||'%';";
    public static String UPDATE_BOOK = "UPDATE mtl.Book SET Doi_B = ?, ISBN_B = ?, Edition = ?, PublishingHouse = ?, Language = ?, Title = ?, Argument = ?, AccessMode = ?, " +
            "Reprint = ?, ReleaseDate = ?, ReleaseLocation = ?, PresentationName = ?, FK_author = ?, FK_Series = ? WHERE Doi_B = ?;";
    public static String DELETE_BOOK = "DELETE FROM mtl.Book WHERE Doi_B = ?;";
    public static String SEARCH_BY_TITLE = "SELECT * FROM mtl.Book b WHERE b.Title = '%'||?||'%';";
    public static String SEARCH_BY_AUTHOR = "SELECT * FROM mtl.Book b JOIN mtl.author a ON b.fk_author = a.codauthor WHERE a.lname = ? OR a.fname = ?;";
    private Connection connection;

    public ImplementazioneBook() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param doi_B
     * @param ISBN_B
     * @param edition
     * @param publishingHouse
     * @param language
     * @param title
     * @param accessMode
     * @param argument
     * @param reprint
     * @param releaseDate
     * @param releaseLocation
     * @param PresentationName
     * @param FK_author
     * @param FK_Series
     * @throws SQLException
     */
    @Override
    public void create(String doi_B, String ISBN_B, int edition, String publishingHouse,
                       String language, String title, String accessMode, String argument, boolean reprint,
                       Timestamp releaseDate, String releaseLocation, String PresentationName, String FK_author, String FK_Series) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_BOOK)) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Book> readAll(String arg, String lang, String accessMode, boolean reprint, String title, String author) {
        ArrayList<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(READ_ALL_BOOK)) {
            statement.setString(1, arg);
            statement.setString(2, lang);
            statement.setString(3, accessMode);
            statement.setBoolean(4, reprint);
            statement.setString(5, title);
            statement.setString(6, author);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String doi_B = rs.getString("Doi_B");
                String ISBN_B = rs.getString("ISBN_B");
                int edition = rs.getInt("Edition");
                String publishingHouse = rs.getString("PublishingHouse");
                lang = rs.getString("Language");
                title = rs.getString("Title");
                arg = rs.getString("Argument");
                accessMode = rs.getString("AccessMode");
                reprint = rs.getBoolean("Reprint");
                Timestamp releaseDate = rs.getTimestamp("ReleaseDate");
                String releaseLocation = rs.getString("ReleaseLocation");
                String PresentationName = rs.getString("PresentationName");
                String FK_author = rs.getString("FK_author");
                String FK_Series = rs.getString("FK_Series");
                books.add(new Book(doi_B, ISBN_B, edition, publishingHouse, lang, title, arg,
                        accessMode, reprint, releaseDate, releaseLocation, PresentationName, FK_author, FK_Series));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public ArrayList<Book> SearchByTitle(String Title) {
        ArrayList<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SEARCH_BY_TITLE)) {
            statement.setString(1, Title);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String doi_B = statement.getResultSet().getString("Doi_B");
                String ISBN_B = statement.getResultSet().getString("ISBN_B");
                int edition = statement.getResultSet().getInt("Edition");
                String publishingHouse = statement.getResultSet().getString("PublishingHouse");
                String language = statement.getResultSet().getString("Language");
                String title = statement.getResultSet().getString("Title");
                String argument = statement.getResultSet().getString("Argument");
                String accessMode = statement.getResultSet().getString("AccessMode");
                boolean reprint = statement.getResultSet().getBoolean("Reprint");
                Timestamp releaseDate = statement.getResultSet().getTimestamp("ReleaseDate");
                String releaseLocation = statement.getResultSet().getString("ReleaseLocation");
                String PresentationName = statement.getResultSet().getString("PresentationName");
                String FK_author = statement.getResultSet().getString("FK_author");
                String FK_Series = statement.getResultSet().getString("FK_Series");
                books.add(new Book(doi_B, ISBN_B, edition, publishingHouse, language, title, argument,
                        accessMode, reprint, releaseDate, releaseLocation, PresentationName, FK_author, FK_Series));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public ArrayList<Book> SearchByAuthor(String Author) {
        ArrayList<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SEARCH_BY_AUTHOR)) {
            statement.setString(1, Author);
            statement.setString(2, Author);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String doi_B = statement.getResultSet().getString("Doi_B");
                String ISBN_B = statement.getResultSet().getString("ISBN_B");
                int edition = statement.getResultSet().getInt("Edition");
                String publishingHouse = statement.getResultSet().getString("PublishingHouse");
                String language = statement.getResultSet().getString("Language");
                String title = statement.getResultSet().getString("Title");
                String argument = statement.getResultSet().getString("Argument");
                String accessMode = statement.getResultSet().getString("AccessMode");
                boolean reprint = statement.getResultSet().getBoolean("Reprint");
                Timestamp releaseDate = statement.getResultSet().getTimestamp("ReleaseDate");
                String releaseLocation = statement.getResultSet().getString("ReleaseLocation");
                String PresentationName = statement.getResultSet().getString("PresentationName");
                String FK_author = statement.getResultSet().getString("FK_author");
                String FK_Series = statement.getResultSet().getString("FK_Series");
                books.add(new Book(doi_B, ISBN_B, edition, publishingHouse, language, title,
                        argument, accessMode, reprint, releaseDate, releaseLocation, PresentationName, FK_author, FK_Series));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    /**
     * @param
     * @return
     */
    @Override
    public ArrayList<String> getAllArguments() {
        ArrayList<String> arguments = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_ARGUMENTS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String argument1 = rs.getString("Argument");
                arguments.add(argument1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arguments;
    }

    /**
     * @return
     */
    @Override
    public ArrayList<String> getAllLanguages() {
        ArrayList<String> languages = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_LANGUAGES)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String language = statement.getResultSet().getString("Language");
                languages.add(language);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return languages;
    }

    /**
     * @return
     */
    @Override
    public ArrayList<String> getAllAccess() {
        ArrayList<String> access = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_ACCESS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String accessMode = statement.getResultSet().getString("AccessMode");
                access.add(accessMode);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return access;
    }

    public void deleteBook(String Doi_B) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BOOK)) {
            statement.setString(1, Doi_B);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(String doi_B, String ISBN_B, int edition, String publishingHouse, String language, String title,
                           String accessMode, String argument, boolean reprint, Timestamp releaseDate, String releaseLocation,
                           String PresentationName, String FK_author, String FK_Series) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK)) {
            statement.setString(1, ISBN_B);
            statement.setInt(2, edition);
            statement.setString(3, publishingHouse);
            statement.setString(4, language);
            statement.setString(5, title);
            statement.setString(6, accessMode);
            statement.setString(7, argument);
            statement.setBoolean(8, reprint);
            statement.setTimestamp(9, releaseDate);
            statement.setString(10, releaseLocation);
            statement.setString(11, PresentationName);
            statement.setString(12, FK_author);
            statement.setString(13, FK_Series);
            statement.setString(14, doi_B);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
