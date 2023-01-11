package GUI;

import javax.swing.*;
import java.awt.event.*;

public class StartPage {
    private JPanel panel1;
    private JButton prestitiButton;
    //fill the jpanel with an image
    private JButton gestioneButton;
    private JButton catalogoButton;

    public StartPage() {

        JFrame frame = new JFrame("StartPage");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        prestitiButton.addMouseListener(new MouseAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new LoginForm();
            }
        });
        gestioneButton.addMouseListener(new MouseAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new LoginForm();
            }
        });
        catalogoButton.addMouseListener(new MouseAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new EsploraCatalogo();

            }
        });
    }

    public static void main(String[] args) {
        new StartPage();
    }
}