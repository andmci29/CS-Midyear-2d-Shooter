import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P2Customizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2Customizer extends Actor
{
    public P2Customizer(){
        getImage().scale(300,75);
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new P2customscreen());
        }
    }
}
