import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingleWorld extends World
{
    private int score = 0;
    private int reloadTimer;
    private int spawnRate;
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public SingleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 400, 1);
        prepare();
        spawnRate = 3;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
       SinglePlayer shooter = new SinglePlayer();
        addObject(shooter,getWidth()/2,getHeight()/2);
    }
    public int getTimer(){
        return reloadTimer;
    }
    public int getRate(){
        return spawnRate;
    }
    public void setTimer(int timer){
        reloadTimer = timer;
    }
    private void timers(){
        if(reloadTimer > 0){
            showText("Reloading", getWidth()/2, getHeight()-50);
            reloadTimer--;
        }else{
            showText("", getWidth()/2, getHeight()-50);
        }
    }
    public void addScore(int x){
        score+=x;
    }
    public int getScore(){
        return score;
    }
    private void spawnIncrease(){
        if(score>10){
            spawnRate = 6;
        }
        if(score>25){
            spawnRate = 8;
        }
        if(score>40){
            spawnRate = 10;
        }
        if(score>50){
            spawnRate = 12;
        }
        if(score>75){
            spawnRate = 15;
        }
    }
   
    public void act(){
        if(Greenfoot.getRandomNumber(400)<spawnRate){
            if(Greenfoot.getRandomNumber(2)==0){
                addObject(new SingleEnemy(1), 30, Greenfoot.getRandomNumber(getHeight()));
            }else{
                addObject(new SingleEnemy(-1), getWidth()-30, Greenfoot.getRandomNumber(getHeight()));
            }
        }
        spawnIncrease();
        showText("Score: "+score, 325, 20);
        timers();
    }
}
