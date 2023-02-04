package GUI;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Controller.*;
import Model.Conference;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conferenze {
    JFrame frame;
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JButton backButton;

    public Conferenze(Controller controller, JFrame frameChiamante) throws SQLException {
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
        model.addColumn("Conference");
        model.addColumn("Release Location");
        model.addColumn("Release Date");

        table1.setModel(model);
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
    }

    public JPanel getPanel(){
            return panel1;
        }

        public void ShowTable(Controller controller) throws SQLException{
        String title = textField1.getText();
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            ArrayList<Conference> conferences = controller.getAllConference(title);
            for (Conference conference : conferences) {
                model.addRow(new Object[]{conference.getTitle(), conference.getFirstName(), conference.getLastName(), conference.getConferenceName(), conference.getReleasLocation(), conference.getReleaseDate()});
            }

        }
    public void createTextField(Controller controller){
            textField1.getDocument().addDocumentListener(new DocumentListener() {
                /**
                 * @param e the document event
                 */
                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    try {
                        ShowTable(controller);
                    } catch(SQLException ex) {
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
                    } catch(SQLException ex) {
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
                    } catch(SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            });
        }

}
