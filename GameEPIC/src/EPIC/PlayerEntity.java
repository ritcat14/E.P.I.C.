package EPIC;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * The entity that represents the players ship
 * 
* @author Kevin Glass
 */
public class PlayerEntity extends Entity {
    /** The game in which the ship exists */
    private final Main main;
    private static final int invTime = 1000;
    protected double armour = 100;
    
    protected int maxHealth = 100;
    
    private int invincibility;
    
    private int upgradeStatus = 0;
    
    /**
     * Create a new entity to represent the players ship
     *  
     * @param game The game in which the ship is being created
     * @param ref The reference to the sprite to show for the ship
     * @param x The initial x location of the player's ship
     * @param y The initial y location of the player's ship
     */
    public PlayerEntity(Main main,String ref,int x,int y) {
        super(ref,x,y);
        
        this.main = main;
    }
    
    /**
     * Request that the ship move itself based on an elapsed ammount of
     * time
     * 
     * @param delta The time that has elapsed since last move (ms)
     */
    @Override
    public void move(long delta) {
        // if we're moving left and have reached the left hand side
        // of the screen, don't move
        if ((dx < 0) && (x+(sprite.getWidth()/2) < 20)) {
            return;
        }
        // if we're moving right and have reached the right hand side
        // of the screen, don't move
        if ((dx > 0) && (x+(sprite.getWidth()/2) > 780)) {
           return;

        }
        invincibility-=delta;
        super.move(delta);
    }
    
    public void resetShip() {
    	armour = maxHealth;
    }

    public void draw(Graphics g) {
    	if(Math.round((((double)invincibility)/50))%2==0){
    		sprite.draw(g,(int) x,(int) y);
    	}else if(invincibility<0){
    		sprite.draw(g,(int) x,(int) y);
    	}
    }

    @Override
    public void collidedWith(Entity other) {

        // if its an alien, notify the game that the player
        // is dead
        if (other instanceof EnemyEntity) {
            main.notifyDeath();
        }
    }
}