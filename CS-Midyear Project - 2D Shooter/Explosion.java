import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int timer;
    public Explosion(boolean bigger){
        timer = 100;
        if(bigger){
            GreenfootImage image = getImage();
            image.scale(image.getWidth() * 2, image.getHeight() * 2);
            setImage(image);
        }
    }
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timer--;
        if(timer == 0){
            getWorld().removeObject(this);
        }
    }
}
