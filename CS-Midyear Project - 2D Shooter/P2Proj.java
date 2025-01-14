import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;

/**
 * Write a description of class P2Proj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2Proj extends Actor
{
    private int rotation;
    private int speed;
    public P2Proj(int rotation, int speed){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        turn(rotation);
        this.speed = speed;
    }
    public void act()
    {
        move(-speed);
        isTouching();
    }
    public void isTouching(){
        if(isTouching(Player1.class)){
            ((MyWorld)getWorld()).changeP2Score(-2);
        }
        if(isAtEdge() || isTouching(Player1.class)){
            getWorld().removeObject(this);
        }
    }
}