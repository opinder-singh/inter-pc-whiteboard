public class SelectShape extends javax.swing.JPanel {

    public SelectShape() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btGroupShape = new javax.swing.ButtonGroup();
        jLabelSelectShape = new javax.swing.JLabel();
        rbFreehand = new javax.swing.JRadioButton();
        rbRectangle = new javax.swing.JRadioButton();
        rbCircle = new javax.swing.JRadioButton();
        rbSquare = new javax.swing.JRadioButton();
        rbText = new javax.swing.JRadioButton();

        btGroupShape.add(rbCircle);
        btGroupShape.add(rbFreehand);
        btGroupShape.add(rbRectangle);
        btGroupShape.add(rbSquare);
        btGroupShape.add(rbText);

        jLabelSelectShape.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSelectShape.setText("Select Shape");

        rbFreehand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbFreehand.setText("Freehand");

        rbRectangle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbRectangle.setText("Rectangle");

        rbCircle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbCircle.setText("Circle");

        rbSquare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbSquare.setText("Square");

        rbText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbText.setText("Text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbFreehand, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelSelectShape, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelSelectShape, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbFreehand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.ButtonGroup btGroupShape;
    private javax.swing.JLabel jLabelSelectShape;
    public javax.swing.JRadioButton rbCircle;
    public javax.swing.JRadioButton rbFreehand;
    public javax.swing.JRadioButton rbRectangle;
    public javax.swing.JRadioButton rbSquare;
    public javax.swing.JRadioButton rbText;
    // End of variables declaration                   
}