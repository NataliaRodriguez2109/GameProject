package zombies.elements;

import game.elements.ContenedorGrafico;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Descripcion de la clase ZombieLoco
 *
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public class ZombieLoco extends Zombie {

    public static final int WIDTH_ZOMBIE = 48;
    public static final int HEIGH_ZOMBIE = 80;

    private int paso;

    ///////////////////////////////////////////////////////////////////////////
    public ZombieLoco(int x, int y, int width, int height, ContenedorGrafico c) {
        super(x, y, width, height);

        setImage("zombie1.png");
        
        contenedor = c;
        paso = (int) ((Math.random()*10)+5);
        //paso = 1;
        if(contenedor != null)
            hilo.start();
    }

    //////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g) {

        g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);

    }

    ///////////////////////////////////////////////////////////////////////////
    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    @Override
    public boolean mover() {

        int direccion = (int) (Math.random() * 3);

        int nx = x;
        int ny = y;
        switch (direccion) {
            case 0:   //ARRIBA
                
                ny -= paso;
                
             break;
                
            case 1:  //ABAJO
                ny += paso;
             break;
                
            case 2: // IZQUIERDA
                nx -= paso;
             break;
                
            case 3:  // DERECHA
                nx += paso;
             break;
        }           
        if(!fueraContenedor(nx, ny))
        {      
            x = nx;
            y = ny;
            //System.out.println("Me movi");
            if(contenedor != null)
            {
               contenedor.refresh(); 
            }
                          
            return true;
        }
        
        return false;

    }

    @Override
    public void run() {

        
        
        running = true;
        while (running) {
            try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {}
            if(!jugando)
                pausar();
            else
                dePausar();
            
            if(isPausa())
                continue;   
            
            mover();
        }
    }

    public boolean disparoBala() {
        return true;
    }

}
