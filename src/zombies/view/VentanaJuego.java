package zombies.view;

import game.elements.ContenedorGrafico;
import game.elements.Sprite;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import zombies.elements.Ciudad;

/**
 *
 * @author Carlos Andres Rojas Parra
 */
public class VentanaJuego extends javax.swing.JFrame implements ContenedorGrafico {

    Ciudad ciudad;

    public VentanaJuego(Ciudad c) {
        ciudad = c;
        initComponents();

        this.setLocationRelativeTo(null);

    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        ciudad.paint(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        ciudad.mouseMoved(evt);

    }//GEN-LAST:event_formMouseMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_A) {
            ciudad.keyPressed(evt.getKeyCode());
        }
        if (evt.getKeyCode() == KeyEvent.VK_Z) {
            ciudad.keyPressed(evt.getKeyCode());
        }
        if (evt.getKeyCode() == KeyEvent.VK_S) {
            ciudad.keyPressed(evt.getKeyCode());
        }
        if (evt.getKeyCode() == KeyEvent.VK_X) {
            ciudad.keyPressed(evt.getKeyCode());
        }

    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        ciudad.mousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        Sprite.jugando = false;
    }//GEN-LAST:event_formMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        Sprite.jugando = true;
    }//GEN-LAST:event_formMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        int width = 850;
        int height = 550;

        Ciudad c = new Ciudad(0, 0, width, height);

        VentanaJuego ventana = new VentanaJuego(c);
        ventana.setSize(width, height);
        c.setContenedor(ventana);
        //ventana.pack();

        ventana.setVisible(true);

    }

    @Override
    public Rectangle getBordes() {
        return new Rectangle(WIDTH, HEIGHT);
    }

    @Override
    public void refresh() {
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
