package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numberVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    List<LineColor> selectedLines = new ArrayList<>(); //keeping track of the edges that have been colored by the players
    boolean player1 = true;//set player's turn


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point click = e.getPoint();
                for (int i = 0; i < numberVertices; i++) {
                    for (int j = i + 1; j < numberVertices; j++) {
                        if (Math.random() <= edgeProbability) {
                            Line2D line = new Line2D.Double(x[i], y[i], x[j], y[j]);
                            double distance = line.ptSegDist(click);

                            LineColor currentLine = new LineColor(i, j);

                            if (distance < 5) { // the threshold is 5 pixels

                                if (!selectedLines.contains(currentLine)) {
                                    // Check if the line is already colored
                                    boolean alreadyColored = false;
                                    for (LineColor l : selectedLines) {
                                        if ((l.getStart() == currentLine.getStart() && l.getEnd() == currentLine.getEnd())
                                                || (l.getStart() == currentLine.getEnd() && l.getEnd() == currentLine.getStart())) {
                                            alreadyColored = true;
                                            break;
                                        }
                                    }
                                    if (!alreadyColored) {//coloring the line according to each player

                                        if (player1 == true) {
                                            graphics.setColor(Color.RED);
                                            currentLine.setColorLine(Color.RED);

                                            player1 = false;
                                        } else {
                                            graphics.setColor(Color.BLUE);
                                            currentLine.setColorLine(Color.BLUE);

                                            player1 = true;
                                        }


                                        graphics.drawLine(x[i], y[i], x[j], y[j]);
                                        selectedLines.add(currentLine);
                                        repaint();
                                        return;
                                    }
                                }
                            }


                        }
                    }
                }
            }
        });
    }

    private boolean checkForTriangle(LineColor l) {
        //checking if by adding a new line l would form a triangle with the existing edges that have the same color
        int vertex1 = l.getStart();
        int vertex2 = l.getEnd();
        Color color = graphics.getColor();
        for (LineColor line : selectedLines) {
            if (line.getColorLine() == color) {
                int lineVertex1 = line.getStart();
                int lineVertex2 = line.getEnd();
                if (lineVertex1 == vertex1 || lineVertex1 == vertex2 ||
                        lineVertex2 == vertex1 || lineVertex2 == vertex2) {
                    continue;
                }
                Line2D line1 = new Line2D.Double(x[vertex1], y[vertex1], x[vertex2], y[vertex2]);
                Line2D line2 = new Line2D.Double(x[lineVertex1], y[lineVertex1], x[lineVertex2], y[lineVertex2]);
                if (line1.intersectsLine(line2)) {
                    for (LineColor l2 : selectedLines) {
                        if (l2.getColorLine() == color) {
                            int line2Vertex1 = l2.getStart();
                            int line2Vertex2 = l2.getEnd();
                            Line2D line3 = new Line2D.Double(x[line2Vertex1], y[line2Vertex1], x[line2Vertex2], y[line2Vertex2]);
                            if (line3.intersectsLine(line1) && line3.intersectsLine(line2))
                                return true;

                        }
                    }
                }
            }
        }
        return false;
    }


    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numberVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }


    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numberVertices; // the angle
        x = new int[numberVertices];
        y = new int[numberVertices];
        for (int i = 0; i < numberVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }


    private void drawLines() {
        graphics.setColor(Color.PINK);
        for (int i = 0; i < numberVertices; i++) {
            for (int j = i + 1; j < numberVertices; j++) {
                graphics.drawLine(x[i], y[i], x[j], y[j]);
            }
        }
    }

    private void drawVertices() {
        graphics.setColor(Color.RED);
        for (int i = 0; i < numberVertices; i++) {
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
