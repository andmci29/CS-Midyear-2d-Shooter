import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
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
        if(Greenfoot.isKeyDown("m")){
            getWorld().addObject(new P2Proj(getRotation(), 5), getX(), getY());
        }
        if(Greenfoot.isKeyDown("k")){
            if(rpCounter > 0){
                move(5);
            } else {
                move(2);
            }
        }
        if(Greenfoot.isKeyDown("j")){
            turn(-5);
        }
        if(Greenfoot.isKeyDown("i")){
            if(rpCounter > 0){
                move(-5);
            } else {
                move(-2);
            }
        }
        if(Greenfoot.isKeyDown("l")){
            turn(5);
        }
    }
}
