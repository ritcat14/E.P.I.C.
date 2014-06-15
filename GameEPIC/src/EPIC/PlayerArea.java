package EPIC;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PlayerArea {
	private Rectangle rect;
	private Color colour;
	private boolean isActive = true;
	private boolean mouseOver = false;
	
	
	public PlayerArea(int x,int y, int width, int height){
		rect = new Rectangle(x,y,width,height);
	}
	
	
	
	public boolean isInside(int x, int y){
		if(x>rect.x&&y>rect.y&&x<(rect.x+rect.width)&&y<(rect.y+rect.height)){
			return true;
		}
		return false;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	public Color getBackground() {
		return colour;
	}
	
	public void changeActive(boolean newS){
		isActive=newS;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void changeMouseOver(boolean newS){
		mouseOver=newS;
	}
	
	public boolean hasMouseOver(){
		return mouseOver;
	}
	
	/*public void draw(Graphics2D g,Color outlineColor,Color innerColor,Color textColor) {
		if(isActive){
			g.setColor(Color.DARK_GRAY);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}*/
	
	public void draw(Graphics2D g) {
		if(isActive){
			g.setColor(Color.DARK_GRAY);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
			g.setColor(Color.BLACK);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
			
	}
	
}
