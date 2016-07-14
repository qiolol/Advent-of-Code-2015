import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Patrick on 2016-07-06.
 */
public class PixelGrid extends JPanel {

    private BufferedImage grid;
    private int delay = 1; // Desired delay between instruction rendering

    public PixelGrid() {
        grid = new BufferedImage(1000, 1000, BufferedImage.TYPE_BYTE_BINARY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(grid, 0, 0, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    public void turnOff(int x1, int y1, int x2, int y2) throws InterruptedException {
        Thread.sleep(0, delay);
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                grid.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
        //repaint();
    }

    public void turnOn(int x1, int y1, int x2, int y2) throws InterruptedException {
        Thread.sleep(0, delay);
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                grid.setRGB(x, y, Color.WHITE.getRGB());
            }
        }
        //repaint();
    }

    public void toggle(int x1, int y1, int x2, int y2) throws InterruptedException {
        Thread.sleep(0, delay);
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                // For reasons, black is represented by the integer -16777216, white by -1.
                // If white, turn black.
                if (grid.getRGB(x, y) == -1) {
                    turnOff(x, y, x, y);
                }
                // Otherwise, turn white.
                else {
                    turnOn(x, y, x, y);
                }
            }
        }
        //repaint();
    }

    // Displays this pixel grid in a window
    public void display() {
        JFrame aWindow = new JFrame();

        aWindow.add(this);
        aWindow.pack();
        aWindow.setVisible(true);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
