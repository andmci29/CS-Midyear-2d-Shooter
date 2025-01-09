import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int p1Score;
    private int p2Score;
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
        p1Score = 0;
        p2Score = 0;
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
    public void changeP1Score(){
        p1Score++;
    }
    public void changeP2Score(){
        p2Score++;
    }
    private void scoreboard(){
        showText("Score: " + p1Score, 50, 20);
        showText("Score: " + p2Score, 550, 20);
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
        scoreboard();
        counter++;
        spawnPowers();
    }
}
