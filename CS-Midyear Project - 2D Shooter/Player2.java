import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    private int reloadTime;
    private int rpCounter;
    private int spCounter;
    private int dodgeTime;
    private int halfWidth;
    private int halfHeight;
    private int health;
    private boolean onScreen;
    public Player2(int rotation){
        GreenfootImage image = getImage();
        reloadTime = 0;
        rpCounter = 0;
        spCounter = 0;
        dodgeTime = 0;
        health = 100;
        onScreen = true;
        halfWidth = image.getWidth() / 2;
        halfHeight = image.getHeight() / 2;
        turn(rotation);
    }
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
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
    public void isKeyDown(){
        if(Greenfoot.isKeyDown("i")){
            if(spCounter > 0){
                move(-5);
            } else {
                move(-2);
            }
        }
        if(Greenfoot.isKeyDown("j")){
            turn(-5);
        }
        if(Greenfoot.isKeyDown("k")){
            if(spCounter > 0){
                move(5);
            } else {
                move(2);
            }
        }
        if(Greenfoot.isKeyDown("l")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("space") && reloadTime <= 0){
            getWorld().addObject(new P2Proj(getRotation()), getX(), getY());
            if(rpCounter > 0){
                reloadTime = 10;
            } else {
                reloadTime = 20;
            }
        }
        if(Greenfoot.isKeyDown("m") && dodgeTime <= 0){
            move(100);
            dodgeTime = 40;
        }
        if(Greenfoot.isKeyDown("n") && dodgeTime <= 0){
            move(-100);
            dodgeTime = 40;
        }
    }
    public void checkCollision(){
        if(isTouching(P1Proj.class)){
            removeTouching(P1Proj.class);
            health -= 10;
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
    }
    private void powerdown(){
        if(rpCounter > 0){
            rpCounter--;
        }
        if(spCounter > 0){
            spCounter--;
        }
        if(isTouching(HealthPower.class)){
            removeTouching(HealthPower.class);
            health += 40;
            if(health > 200){
                health = 200;
            }
        }
    }
    private void checkHealth(){
        showHealth();
        if(health <= 0){
            ((SpaceArena)getWorld()).changeP1Score();
            getWorld().addObject(new Explosion(false), getX(), getY());
            onScreen = false;
            getWorld().removeObject(this);
        }
    }
    private void showHealth(){
        getWorld().showText("Health: " + health, 550, 40);
    }
}
