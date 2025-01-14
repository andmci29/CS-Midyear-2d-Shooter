import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedPower extends Actor
{
    private int timer;
    public SpeedPower(){
        timer=0;
    }
    public void act()
    {
        timer++;
        if(timer == 1000){
            getWorld().removeObject(this);
        }
    }
}
