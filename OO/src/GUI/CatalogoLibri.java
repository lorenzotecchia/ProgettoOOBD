package GUI;

import ImplementazioneDAO.ImplementazioneBook;
import Model.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private String titolo;

    public CatalogoLibri() {
        JFrame frame = new JFrame("CatalogoLibri");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        createReprintBox();
        createArgsBox();
        createLanguageBox();
        createAccessBox();
        createTable();
        showTable();

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
                new StartPage();
            }
        });
    }

    private void createAccessBox() {
        String[] access;
        ImplementazioneBook implementazioneBook = new ImplementazioneBook();
        access = implementazioneBook.getAllAccess().toArray(new String[0]);
        for (String acc : access) {
            accessBox.addItem(acc);
        }
    }

    private void createLanguageBox() {
        String[] langs;
        ImplementazioneBook implementazioneBook = new ImplementazioneBook();
        langs = implementazioneBook.getAllLanguages().toArray(new String[0]);
        for (String lang : langs) {
            languageBox.addItem(lang);
        }

    }

    public static void main(String[] args) {
        new CatalogoLibri();

    }

    private void showTable() {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ImplementazioneBook implementazioneBook = new ImplementazioneBook();
        ArrayList<Book> books = implementazioneBook.readAll();
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

    private void createArgsBox() {
        String[] args;
        ImplementazioneBook implementazioneBook = new ImplementazioneBook();
        args = implementazioneBook.getAllArguments().toArray(new String[0]);
        for (String arg : args) {
            argumentBox.addItem(arg);
        }
    }


}
