package zombies.elements;

import game.elements.ContenedorSprite;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import game.elements.Sprite;
import game.elements.SpriteMovil;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * Descripcion de la clase Ciudad
 *
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public class Ciudad extends ContenedorSprite {

    private Jugador jugador;
    

    public Ciudad(int x, int y, int width, int height) {
        super(x, y, width, height);

        jugador = new Jugador((width - Jugador.WIDTH_JUGADOR) / 2,
                (height - Jugador.HEIGH_JUGADOR) / 2, Jugador.WIDTH_JUGADOR,
                Jugador.HEIGH_JUGADOR);

        jugador.setContenedor(this);

        setImage("patio3.png");

    }

    ///////////////////////////////////////////////////////////////////////////
    public void mouseMoved(MouseEvent e) {
        jugador.mouseMoved(e);
        
    }

    public void keyPressed(int code) {
        if (code == KeyEvent.VK_A) {
            //Aumenta un zombie en el campo
            addZombieLoco();
            refresh();
        }
        if (code == KeyEvent.VK_Z) {
            //Retira un zombie del campo
            removeZombieLoco();
            refresh();
        }
        if (code == KeyEvent.VK_S) {
            //Aumenta un zombieMutante en el campo
            addZombieMutante();

            refresh();
        }
        if (code == KeyEvent.VK_X) {
            removeZombieLoco();
            refresh();
        }
    }
    ///////////////////////////////////////////////////////////////////////////

    public void mousePressed(java.awt.event.MouseEvent evt) {

        if (evt.getButton() == MouseEvent.BUTTON1) //Izquierdo
        {
            for (int i = 0; i < sprites.size(); i++) {
                Sprite sprite = sprites.get(i);
                boolean b = sprite.verificarColision(jugador);

                if (b) {
                    SpriteMovil s = (SpriteMovil) sprite;
                    if (s.disparoBala()) {
                        this.removeSprite(sprite);
                        return;
                    } else {
                        addZombieLoco(s.getX(), s.getY());
                        this.removeSprite(sprite);
                        return;
                    }
                }
            }

        }

        if (evt.getButton() == MouseEvent.BUTTON3) //Derecho
        {

            for (int i = 0; i < sprites.size(); i++) {
                Sprite sprite = sprites.get(i);
                boolean b = sprite.verificarColision(jugador);

                if (b) {

                    this.removeSprite(sprite);

                }
            }

        }
    }

    ///////////////////////////////////////////////////////////////////////////
    private void addZombieLoco() {
        int xt = (int) (Math.random() * (width - ZombieLoco.WIDTH_ZOMBIE));
        int yt = (int) (Math.random() * (height - ZombieLoco.HEIGH_ZOMBIE));

        ZombieLoco zl = new ZombieLoco(xt, yt, ZombieLoco.WIDTH_ZOMBIE, ZombieLoco.HEIGH_ZOMBIE, this);

        addSprite(zl);

    }

    private void addZombieLoco(int xt, int yt) {

        ZombieLoco zl = new ZombieLoco(xt, yt, ZombieLoco.WIDTH_ZOMBIE, ZombieLoco.HEIGH_ZOMBIE, this);

        addSprite(zl);

    }

    private void addZombieMutante() {
        int xt = (int) (Math.random() * (width - ZombieMutante.WIDTH_ZOMBIE));
        int yt = (int) (Math.random() * (height - ZombieMutante.HEIGH_ZOMBIE));

        ZombieMutante zl = new ZombieMutante(xt, yt, ZombieMutante.WIDTH_ZOMBIE, ZombieMutante.HEIGH_ZOMBIE, this);

        addSprite(zl);
    }

    private void removeZombieLoco() {

        int i = (int) (Math.random() * (sprites.size() - 1));

        if (!sprites.isEmpty()) {
            sprites.remove(i);

        }

    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g) {

        g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);

        for (Sprite sprite : sprites) {
            sprite.paint(g);
        }

        jugador.paint(g);

    }

    @Override
    public Rectangle getBordes() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void refresh() {

        if (contenedor != null) {
            contenedor.refresh();
        }

    }

}
