package homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exit = new JButton("Exit");
    JButton export = new JButton("Export");
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton reset = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }


    private void init() {
        setLayout(new GridLayout(1, 4));

        //adding the buttons
        add(export);
        add(save);
        add(load);
        add(reset);
        add(exit);

        //when the button is clicked the respective method will be called
        exit.addActionListener(this::exitGame);
        export.addActionListener(e -> {//exception for export
            try {
                export(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        save.addActionListener(this::saveGame);
        reset.addActionListener(this::resetGame);
        load.addActionListener(this::loadGame);

    }

    //Buttons
    private void resetGame(ActionEvent e) {
        frame.dispose();//disposing the current frame
        JFrame newFrame = new JFrame(); //start a new game
        newFrame.setSize(800, 700);
        newFrame.add(new ConfigPanel(frame), BorderLayout.NORTH);
        newFrame.add(new DrawingPanel(frame), BorderLayout.CENTER);
        newFrame.add(new ControlPanel(frame), BorderLayout.SOUTH);
        newFrame.setVisible(true);
    }

    private void saveGame(ActionEvent e) {

    }

    private void loadGame(ActionEvent e) {

    }

    private void export(ActionEvent e) throws IOException {
        BufferedImage image = new BufferedImage(frame.canvas.getWidth(), frame.canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        frame.canvas.paint(g2d);
        ImageIO.write(image, "png", new File("image.png"));//"writting" the created image in a png file named image.png
        g2d.dispose();
    }

    private void exitGame(ActionEvent e) {

        frame.dispose();//disposing the current game
    }
}
