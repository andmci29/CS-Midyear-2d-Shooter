import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P1Customizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P1Customizer extends Actor
{
    public P1Customizer(){
        getImage().scale(300,75);
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new P1customscreen());
        }
    }
}
