/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombies.elements;

import game.elements.Sprite;
import game.elements.SpriteMovil;

/**
 *
 * Descripcion de la clase Zombie
 * 
 * @author Carlos Andres Rojas Parra
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Zombie extends SpriteMovil {

    
    ///////////////////////////////////////////////////////////////////////////
    public Zombie(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    ///////////////////////////////////////////////////////////////////////////

}
