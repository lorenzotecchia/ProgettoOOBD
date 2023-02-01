package GUI;

import Controller.Controller;
import ImplementazioneDAO.ImplementazioneArticle;
import Model.Article;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;
import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Catalogo riviste.
 */
public class CatalogoArticoli {
    private JPanel panel1;
    private JTable table1;
    private JComboBox topicsBox;
    private JTextField textField1;
    private JButton cercaButton;
    private JButton backButton;
    JFrame frame;

    /**
     * Instantiates a new Catalogo articoli.
     */
    public CatalogoArticoli(Controller controller, JFrame frameChiamante) throws SQLException {
        frame = new JFrame("CatalogoArticoli");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        createTopicsBOx(controller);
        createTable();
        ShowTable(controller);


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
                frameChiamante.setVisible(true);
            }
        });
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
    void ShowTable(Controller controller) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ArrayList<Article> articles = controller.readAllArticles();
        for (Article article : articles) {
            model.addRow(new Object[]{article.getDoi_A(), article.getAccessMode(), article.getAccessMode(), article.getEditor()
                    , article.getTopic(), article.getReleaseDate(), article.getReleaseLocation(), article.getConferenceName(),article.getAuthor(),article.getFK_Magazine()});
        }
    }


    /**
     * Create combo box.
     */
    private void createTopicsBOx(Controller controller) throws SQLException {
        ArrayList<String> topics = controller.getAllTopicsArticle();
        for (String i  : topics) {
            topicsBox.addItem(i);
        }
        topicsBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        ShowTable(controller);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
}
