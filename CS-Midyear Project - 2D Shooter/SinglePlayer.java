import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SinglePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SinglePlayer extends Actor
{
    private int rotation;
    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SinglePlayer(){
        setRotation(-180);
        rotation = -180;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
    }
    public void checkButton(){
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-4);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY()+4);
        }
        if(Greenfoot.isKeyDown("d")){
            setRotation(360);
            rotation = -1;
        }
        if(Greenfoot.isKeyDown("a")){
            setRotation(-180);
            rotation = 1;
        }
        if(Greenfoot.isKeyDown("space") && ((SingleWorld)getWorld()).getTimer() == 0){
            getWorld().addObject(new SingleProjectile(rotation), getX()-(30*rotation), getY());
            ((SingleWorld)getWorld()).setTimer(50);
        }
    }
    public void act()
    {
        checkButton();
        if (isTouching(SingleEnemy.class)){
            removeTouching(SingleEnemy.class);
            getWorld().showText("", 325, 20);
            getWorld().showText("Game Over! \nFinal Score: "+((SingleWorld)getWorld()).getScore(), 325, 200);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
}
