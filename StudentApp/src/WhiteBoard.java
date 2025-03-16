import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WhiteBoard extends javax.swing.JFrame {
    ArrayList<Drawing> alDrawing =null;
        public WhiteBoard(ArrayList<Drawing> ald) {
            //setLocationRelativeTo(Client.this);
            alDrawing=ald;
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);
            setSize(650, 500);
        }
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g.create();
            for (int i = 0; i < alDrawing.size(); i++) {
                g2.setColor(alDrawing.get(i).selectedColor);
                g2.setStroke(new BasicStroke(alDrawing.get(i).stroke));
                if (alDrawing.get(i).shapeType.equals("rect")) {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int width = alDrawing.get(i).endingX;
                    int height = alDrawing.get(i).endingY;
                    if (alDrawing.get(i).isSolid) {
                        g2.fillRect(startX, startY, width, height);
                    } else {
                        g2.drawRect(startX, startY, width, height);
                    }
                }
                else if (alDrawing.get(i).shapeType.equals("circle")) {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int width = alDrawing.get(i).endingX;
                    int height = width;
                    if (alDrawing.get(i).isSolid) {
                        g2.fillOval(startX, startY, width, height);
                    } else {
                        g2.drawOval(startX, startY, width, height);
                    }
                }
                else if (alDrawing.get(i).shapeType.equals("square")) {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    int width = alDrawing.get(i).endingX;
                    int height = width;
                    if (alDrawing.get(i).isSolid) {
                        g2.fillRect(startX, startY, width, height);
                    } else {
                        g2.drawRect(startX, startY, width, height);
                    }
                }
                else if (alDrawing.get(i).shapeType.equals("text")) {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    g2.drawString(alDrawing.get(i).text, startX, startY);
                }
                else if (alDrawing.get(i).shapeType.equals("freehand")) {
                    int startX = alDrawing.get(i).startingX;
                    int startY = alDrawing.get(i).startingY;
                    if(i< alDrawing.size()-1){
                        int endX = alDrawing.get(i + 1).endingX;
                        int endY = alDrawing.get(i + 1).endingY;
                        if ((startX == 0 && startY == 0) || (endX == 0 && endY == 0)) {
                            continue;
                        }
                        g2.drawLine(startX, startY, endX, endY);
                    }
                }
            }
        }
    }