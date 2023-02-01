package GUI;

import Controller.Controller;
import ImplementazioneDAO.ImplementazioneSeries;
import Model.Series;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class CatalogoCollane {
    JFrame frame;
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JButton cercaButton;
    private JComboBox editionBox;
    private JButton backButton;
    private String titolo;

    public CatalogoCollane(Controller controller, JFrame frameChiamante) throws SQLException {
        frame = new JFrame("CatalogoCollane");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        createEditionBox(controller);
        createTable();
        showTable(controller);

        cercaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                titolo = textField1.getText();
                JFrame frameCollana = new JFrame("CatalogoCollane");
                frameCollana.setContentPane(panel1);
                frameCollana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frameCollana.pack();
                frameCollana.setVisible(true);
                frame.setVisible(false);
                frameCollana.setLocationRelativeTo(null);
                controller.SearchSeriesByName(titolo);
                try {
                    showTable(controller);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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

    private void showTable(Controller controller) throws SQLException {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ArrayList<Series> series = controller.readAllSeries();
        for (Series s : series) {
            model.addRow(new Object[]{s.getISSN_S(), s.getCurator(),
                    s.getEdition(), s.getNameS(), s.getCode()});
        }
    }

    private void createTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ISSN Series");
        model.addColumn("Curator");
        model.addColumn("Edition");
        model.addColumn("Name Series");
        model.addColumn("Code Series");
        table1.setModel(model);

        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);

    }

    private void createEditionBox(Controller controller) throws SQLException {
        ArrayList<String> edition = controller.getAllEdition();
        for (String s : edition) {
            editionBox.addItem(s);
        }

    }

}
