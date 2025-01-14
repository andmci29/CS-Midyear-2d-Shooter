import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int p1Health;
    private int p2Health;
    private int counter;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        p1Health = 100;
        p2Health = 100;
        counter++;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player1 player1 = new Player1();
        addObject(player1,150,200);
        Player2 player2 = new Player2();
        addObject(player2,450,200);
        Player1 player12 = new Player1();
        addObject(player12,168,135);
        player12.setLocation(298,289);
        removeObject(player12);
    }
    public void changeP1Health(int p1HealthChange){
        p1Health += p1HealthChange;
    }
    public void changeP2Score(int p2HealthChange){
        p2Health += p2HealthChange;
    }
    private void scoreboard(){
        showText("Health: " + p2Health, 50, 20);
        showText("Health: " + p1Health, 550, 20);
    }
    private void spawnPowers(){
        if(counter % 250 == 0){
            addObject(new RatePower(), Greenfoot.getRandomNumber(600),
            Greenfoot.getRandomNumber(400));
        }
        if(counter % 400 == 0){
            addObject(new SpeedPower(), Greenfoot.getRandomNumber(600),
            Greenfoot.getRandomNumber(400));
        }
    }
    public void act(){
        if(p2Health <= 0){
            Greenfoot.stop();
            p2Health = 0;
        }
        if(p1Health <= 0){
            Greenfoot.stop();
            p1Health =0;
        }
        scoreboard();
        counter++;
        spawnPowers();
    }
}
