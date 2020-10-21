/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jorge I. Meza <jimezam at>
 */
public abstract class Sprite 
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage image;
    
    protected ContenedorGrafico contenedor;
    
    public static boolean jugando = false;

    public Sprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    
    public abstract void paint(Graphics g);
   

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage setImage(String filename)
    {
        try 
        {
            setImage(ImageIO.read(new File(filename)));
            
            return getImage();
        } 
        catch (IOException e) 
        {
            System.out.println("No veo la imagen"+filename);
        }
        
        return null;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public boolean fueraContenedor(int x, int y)
    {
        if(getContenedor() == null)
            return false;
        
        Rectangle bounds = getContenedor().getBordes();
        
        return !(x >= bounds.getX() &
                 y>= bounds.getY() &
                 x + getWidth()  <= bounds.getX() + bounds.getWidth() &
                 y + getHeight() <= bounds.getY() + bounds.getHeight());
    }
    
    public boolean fueraContenedor(int x, int y, int w, int h)
    {
        if(getContenedor() == null)
            return false;
        
        Rectangle bounds = new Rectangle(x, y, w, h);
        
        return !(getX() >= bounds.getX() &
                 getY() >= bounds.getY() &
                 getX() + getWidth()  <= bounds.getX() + bounds.getWidth() &
                 getY() + getHeight() <= bounds.getY() + bounds.getHeight());
    }
//    
//    public void updateGameSection()
//    {
//        if(getGameSection() != null)
//            getGameSection().update();
//    }

    public boolean verificarColision(Sprite other)
    {
        // Collision x-axis?
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
            this.getX() < other.getX() + other.getWidth();

        // Collision y-axis?
        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
            this.getY() < other.getY() + other.getHeight();

        // Collision only if on both axes
        return collisionX && collisionY;        
    }

    public ContenedorGrafico getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorGrafico contenedor) {
        this.contenedor = contenedor;
    }
    
    
}
