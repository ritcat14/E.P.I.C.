package EPIC;
import java.awt.Color;
import java.util.Random;

/**
 * An entity which represents one of our space invader aliens.
 * 
* @author Kevin Glass
 */
public abstract class EnemyEntity extends Entity {
        public int maxHealth = 100;
    /** The speed at which the alien moves horizontally */
    protected final double moveSpeed = 75;
    /** The game in which the entity exists */
    protected final Main main;
    
    protected boolean alreadyKilled = false;
    
    protected double armour=100;

    protected int rowNum;

    protected int colNum;
    
    protected int XPBonus = 10;
    
    protected boolean isFiring = false;
    protected boolean isShield = false;
    protected boolean isRegen = false;
    protected int nextShot;
    protected int fireSpeed = 300;
	private int maxTimeToShield = 500;
    private int timeToShield = maxTimeToShield;
    public final int healthGain = 1;
    public final int healthTime = 5;
    private int healthCount = 0;
    /**
     * Create a new alien entity
     * 
     * @param game The game in which this entity is being created
     * @param ref The sprite which should be displayed for this alien
     * @param x The initial x location of this alien
     * @param y The initial y location of this alien
     */
    public EnemyEntity(Main main,String ref,int x,int y, int row, int col) {
        super(ref,x,y);
        rowNum = row;
        colNum = col;
        this.main = main;
    }
    
    public void init(){
        nextShot = (int) Math.floor(Math.random()*fireSpeed);
        dx = -moveSpeed;
    }
        
    @Override
    public void collidedWith(Entity other) {
        // collisions with aliens are handled elsewhere
    }
}