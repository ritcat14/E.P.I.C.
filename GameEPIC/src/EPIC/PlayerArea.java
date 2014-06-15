package EPIC;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
private Rectangle rect;
private int playerAreaX;
private int playerAreaY;
private int areaX;
private int areaY;
private Color colour;
private boolean isActive = true;
public Player(int x, int y, int width, int height, Color colour){
	rect = new Rectangle(x,y,width,height);
}public void draw(Graphics2D g,Color colour) {
	if(isActive){
		g.setColor(colour);
		g.drawRect(areaX, areaY, playerAreaX, playerAreaY);
		g.fillRect(areaX, areaY, playerAreaX, playerAreaY);
	}
}
public void draw(Graphics2D g) {
	if(isActive){	
	}
}
}
