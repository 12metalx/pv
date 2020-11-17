
package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuFrame extends javax.swing.JFrame {

   // private javax.swing.JInternalFrame menu = new javax.swing.JInternalFrame("Menu",false,false,false);
    private javax.swing.JDesktopPane menu = new javax.swing.JDesktopPane();
    private javax.swing.JButton products = new javax.swing.JButton("Producos");
    public MenuFrame() {
        initComponents();
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        Dimension dim = bounds.getSize();
        
       this.setSize(dim);
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(this.menu);
  
        this.menu.setSize((int)this.getWidth()/8,this.getBounds().height-20);
        this.menu.add(this.products);
        this.products.setLocation(0, 0);
        this.products.setSize(this.menu.getSize().width,this.menu.getSize().height/10);
        this.products.setVisible(true);
        
        
        
        this.menu.setVisible(true);
        
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
