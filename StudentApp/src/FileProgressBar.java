public class FileProgressBar extends javax.swing.JFrame {

        public FileProgressBar(String fileName, int fileSize) {
            initComponents();
            //setAlwaysOnTop(true);
            setResizable(false);
            //setLocationRelativeTo(Client.this);
            setVisible(true);
            lbFileName.setText("Receiving file : " + fileName);
            jProgBar.setMaximum(fileSize);
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            jProgBar = new javax.swing.JProgressBar();
            lbFileName = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            //setUndecorated(true);

            lbFileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lbFileName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbFileName.setText("jLabel1");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jProgBar, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                                            .addComponent(lbFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jProgBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>                        

        // Variables declaration - do not modify                     
        private javax.swing.JLabel lbFileName;
        public javax.swing.JProgressBar jProgBar;
        // End of variables declaration                   
    }
