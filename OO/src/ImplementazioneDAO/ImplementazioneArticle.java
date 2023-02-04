package ImplementazioneDAO;

import DAO.ArticleDAO;
import Database.ConnessioneDatabase;
import Model.Article;

import java.sql.*;
import java.util.ArrayList;

public class ImplementazioneArticle implements ArticleDAO {
    public static String GET_ALL_ARTICLE = "SELECT * FROM mtl.article a WHERE a.topic = ? AND a.title LIKE '%'|| ? ||'%'; ";
    public static String GET_ALL_TOPICS = "SELECT DISTINCT topic FROM mtl.article";
    public static String GET_ALL_CONFERENCE = "SELECT * FROM mtl.conference WHERE title LIKE '%'|| ? ||'%'; ";
    private final Connection connection;

    public ImplementazioneArticle() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ArrayList<Article> readAll(String topic, String title) throws SQLException {
        ArrayList<Article> articles = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_ARTICLE)) {
            statement.setString(1, topic);
            statement.setString(2, title);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String doi_A = rs.getString("Doi_A");
                title = rs.getString("Title");
                String accessMode = rs.getString("AccessMode");
                String editor = rs.getString("Editor");
                topic = rs.getString("Topic");
                Timestamp releaseDate = rs.getTimestamp("ReleaseDate");
                String releaseLocation = rs.getString("ReleaseLocation");
                String conferenceName = rs.getString("ConferenceName");
                String FK_author = rs.getString("FK_Author");
                String FK_Magazine = rs.getString("FK_Magazine");
                articles.add(new Article(doi_A, title, accessMode, editor, topic, releaseDate, releaseLocation, conferenceName, FK_author, FK_Magazine));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }

    @Override
    public ArrayList<String> getAllTopics() {
        ArrayList<String> topics = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_TOPICS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String topic = rs.getString("Topic");
                topics.add(topic);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return topics;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public ArrayList<String> conference(String title) {
        ArrayList<String> conference = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(GET_ALL_CONFERENCE)){
            statement.setString(1,title);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                title = rs.getString("Title");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String presentationname = rs.getString("presentationName");
                String releaselocarion = rs.getString("releaselocation");
                Timestamp releasedate = rs.getTimestamp("releasedate");
                conference.add(title);
                conference.add(fname);
                conference.add(lname);
                conference.add(presentationname);
                conference.add(releaselocarion);
                conference.add(releasedate.toString());

            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conference;
    }


}





