package GUI;

import Controller.Controller;
import ImplementazioneDAO.ImplementazioneArticle;
import Model.Article;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Catalogo riviste.
 */
public class CatalogoArticoli {

    private JPanel panel1;
    private JTable table1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton cercaButton;
    private JButton backButton;

    /**
     * Instantiates a new Catalogo articoli.
     */
    public CatalogoArticoli() {
        JFrame frame = new JFrame("CatalogoArticoli");
        frame.setContentPane(panel1);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        createComboBox();
        createTable();
        ShowTable();


        cercaButton.addMouseListener(new MouseAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String title = textField1.getText();
                ImplementazioneArticle implementazioneArticle = new ImplementazioneArticle();
                ArrayList<Article> articles = implementazioneArticle.CercaPerTitolo(title);
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setRowCount(0);
                for (Article article : articles) {
                    model.addRow(new Object[]{article.getDoi_A(), article.getTitle(), article.getAccessMode(), article.getEditor(),
                            article.getTopic(), article.getReleaseDate(), article.getReleaseLocation(), article.getConferenceName(),article.getAuthor(),article.getFK_Magazine()});
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new StartPage();

            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new CatalogoArticoli();
    }

    /**
     * Gets panel 1.
     *
     * @return the panel 1
     */
    public JPanel getPanel1() {
        return panel1;
    }

    /**
     * Create table.
     */
    void createTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Doi Article");
        model.addColumn("Title");
        model.addColumn("AcccessMode");
        model.addColumn("Editor");
        model.addColumn("Topic");
        model.addColumn("ReleaseDate");
        model.addColumn("ReleaseLocation");
        model.addColumn("ConferenceName");
        model.addColumn("Autore");
        model.addColumn("Rivista");
        
        table1.setModel(model);

        TableColumnModel cols = table1.getColumnModel();
        cols.getColumn(0);
        cols.getColumn(1);
        cols.getColumn(2);
        cols.getColumn(3);
        cols.getColumn(4);
        cols.getColumn(5);
        cols.getColumn(6);
        cols.getColumn(7);
        cols.getColumn(8);
        cols.getColumn(9);
    }

    /**
     * Show table.
     */
    void ShowTable() {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ImplementazioneArticle implementazioneArticle = new ImplementazioneArticle();
        ArrayList<Article> articles = implementazioneArticle.readAll();
        for (Article article : articles) {
            model.addRow(new Object[]{article.getDoi_A(), article.getAccessMode(), article.getAccessMode(), article.getEditor()
                    , article.getTopic(), article.getReleaseDate(), article.getReleaseLocation(), article.getConferenceName(),article.getAuthor(),article.getFK_Magazine()});
        }
    }


    /**
     * Create combo box.
     */
    private void createComboBox() {
        String[] topics;
        ImplementazioneArticle implementazionearticle = new ImplementazioneArticle();
        topics = implementazionearticle.getAllTopics().toArray(new String[0]);
        for (String i  : topics) {
            comboBox1.addItem(i);
        }
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ShowTable();
                }
            }
        });
    }
}
