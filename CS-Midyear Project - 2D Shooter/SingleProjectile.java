import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingleProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingleProjectile extends Actor
{
    private int speed;
    /**
     * Act - do whatever the Stinger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SingleProjectile(){
    }
    public SingleProjectile(int speed){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        this.speed=speed;
    }
    public void act()
    {
        setLocation(getX()-(7*speed), getY());
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
