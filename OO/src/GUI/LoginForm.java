package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm {
    private JPanel LogIN;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton OKButton;
    private JButton cancelButton;
    private JButton backButton;

    public LoginForm() {

        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(LogIN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());

//            user = getAutenticatedUser(email, password);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Authentication cancelled");
                System.exit(0);
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                new StartPage();
            }
        });
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}