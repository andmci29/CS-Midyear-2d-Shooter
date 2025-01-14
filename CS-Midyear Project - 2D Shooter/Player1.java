import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    private int reloadTime;
    private int rpCounter;
    private int spCounter;
    public Player1(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        reloadTime = 0;
        rpCounter = 0;
        spCounter = 0;
    }
    public void act()
    {
        isKeyDown();
    }
    public void isKeyDown(){
        if(Greenfoot.isKeyDown("w")){
            if(rpCounter > 0){
                move(5);
            } else {
                move(2);
            }
        }
        if(Greenfoot.isKeyDown("a")){
            turn(-5);
        }
        if(Greenfoot.isKeyDown("s")){
            if(rpCounter > 0){
                move(-5);
            } else {
                move(-2);
            }
        }
        if(Greenfoot.isKeyDown("d")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("x")){
            getWorld().addObject(new P1Proj(getRotation(), 5), getX(), getY());
        }
    }
}

