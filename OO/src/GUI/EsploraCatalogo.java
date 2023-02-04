package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.SQLException;

import Controller.Controller;

/**
 * The type Esplora catalogo.
 */
public class EsploraCatalogo {
    private JButton bookButton;
    private JButton seriesButton;
    private JButton magazineButton;
    private JButton articleButton;
    private JButton backButton;
    private JPanel panel1;
    private JButton presentationsButton;
    private JButton conferencesButton;
    JFrame frame;

    /**
     * Instantiates a new Esplora catalogo.
     */
    public EsploraCatalogo(Controller controller, JFrame frameChiamante ) {
        frame = new JFrame("EsploraCatalogo");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

backButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
            }
        });



        bookButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                CatalogoLibri libri;
                try {
                    libri = new CatalogoLibri(controller, frame);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                libri.frame.setVisible(true);
            }
        });
        seriesButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                CatalogoCollane serie = null;
                try {
                    serie = new CatalogoCollane(controller, frame);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                serie.frame.setVisible(true);

            }
        });

magazineButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                CatalogoRiviste riviste = null;
                try {
                    riviste = new CatalogoRiviste(controller, frame);
                } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                }
                riviste.frame.setVisible(true);
            }
        });

        articleButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                CatalogoArticoli articoli;
                try {
                    articoli = new CatalogoArticoli(controller, frame);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                articoli.frame.setVisible(true);
            }
        });
        presentationsButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Presentazioni presentazioni;
                try {
                    presentazioni = new Presentazioni(controller, frame);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                presentazioni.frame.setVisible(true);

            }
        });
        conferencesButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Conferenze conferenze;
                try {
                    conferenze = new Conferenze(controller, frame);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                conferenze.frame.setVisible(true);
            }
        });
    }
}