package zombies.elements;

import game.elements.ContenedorGrafico;
import game.elements.Sprite;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * Descripcion de la clase Jugador
 *
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public class Jugador extends Sprite {

    public static final int WIDTH_JUGADOR = 50;
    public static final int HEIGH_JUGADOR = 50;
    
    

    ///////////////////////////////////////////////////////////////////////////
    public Jugador(int x, int y, int width, int height) {
        super(x, y, width, height);

        setImage("mira1.png");
    }

    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g) {
        //g.drawImage(getImage(), (getX()-(getWidth()/2)), (getY()-(getHeight()/2)), getWidth(), getHeight(), null);
    }

    ///////////////////////////////////////////////////////////////////////////
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        contenedor.refresh();

    }
    
    ///////////////////////////////////////////////////////////////////////////


    
    
}
