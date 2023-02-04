package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Model.Presentation;
import java.util.ArrayList;

public class Presentazioni {
    JFrame frame;
    private JPanel panel1;
    private JTextField textField1;
    private JTable table1;

    private JButton backButton;

    public Presentazioni(Controller controller, JFrame frameChiamante) throws SQLException {
        frame = new JFrame("Conferenze");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        createTextField(controller);
        createTable();
        ShowTable(controller);


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

    private void createTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Title");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Presentation");
        model.addColumn("Realease Location");
        model.addColumn("Realease Date");

        table1.setModel(model);
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void ShowTable(Controller controller) throws SQLException {
        String title = textField1.getText();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        ArrayList<Presentation> presentazioni = controller.readAllPresentations(title);
        for (Presentation presentazione: presentazioni) {
            model.addRow(new Object[]{presentazione.getTitle(), presentazione.getFirstName(), presentazione.getLastName(), presentazione.getPresentationName(), presentazione.getReleasLocation(), presentazione.getReleaseDate()});
        }


    }

    public void createTextField(Controller controller) {
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            /**
             * @param e the document event
             */
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    ShowTable(controller);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            /**
             * @param e the document event
             */
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    ShowTable(controller);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            /**
             * @param e the document event
             */
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    ShowTable(controller);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }

}
