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
    private int dodgeTime;
    private int rpCounter;
    private int spCounter;
    private int halfWidth;
    private int halfHeight;
    private int health;
    private boolean onScreen;
    public Player1(int rotation){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        turn(rotation);
        dodgeTime = 0;
        reloadTime = 0;
        rpCounter = 0;
        spCounter = 0;
        health = 100;
        halfWidth = image.getWidth() / 2;
        halfHeight = image.getHeight() / 2;
        onScreen = true;
    }
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        isKeyDown();
        reloadTime--;
        dodgeTime--;
        changeEdge();
        checkPower();
        powerdown();
        checkCollision();
        if(onScreen){
            checkHealth();
        }
    }
    private void isKeyDown(){
        if(Greenfoot.isKeyDown("w")){
            if(spCounter > 0){
                move(5);
            } else {
                move(2);
            }
        }
        if(Greenfoot.isKeyDown("a")){
            turn(-5);
        }
        if(Greenfoot.isKeyDown("s")){
            if(spCounter > 0){
                move(-5);
            } else {
                move(-2);
            }
        }
        if(Greenfoot.isKeyDown("d")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("x") && reloadTime <= 0){
            getWorld().addObject(new P1Proj(getRotation()), getX(), getY());
            if(rpCounter > 0){
                reloadTime = 10;
            } else {
                reloadTime = 20;
            }
        }
        if(Greenfoot.isKeyDown("z") && dodgeTime <= 0){
            move(100);
            dodgeTime = 40;
        }
        if(Greenfoot.isKeyDown("c") && dodgeTime <= 0){
            move(-100);
            dodgeTime = 40;
        }
    }
    private void checkCollision(){
        if(isTouching(P2Proj.class)){
            health -= 10;
            removeTouching(P2Proj.class);
        }
        if(onScreen && isTouching(Player2.class)){
            removeTouching(Player2.class);
            getWorld().addObject(new Explosion(true), getX(), getY());
            onScreen = false;
            getWorld().removeObject(this);
        }
    }
    private void changeEdge(){
        if(getX() < halfWidth){
            setLocation(580 - halfWidth, getY());
        } else 
        if(getX() > 600 - halfWidth){
            setLocation(halfWidth + 20, getY());
        } else
        if(getY() < halfHeight){
            setLocation(getX(), 380 - halfHeight);
        } else
        if(getY() > 400 - halfHeight){
            setLocation(getX(), halfHeight + 20);
        }
    }
    private void checkPower(){
        if(isTouching(RatePower.class)){
            removeTouching(RatePower.class);
            rpCounter = 200;
        }
        if(isTouching(SpeedPower.class)){
            removeTouching(SpeedPower.class);
            spCounter = 200;
        }
        if(isTouching(HealthPower.class)){
            removeTouching(HealthPower.class);
            health += 40;
            if(health > 200){
                health = 200;
            }
        }
    }
    private void powerdown(){
        if(rpCounter > 0){
            rpCounter--;
        }
        if(spCounter > 0){
            spCounter--;
        }
    }
    private void checkHealth(){
        showHealth();
        if(health <= 0){
            ((SpaceArena)getWorld()).changeP2Score();
            getWorld().addObject(new Explosion(false), getX(), getY());
            onScreen = false;
            getWorld().removeObject(this);
        }
    }
    private void showHealth(){
        getWorld().showText("Health: " + health, 50, 40);
    }
}
