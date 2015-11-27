/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstt.main;

import cstt.core.CoveringPath;
import cstt.core.Node;
import cstt.core.SpanningTree;
import cstt.ultilities.Contants;
import cstt.ultilities.Ultilities;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Tuan
 */
public class NewJFrame extends javax.swing.JFrame {

    private int map[][];
    private int rows;
    private int cols;
    private int result[][];
    private int start;
    private boolean canDraw;
    private boolean pickObstacles;
    private boolean pickStart;
    private boolean hasSpanningTree;
    private SpanningTree st;
    int offsetTop;
    int offsetLeft;
    private JLabel startLabel;
    private ImageIcon squareImage;
    private ImageIcon obstacleImage;
    private ImageIcon startImage;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        canDraw = true;
        hasSpanningTree = false;
        pickObstacles = false;
        pickStart = false;
        start = -1;
        cols = 0;
        rows = 0;
        map = null;
        st = null;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/square.png"));
            squareImage = new ImageIcon(img.getScaledInstance(Contants.squareSize, Contants.squareSize,
                    Image.SCALE_SMOOTH));
            img = ImageIO.read(new File("images/obstacle.png"));
            obstacleImage = new ImageIcon(img.getScaledInstance(Contants.squareSize, Contants.squareSize,
                    Image.SCALE_SMOOTH));
            img = ImageIO.read(new File("images/start.png"));
            startImage = new ImageIcon(img.getScaledInstance(Contants.squareSize, Contants.squareSize,
                    Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        colField = new javax.swing.JTextField();
        rowField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Size");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("X:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Y:");

        colField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        colField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        colField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colFieldActionPerformed(evt);
            }
        });

        rowField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setText("Draw");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Spanning Tree");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Covering Path");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Obstacles");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Start");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(colField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(rowField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(colField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(rowField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        map = null;
        canDraw = true;
        pickObstacles = false;
        pickStart = false;
        start = -1;
        rows = 0;
        cols = 0;
        st = null;
        hasSpanningTree = false;
        jButton5.setBackground(new Color(240, 240, 240));
        jButton4.setBackground(new Color(240, 240, 240));

        jPanel1.removeAll();
        String x = colField.getText().trim();
        String y = rowField.getText().trim();

        if (Ultilities.isInteger(x) && Ultilities.isInteger(y)) {
            colField.setBackground(new Color(255, 255, 255));
            rowField.setBackground(new Color(255, 255, 255));

            rows = Integer.parseInt(x);
            cols = Integer.parseInt(y);
            map = new int[rows][cols];

            Dimension panelSize = jPanel1.getSize();
            offsetLeft = Contants.paddingLeft;
            offsetTop = Contants.paddingTop;

            if (Contants.squareSize * cols < panelSize.width) {
                offsetLeft = (panelSize.width - Contants.squareSize * cols) / 2;
            } else if (Contants.squareSize * cols == panelSize.width) {
                offsetLeft = 0;
            }
            if (Contants.squareSize * rows < panelSize.height) {
                offsetTop = (panelSize.height - Contants.squareSize * rows) / 2;
            } else if (Contants.squareSize * rows == panelSize.height) {
                offsetTop = 0;
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    map[i][j] = 0;
                    JLabel jLabelObject = new JLabel();
                    jLabelObject.setIcon(squareImage);
                    jLabelObject.putClientProperty("i", i);
                    jLabelObject.putClientProperty("j", j);
                    jLabelObject.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            if (canDraw) {
                                JLabel jLabelObject = (JLabel) e.getSource();
                                int i = (Integer) jLabelObject.getClientProperty("i");
                                int j = (Integer) jLabelObject.getClientProperty("j");
                                if (pickObstacles) {
                                    System.out.println("Pick obstacles:(" + i + "," + j + ")");
                                    if (jLabelObject != startLabel) {
                                        if (map[i][j] == 2) {
                                            map[i][j] = 0;
                                            jLabelObject.setIcon(squareImage);
                                        } else {

                                            map[i][j] = 2;
                                            jLabelObject.setIcon(obstacleImage);
                                        }
                                    }
                                } else if (pickStart) {
                                    System.out.println("Pick start");
                                    if (map[i][j] != 2) {
                                        if (start == -1) {
                                            startLabel = jLabelObject;
                                            startLabel.setIcon(startImage);
                                            start = i * cols + j;
                                            // Mark new start point
                                        } else {
                                            // Unmark old start point
                                            startLabel.setIcon(squareImage);
                                            // Mark new start point
                                            startLabel = jLabelObject;
                                            startLabel.setIcon(startImage);
                                            start = i * cols + j;
                                        }
                                    }
                                    System.out.println(start);
                                }
                            }
                        }
                    });
                    int xOffset = offsetLeft + j * Contants.squareSize;
                    int yOffset = offsetTop + i * Contants.squareSize;
                    jLabelObject.setBounds(xOffset, yOffset, Contants.squareSize, Contants.squareSize);
                    jPanel1.add(jLabelObject);//add label we have made
                }
            }
        } else {
            if (!Ultilities.isInteger(x)) {
                colField.setBackground(new Color(26, 188, 156));
            } else {
                colField.setBackground(new Color(255, 255, 255));
            }
            if (!Ultilities.isInteger(y)) {
                rowField.setBackground(new Color(26, 188, 156));
            } else {
                rowField.setBackground(new Color(255, 255, 255));
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ((map != null) && (start != -1) && !hasSpanningTree) {
            canDraw = false;
            st = new SpanningTree(map, start);
            st.findSpanningTree();
            ArrayList<Node> order = st.getOrder();
            Graphics g = jPanel1.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(10));
            g2.setColor(new Color(241, 196, 15));

            if (order.size() == 1) {

                int x1 = st.getStartY() * Contants.squareSize + offsetLeft + Contants.squareSize / 2;
                int y1 = st.getStartX() * Contants.squareSize + offsetTop;
                int x2 = st.getStartY() * Contants.squareSize + offsetLeft + Contants.squareSize / 2;
                int y2 = st.getStartX() * Contants.squareSize + offsetTop + Contants.squareSize / 2;

                g2.drawLine(x1, y1, x2, y2);
            } else {
                for (int i = 1; i < order.size(); i++) {
                    Node first = order.get(i);
                    Node second = first.getParent();
                    int x1 = first.getJ() * Contants.squareSize + offsetLeft + Contants.squareSize / 2;
                    int y1 = first.getI() * Contants.squareSize + offsetTop + Contants.squareSize / 2;

                    int x2 = second.getJ() * Contants.squareSize + offsetLeft + Contants.squareSize / 2;
                    int y2 = second.getI() * Contants.squareSize + offsetTop + Contants.squareSize / 2;
                    g2.drawLine(x1, y1, x2, y2);
                }
            }
            hasSpanningTree = true;
        } else {
            // Something mart there
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pickObstacles = true;
        pickStart = false;
        jButton4.setBackground(Color.red);
        jButton5.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pickObstacles = false;
        pickStart = true;
        jButton5.setBackground(Color.red);
        jButton4.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (hasSpanningTree) {
            int[][] mapX4 = Ultilities.subdivide(map, st.getOrder());
            CoveringPath cp = new CoveringPath(mapX4, start);
            cp.findWay();
            ArrayList<Node> path = cp.getPath();
            Graphics g = jPanel1.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.setColor(new Color(22, 160, 133));
            for (int i = 0; i < path.size() - 1; i++) {
                Node start = path.get(i);
                Node end = path.get(i + 1);
                int x1 = offsetLeft + start.getJ() * (Contants.squareSize / 2) + Contants.squareSize / 4;
                int y1 = offsetTop + start.getI() * (Contants.squareSize / 2) + Contants.squareSize / 4;
                int x2 = offsetLeft + end.getJ() * (Contants.squareSize / 2) + Contants.squareSize / 4;
                int y2 = offsetTop + end.getI() * (Contants.squareSize / 2) + Contants.squareSize / 4;
                g2.drawLine(x1, y1, x2, y2);
                try {
                    Thread.sleep(50);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            System.out.println("Something wrong!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField colField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField rowField;
    // End of variables declaration//GEN-END:variables
}