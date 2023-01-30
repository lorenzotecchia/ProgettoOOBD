package GUI;

import ImplementazioneDAO.ImplementazioneSeries;
import Model.Series;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogoCollane {
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JButton cercaButton;
    private JComboBox editionBox;

    private String titolo;

    public CatalogoCollane() {
        JFrame frame = new JFrame("CatalogoCollane");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        createEditionBox();
        createTable();
        showTable();

        cercaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                titolo= textField1.getText();
            }
        });
    }

    private void showTable() {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ImplementazioneSeries implementazioneSeries = new ImplementazioneSeries();
        ArrayList<Series> series = implementazioneSeries.readAll();
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
        model.addColumn("Code Series");
        model.addColumn("Name Series");
        table1.setModel(model);

        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);

    }

    private void createEditionBox() {
        String[] edition;
        ImplementazioneSeries implementazioneSeries = new ImplementazioneSeries();
        edition = implementazioneSeries.getAllEditions().toArray(new String[0]);
        for (String s : edition) {
            editionBox.addItem(s);
        }

    }

    public static void main(String[] args) {
        new CatalogoCollane();
    }

}
