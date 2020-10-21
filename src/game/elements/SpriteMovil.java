/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.elements;

/**
 *
 * Descripcion de la clase SpriteMovil
 * 
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class SpriteMovil extends Sprite implements Runnable{

    protected boolean running;
    protected boolean pausa;
    
    protected long delay;
    protected Thread hilo;
    
   
    
    
    public SpriteMovil(int x, int y, int width, int height) {
        super(x, y, width, height);
        
        hilo = new Thread(this);
        
     
        
        delay = 500;
        running = false;
        pausa = false;
        
        
    }

    public abstract boolean mover();

    
    public boolean isRunning() {
        return running;
    }

    public void parar() {
        this.running = false;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void pausar () {
        this.pausa = true;
    }
    
    public void dePausar () {
        this.pausa = false;
    }
    
    //////////////////////////////////////////////////////////////////////////
    
    public abstract boolean disparoBala();
    
    
}
