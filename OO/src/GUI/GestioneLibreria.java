package GUI;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class GestioneLibreria extends JFrame{
    private JPanel panel1;

    private JTable table;

    public GestioneLibreria()  {
        JFrame frame = new JFrame("GestioneLibreria");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        //add data to the table
        String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};

        Object[][] data = {
            {"Kathy", "Smith",
             "Snowboarding", 5, false},
            {"John", "Doe",
             "Rowing", 3, true},
            {"Sue", "Black",
             "Knitting", 2, false},
            {"Jane", "White",
             "Speed reading", 20, true},
            {"Joe", "Brown",
             "Pool", 10, false}
        };

        table = new JTable(data, columnNames);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.yellow);

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        panel1.add(scrollPane);




    }

    public static void main(String[] args) {
        new GestioneLibreria();
    }
}
