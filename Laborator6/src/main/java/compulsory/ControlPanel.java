package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exit = new JButton("Exit");
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton reset = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }


    private void init() {
        setLayout(new GridLayout(1, 4));

        add(load);
        add(save);
        add(reset);
        add(exit);

        exit.addActionListener(this::exitGame);
        load.addActionListener(this::loadGame);
        save.addActionListener(this::saveGame);
        reset.addActionListener(this::resetGame);
    }

    //Butoanele
    private void resetGame(ActionEvent e) {
        frame.canvas.repaint();
    }

    private void saveGame(ActionEvent e) {

    }

    private void loadGame(ActionEvent e) {

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
