import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.*;
import static java.lang.Math.*;

class WhiteBoard extends javax.swing.JFrame {
    // Below Variable are defined and used for Drawing purpose
    ArrayList<Drawing> alDrawing = new ArrayList<>();
    String drawingType = "freehand";
    Color selectedColor = Color.BLACK;
    int stroke = 1;
    boolean isSolid = false;
    String text = "";
    int startXRect = 0;
    int startYRect = 0;
    int heightRect = 0;
    int widthRect = 0;
    SelectShape selectShape = new SelectShape();

    ArrayList<Server.ClientHandler> alStudent;

    public WhiteBoard(ArrayList<Server.ClientHandler> alS) {
        alStudent = alS;
        //setLocationRelativeTo(Server.this);
        initComponents();
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(650, 500);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mOption = new javax.swing.JMenu();
        miClearAll = new javax.swing.JMenuItem();
        miSelectShape = new javax.swing.JMenuItem();
        miSetStroke = new javax.swing.JMenuItem();
        miSetColor = new javax.swing.JMenuItem();
        miBack = new javax.swing.JMenuItem();
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        mOption.setText("White Board Options");
        miClearAll.setText("Clear All");
        miClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClearAllActionPerformed(evt);
            }
        });
        mOption.add(miClearAll);

        miSelectShape.setText("Select Shape");
        miSelectShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSelectShapeActionPerformed(evt);
            }
        });
        mOption.add(miSelectShape);

        miSetStroke.setText("Set Stroke");
        miSetStroke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSetStrokeActionPerformed(evt);
            }
        });
        mOption.add(miSetStroke);


        miSetColor.setText("Set Color");
        miSetColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSetColorActionPerformed(evt);
            }
        });
        mOption.add(miSetColor);
        mOption.add(miBack);
        miBack.setText("Back");
        miBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBackActionPerformed(evt);
            }
        });

        jMenuBar1.add(mOption);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 771, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 416, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void formMousePressed(java.awt.event.MouseEvent evt) {
        startXRect = evt.getX();
        startYRect = evt.getY();
        actualMouseStartX = evt.getX();
        actualMouseStartY = evt.getY();
        if (drawingType.equals("text")) {
            text = JOptionPane.showInputDialog(this, "Input Text", "Input Text", JOptionPane.QUESTION_MESSAGE);
            alDrawing.add(new Drawing(drawingType, startXRect, startYRect, 0, 0, stroke, selectedColor, isSolid, text));
            repaint();
        }
    }

    private void formMouseReleased(java.awt.event.MouseEvent evt) {
        int endX = evt.getX();
        int endY = evt.getY();
        if (drawingType.equals("freehand")) {
            alDrawing.add(new Drawing(drawingType, 0, 0, 0, 0, stroke, selectedColor, isSolid, null));
        } else if (drawingType.equals("rect")) {

            startXRect = min(actualMouseStartX, endX);
            startYRect = min(actualMouseStartY, endY);
            endX = max(actualMouseStartX, endX);
            endY = max(actualMouseStartY, endY);
            widthRect = endX - startXRect;
            heightRect = endY - startYRect;

            alDrawing.add(new Drawing(drawingType, startXRect, startYRect, widthRect, heightRect, stroke, selectedColor, isSolid, null));
        } else if (drawingType.equals("circle")) {

            widthRect = endX - startXRect;
            if (widthRect < 0) {
                widthRect = abs(widthRect);
                startXRect = startXRect - widthRect;
            }
            heightRect = widthRect;

            alDrawing.add(new Drawing(drawingType, startXRect, startYRect, widthRect, heightRect, stroke, selectedColor, isSolid, null));
        } else if (drawingType.equals("square")) {
            widthRect = endX - startXRect;
            if (widthRect < 0) {
                widthRect = abs(widthRect);
                startXRect = startXRect - widthRect;
            }
            heightRect = widthRect;

            alDrawing.add(new Drawing(drawingType, startXRect, startYRect, widthRect, heightRect, stroke, selectedColor, isSolid, null));
        }
        repaint();
    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        try {
            if (drawingType.equals("freehand")) {
                int startX = evt.getX();
                int startY = evt.getY();
                alDrawing.add(new Drawing(drawingType, startX, startY, startX, startY, stroke, selectedColor, isSolid, text));
            }
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void miClearAllActionPerformed(java.awt.event.ActionEvent evt) {
        alDrawing.clear();
        repaint();
    }

    private void miBackActionPerformed(java.awt.event.ActionEvent evt) {
        //openmain();
        this.setVisible(false);
    }

    private void miSelectShapeActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] button =
                {
                        "Select Shape", "Dismiss"
                };
        int n = JOptionPane.showOptionDialog(this, selectShape, "Select Shape", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, button[0]);
        if (n == 0) {
            if (selectShape.rbFreehand.isSelected()) {
                drawingType = "freehand";
            } else if (selectShape.rbCircle.isSelected()) {
                drawingType = "circle";
                int i = JOptionPane.showConfirmDialog(this, "Fill Circle?", "WhiteBoard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    isSolid = true;
                } else {
                    isSolid = false;
                }
            } else if (selectShape.rbRectangle.isSelected()) {
                drawingType = "rect";
                int i = JOptionPane.showConfirmDialog(this, "Fill Rectangle?", "WhiteBoard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    isSolid = true;
                } else {
                    isSolid = false;
                }
            } else if (selectShape.rbSquare.isSelected()) {
                drawingType = "square";
                int i = JOptionPane.showConfirmDialog(this, "Fill Square?", "WhiteBoard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == 0) {
                    isSolid = true;
                } else {
                    isSolid = false;
                }
            } else if (selectShape.rbText.isSelected()) {
                drawingType = "text";
                isSolid = false;
            }
        }
    }

    private void miSetStrokeActionPerformed(java.awt.event.ActionEvent evt) {
        String num = JOptionPane.showInputDialog(this, "Set Stroke", "Stroke", JOptionPane.QUESTION_MESSAGE);
        stroke = Integer.parseInt(num);
    }

    private void miSetColorActionPerformed(java.awt.event.ActionEvent evt) {
        selectedColor = JColorChooser.showDialog(this, "Select Color", selectedColor);

    }

    // Variables declaration - do not modify
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mOption;
    private javax.swing.JMenuItem miClearAll;
    private javax.swing.JMenuItem miSelectShape;
    private javax.swing.JMenuItem miSetColor;
    private javax.swing.JMenuItem miSetStroke;
    private javax.swing.JMenuItem miBack;
    private int actualMouseStartX, actualMouseStartY;
    // End of variables declaration

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

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
            } else if (alDrawing.get(i).shapeType.equals("circle")) {
                int startX = alDrawing.get(i).startingX;
                int startY = alDrawing.get(i).startingY;
                int width = alDrawing.get(i).endingX;
                int height = width;
                if (alDrawing.get(i).isSolid) {
                    g2.fillOval(startX, startY, width, height);
                } else {
                    g2.drawOval(startX, startY, width, height);
                }
            } else if (alDrawing.get(i).shapeType.equals("square")) {
                int startX = alDrawing.get(i).startingX;
                int startY = alDrawing.get(i).startingY;
                int width = alDrawing.get(i).endingX;
                int height = width;
                if (alDrawing.get(i).isSolid) {
                    g2.fillRect(startX, startY, width, height);
                } else {
                    g2.drawRect(startX, startY, width, height);
                }
            } else if (alDrawing.get(i).shapeType.equals("text")) {
                int startX = alDrawing.get(i).startingX;
                int startY = alDrawing.get(i).startingY;
                //g2.setFont(new Font(null,Font.PLAIN,alDrawing.get(i).stroke));
                g2.drawString(alDrawing.get(i).text, startX, startY);
            } else if (alDrawing.get(i).shapeType.equals("freehand")) {
                int startX = alDrawing.get(i).startingX;
                int startY = alDrawing.get(i).startingY;
                if (i < alDrawing.size() - 1) {
                    int endX = alDrawing.get(i + 1).endingX;
                    int endY = alDrawing.get(i + 1).endingY;
                    if ((startX == 0 && startY == 0) || (endX == 0 && endY == 0)) {
                        continue;
                    }
                    g2.drawLine(startX, startY, endX, endY);
                }
            }
        }
        try {
            System.out.println(alDrawing.size() + "");
            for (int i = 0; i < alStudent.size(); i++) {
                alStudent.get(i).dos.writeBytes("drawing\r\n");
                alStudent.get(i).dos.writeInt(alDrawing.size());
                for (int j = 0; j < alDrawing.size(); j++) {
                    alStudent.get(i).dos.writeBytes(alDrawing.get(j).shapeType + "\r\n");
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).startingX);
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).startingY);
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).endingX);
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).endingY);
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).selectedColor.getRed());
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).selectedColor.getGreen());
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).selectedColor.getBlue());
                    alStudent.get(i).dos.writeInt(alDrawing.get(j).stroke);
                    alStudent.get(i).dos.writeBoolean(alDrawing.get(j).isSolid);
                    alStudent.get(i).dos.writeBytes(alDrawing.get(j).text + "\r\n");
                    alStudent.get(i).dos.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}