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
    private int halfWidth;
    private int halfHeight;
    private int duration;
    private boolean onScreen;
    public P1Proj(int rotation){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        turn(rotation);
        this.speed = speed;
        halfWidth = image.getWidth() / 2;
        halfHeight = image.getHeight() / 2;
        duration = 150;
        onScreen = true;
    }
    private void changeEdge(){
        if(getX() < halfWidth){
            setLocation(580 - halfWidth, getY());
        } else 
        if(getX() > 600 - halfWidth){
            setLocation(halfWidth + 20, getY());
        } else
        if(getY() < halfHeight){
            setLocation(getX(), 380 - halfHeight);
        } else
        if(getY() > 400 - halfHeight){
            setLocation(getX(), halfHeight + 20);
        }
    }
    private void degrade(){
        duration--;
        if(duration <= 0){
            getWorld().removeObject(this);
        }
    }
    private void projHit(){
        if(isTouching(P2Proj.class)){
            removeTouching(P2Proj.class);
            onScreen = false;
            getWorld().removeObject(this);
        }
    }
    /**
     * Act - do whatever the P1Proj wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(5);
        changeEdge();
        projHit();
        if(onScreen){
            degrade();
        }
    }
}
