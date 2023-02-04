package Controller;

import DAO.*;
import ImplementazioneDAO.*;
import Model.*;

import java.sql.SQLException;
import java.util.ArrayList;


public class Controller {

    public Controller() {

    }

    ///////////////////////////ARTICLE/////////////////////////////////////
    public ArrayList<Article> readAllArticles(String topic, String title) throws SQLException {
        ArticleDAO articleDAO = new ImplementazioneArticle();
        return articleDAO.readAll(topic, title);
    }


    public ArrayList<String> getAllTopicsArticle() throws SQLException {
        ArticleDAO articleDAO = new ImplementazioneArticle();
        return articleDAO.getAllTopics();
    }

    public ArrayList<String> readAllConference(String title){
        ArticleDAO articleDAO = new ImplementazioneArticle();
        return articleDAO.conference(title);
    }


    ///////////////////////////AUTHOR/////////////////////////////////////

    public ArrayList<Author> readAllAuthors() {
        AuthorDAO authorDAO = new ImplementazioneAuthor();
        return authorDAO.readAll();
    }


    ///////////////////////////BOOK/////////////////////////////////////
    public ArrayList<Book> readAllBooks(String arg, String lang, String accessMode, boolean reprint, String title, String author) throws SQLException {
        BookDAO bookDAO = new ImplementazioneBook();
        return bookDAO.readAll(arg, lang, accessMode, reprint, title, author);
    }

    public ArrayList<String> getAllArgumentsBook() throws SQLException {
        BookDAO bookDAO = new ImplementazioneBook();
        return bookDAO.getAllArguments();
    }

    public ArrayList<String> getAllLanguagesBook() throws SQLException {
        BookDAO bookDAO = new ImplementazioneBook();
        return bookDAO.getAllLanguages();
    }

    public ArrayList<String> getAllAccessBook() throws SQLException {
        BookDAO bookDAO = new ImplementazioneBook();
        return bookDAO.getAllAccess();
    }

    ///////////////////////////CONFERENCE/////////////////////////////////////

    public ArrayList<Conference> getAllConference(String title) throws SQLException{
        ConferenceDAO conferenceDAO = new ImplementazioneConference();
        return conferenceDAO.getAllConference(title);
    }

    ///////////////////////////PRESENTATION/////////////////////////////////////
    public ArrayList<Presentation> readAllPresentations(String title) throws SQLException {
        PresentationDAO presentationDAO = new ImplementazionePresentation();
        return presentationDAO.getAllPresentation(title);
    }
    ///////////////////////////MAGAZINE////////////////////////////////////
    public ArrayList<Magazine> readAllMagazines(String publicationPeriod, String argument, String name_m) throws SQLException {
        MagazineDAO magazineDAO = new ImplementazioneMagazine();
        return magazineDAO.readAll(publicationPeriod, argument, name_m);
    }

    public ArrayList<String> getAllPerioditicitaMagazine() throws SQLException {
        MagazineDAO magazineDAO = new ImplementazioneMagazine();
        return magazineDAO.getAllPeriodicities();
    }

    public ArrayList<String> getAllArgumentsMagazine() throws SQLException {
        MagazineDAO magazineDAO = new ImplementazioneMagazine();
        return magazineDAO.getAllArguments();
    }

    ///////////////////////////SERIES/////////////////////////////////////
    public ArrayList<Series> readAllSeries(Integer edition, String name) throws SQLException {
        SeriesDAO seriesDAO = new ImplementazioneSeries();
        return seriesDAO.readAll(edition, name);
    }

    public ArrayList<String> getAllEdition() throws SQLException {
        SeriesDAO seriesDAO = new ImplementazioneSeries();
        return seriesDAO.getAllEditions();
    }

}