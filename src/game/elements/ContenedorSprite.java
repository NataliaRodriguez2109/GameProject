/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.elements;

import java.util.ArrayList;

/**
 *
 * Descripcion de la clase ContenedorSprite
 * 
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract  class ContenedorSprite extends Sprite implements ContenedorGrafico{
    
    protected ArrayList<Sprite> sprites;
    protected ContenedorGrafico contenedor;
    
    public ContenedorSprite(int x, int y, int width, int height) {
        super(x, y, width, height);
        
        sprites = new ArrayList<>();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    public boolean addSprite (Sprite s)
    {
        return sprites.add(s);
    }
    
    public boolean removeSprite (Sprite s)
    {
        return sprites.remove(s);
    }

    public ContenedorGrafico getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorGrafico contenedor) {
        this.contenedor = contenedor;
    }
    
    
    

}
