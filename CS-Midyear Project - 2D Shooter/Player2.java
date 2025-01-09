import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    private int reloadTime;
    private int rpCounter;
    private int spCounter;
    public Player2(){
        reloadTime = 0;
        rpCounter = 0;
        spCounter = 0;
    }
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
            move(-2);
        }
        if(Greenfoot.isKeyDown("left")){
            turn(-5);
        }
        if(Greenfoot.isKeyDown("down")){
            move(2);
        }
        if(Greenfoot.isKeyDown("right")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("space")){
            getWorld().addObject(new P2Proj(getRotation(), 5), getX(), getY());
        }
    }
}
