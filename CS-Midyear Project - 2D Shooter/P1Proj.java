import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;

/**
 * Write a description of class P1Proj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P1Proj extends Actor
{
    private int rotation;
    private int speed;
    public P1Proj(int rotation, int speed){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        turn(rotation);
        this.speed = speed;
    }
    /**
     * Act - do whatever the P1Proj wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
    }
}
