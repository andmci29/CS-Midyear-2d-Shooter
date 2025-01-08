import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        isKeyDown();
    }
    
    public void isKeyDown(){
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+2);
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+2, getY());
        }
        if(Greenfoot.isKeyDown("space")){
            getWorld().addObject(new P2_Proj(), getX(), getY());
        }
    }
}
