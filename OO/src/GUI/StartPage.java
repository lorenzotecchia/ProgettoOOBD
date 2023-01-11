package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import GUI.LoginForm;

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


    prestitiButton.addActionListener(new ActionListener() {
        /**
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
        prestitiButton.addContainerListener(new ContainerAdapter() {
        });
        prestitiButton.addComponentListener(new ComponentAdapter() {
        });
        prestitiButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginForm();

            }
        });
    }

    public static void main(String[] args) {
        new StartPage();
    }
}
