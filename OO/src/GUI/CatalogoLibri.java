package GUI;

import Controller.Controller;
import ImplementazioneDAO.ImplementazioneBook;
import Model.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class CatalogoLibri {
    private JPanel panel1;
    private JTextField textField1;
    private JButton cercaButton;
    private JTable table1;
    private JButton backButton;
    private JComboBox argumentBox;
    private JComboBox reprintBox;
    private JComboBox languageBox;
    private JComboBox accessBox;
    JFrame frame;

    private String titolo;

    public CatalogoLibri(Controller controller, JFrame frameChiamante) throws SQLException {
        frame = new JFrame("CatalogoLibri");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        createReprintBox();
        createArgsBox(controller);
        createLanguageBox(controller);
        createAccessBox(controller);
        createTable();
        showTable(controller);

        cercaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });
        textField1.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                titolo = textField1.getText();
            }
        });
        backButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
            }
        });
    }

    private void createAccessBox(Controller controller) throws SQLException {
        ArrayList<String> access= controller.getAllAccessBook();
        for (String acc : access) {
            accessBox.addItem(acc);
        }
    }

    private void createLanguageBox(Controller controller) throws SQLException {
        ArrayList<String> langs = controller.getAllLanguagesBook();
        for (String lang : langs) {
            languageBox.addItem(lang);
        }

    }

    private void showTable(Controller controller) throws SQLException {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ArrayList<Book> books = controller.readAllBooks();
        for (Book book : books) {
            model.addRow(new Object[]{book.getDoi_B(), book.getISBN_B(), book.getPublishingHouse(), book.getLanguage(),
                    book.getAccessMode(), book.getTitle(), book.getArgument(), book.getReprint(), book.getReleaseDate(),
                    book.getReleaseLocation(), book.getPresentationName(), book.getAuthor(), book.getFK_Series()});
        }

    }

    private void createTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Doi Book");
        model.addColumn("ISBN Book");
        model.addColumn("PublishingHouse");
        model.addColumn("Language");
        model.addColumn("Argument");
        model.addColumn("Title");
        model.addColumn("AccessModete");
        model.addColumn("Reprint");
        model.addColumn("ReleaseDate");
        model.addColumn("Release Location");
        model.addColumn("Presentation Name");
        model.addColumn("Author");
        model.addColumn("Series");
        table1.setModel(model);

        TableColumnModel cols = table1.getColumnModel();
        cols.getColumn(0).setPreferredWidth(300);
        cols.getColumn(1).setPreferredWidth(300);
        cols.getColumn(2).setPreferredWidth(100);
        cols.getColumn(3).setPreferredWidth(100);
        cols.getColumn(4).setPreferredWidth(100);
        cols.getColumn(5).setPreferredWidth(450);
        cols.getColumn(6).setPreferredWidth(100);
        cols.getColumn(7).setPreferredWidth(100);
        cols.getColumn(8).setPreferredWidth(100);
        cols.getColumn(9).setPreferredWidth(100);
        cols.getColumn(10).setPreferredWidth(450);
        cols.getColumn(11).setPreferredWidth(100);
        cols.getColumn(12).setPreferredWidth(100);

    }

    private void createReprintBox() {
        reprintBox.addItem("All Prints");
        reprintBox.addItem("Si");
        reprintBox.addItem("No");
    }

    private void createArgsBox(Controller controller) throws SQLException {
        ArrayList<String> args = controller.getAllArgumentsBook();
        for (String arg : args) {
            argumentBox.addItem(arg);
        }
    }


}
