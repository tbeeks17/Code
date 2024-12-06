/*

* Written by TJ Beeks

*/

import javax.swing.*;

import java.awt.*;

 

public class SierpinskiTriangle extends JPanel {

 

    // Recursive method to draw Sierpinski Triangle

    public void drawTriangle(Graphics g, int x, int y, int sideLength, int depth) {

        if (depth == 0) {

            // Base case: draw an equilateral triangle

            int[] xPoints = {x, x + sideLength / 2, x - sideLength / 2};

            int[] yPoints = {y, y + (int) (Math.sqrt(3) / 2 * sideLength), y + (int) (Math.sqrt(3) / 2 * sideLength)};

            g.fillPolygon(xPoints, yPoints, 3);

        } else {

            // Recursive case: Draw three smaller triangles

            int newSideLength = sideLength / 2;

           

            // Top triangle

            drawTriangle(g, x, y, newSideLength, depth - 1);

           

            // Bottom-left triangle

            drawTriangle(g, x - newSideLength / 2, y + (int) (Math.sqrt(3) / 2 * newSideLength), newSideLength, depth - 1);

           

            // Bottom-right triangle

            drawTriangle(g, x + newSideLength / 2, y + (int) (Math.sqrt(3) / 2 * newSideLength), newSideLength, depth - 1);

        }

    }

 

    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        setBackground(Color.WHITE);

        g.setColor(Color.BLACK);

        // Starting coordinates and side length for the main triangle

        int sideLength = getWidth() / 2;  // Half the width of the panel

        drawTriangle(g, getWidth() / 2, 50, sideLength, 5);  // Adjust depth as required

    }

 

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sierpinski Triangle");

        SierpinskiTriangle panel = new SierpinskiTriangle();

        frame.add(panel);

        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}

 