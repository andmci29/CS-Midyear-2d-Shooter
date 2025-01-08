import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    public Player1(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
    }
    public void act()
    {
        isKeyDown();
    }
    
    public void isKeyDown(){
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY()+2);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+2, getY());
        }
        if(Greenfoot.isKeyDown("x")){
            getWorld().addObject(new P1_Proj(), getX(), getY());
        }
    }
}
