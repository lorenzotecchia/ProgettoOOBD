package DAO;

import Model.Magazine;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface MagazineDAO {

    void create(String ISSN_M, String name_M, String argument, String manager, Timestamp yearRelease,
                String publicationPeriod, String publishingHouse, String accessMode);

    void delete(String ISSN_M);

    void update(String ISSN_M, String name_M, String argument, String manager, Timestamp yearRelease,
                String publicationPeriod, String publishingHouse, String accessMode);

    ArrayList<Magazine> readAll();

    ArrayList<Magazine> searchByMagazineName(String name_M);

//    ArrayList<Magazine> searchByMagazinePublicationPeriod(String publicationPeriod);

    ArrayList<String> getAllPeriodicities();

    ArrayList<String> getAllArguments();
}