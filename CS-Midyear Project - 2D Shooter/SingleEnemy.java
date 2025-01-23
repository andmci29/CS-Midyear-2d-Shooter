import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingleEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingleEnemy extends Actor
{
    private int speed;
    private int rotation;
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SingleEnemy(int rotation){
         speed = (Greenfoot.getRandomNumber(3)+1);
         if (Greenfoot.getRandomNumber(2)==0){
             speed*=-1;
         }
         if(rotation>0){
             turn(180);
         }
         this.rotation = rotation;
    }
    public void isTouching(){
        if (isAtEdge()){
            speed *= -1;
            setLocation(getX()+(40*rotation), getY());
        }
        if (isTouching(SingleProjectile.class)){
            ((SingleWorld)getWorld()).addScore(1);
            removeTouching(SingleProjectile.class);
            getWorld().removeObject(this);
        }
    }
    public void act()
    {
        setLocation(getX(), getY()-speed);
        isTouching();
    }
}
