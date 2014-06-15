
package EPIC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.lang.Thread.State;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
	private JFrame mainFrame;
	private LinkedList<Button> buttons = new LinkedList<>();
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int sX = d.width;
    private int sY = d.height;
    private int pX = sX;
    private int pY = sY; 
    public boolean onePlayer = false;
    public boolean twoPlayer = false;
    public boolean threePlayer = false;
    public boolean fourPlayer = false;
	private LinkedList<PlayerArea> players = new LinkedList<>();

	public Main() {
		if (twoPlayer == true){
			pX = sX/2;
		}else if (threePlayer = true){
			pX = sX/2;
			pY = pY/2;
		}else if (fourPlayer == true){
			pX = sX/2;
			pY = sY/2;
		}
		this.setSize(sX, sY);
		mainFrame=new JFrame("SpaceInvadersEPIC");
		mainFrame.setUndecorated(true);
		JPanel panel = (JPanel) mainFrame.getContentPane();
		panel.setPreferredSize(new Dimension(sX,sY));
		panel.setLayout(null);
		panel.add(this);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		this.addMouseListener(new MouseClickHandler());
		this.addMouseMotionListener(new MouseMoveHandler());
		repaint();
	}
	public void initOnePlayerArea() {
		players.add(new PlayerArea(0, 0, sX, sY));
		buttons.add(new Button(sX-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
	}
	public void initTwoPlayerArea() {
		players.add(new PlayerArea(0, 0, pX, sY));
		players.add(new PlayerArea(sX/2, 0, pX, sY));
		buttons.add(new Button(sX-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button((sX/2)-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
	}
	public void initThreePlayerArea(){
		players.add(new PlayerArea(0, 0, pX, pY));
		players.add(new PlayerArea(sX/2, 0, pX, pY));
		players.add(new PlayerArea(sX/2, sY/2, pX, pY));
		buttons.add(new Button(sX-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button((sX/2)-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button(sX-75,(sY/2)+20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
	}
	public void initFourPlayerArea(){
		players.add(new PlayerArea(0, 0, pX, pY));
		players.add(new PlayerArea(sX/2, 0, pX, pY));
		players.add(new PlayerArea(0, sY/2, pX, pY));
		players.add(new PlayerArea(sX/2, sY/2, pX, pY));
		buttons.add(new Button(sX-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button((sX/2)-75,20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button(sX-75,(sY/2)+20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button((sX/2)-75,(sY/2)+20,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
	}
	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0;i<players.size();i++){
			players.get(i).draw((Graphics2D)g);
		}
		g.setColor(Color.CYAN);
		if (onePlayer == true){
			g.fillRect(sX-75,20,75, 80);
		}else if (twoPlayer == true){
			g.fillRect(sX-75,20,75, 80);
			g.fillRect((sX/2)-75,20,75, 80);
		}else if (threePlayer == true){
			g.fillRect(sX-75,20,75, 80);
			g.fillRect((sX/2)-75,20,75, 80);
			g.fillRect(sX-75,(sY/2)+20,75, 80);
		}else if (fourPlayer == true){
			g.fillRect(sX-75,20,75, 80);
			g.fillRect((sX/2)-75,20,75, 80);
			g.fillRect(sX-75,(sY/2)+20,75, 80);
			g.fillRect(75, (sY/2)+20, 75, 80);
		}
		g.setFont(new Font("serif", Font.BOLD, 20));
		//Draw all buttons
		for(int i = 0;i<buttons.size();i++){
			buttons.get(i).draw((Graphics2D)g);
		}
	}
	private class MouseMoveHandler implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			try{
				if(buttons.get(0).isInside(e.getX(), e.getY())&&!buttons.get(0).hasMouseOver()){
					buttons.get(0).changeMouseOver(true);
					buttons.get(0).changeColors(Color.DARK_GRAY, Color.BLUE, Color.LIGHT_GRAY);
				}if(!buttons.get(0).isInside(e.getX(), e.getY())&&buttons.get(0).hasMouseOver()){
					buttons.get(0).changeMouseOver(false);
					buttons.get(0).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(buttons.get(1).isInside(e.getX(), e.getY())&&!buttons.get(0).hasMouseOver()){
					buttons.get(1).changeMouseOver(true);
					buttons.get(1).changeColors(Color.DARK_GRAY, Color.BLUE, Color.LIGHT_GRAY);
				}if(!buttons.get(1).isInside(e.getX(), e.getY())&&buttons.get(0).hasMouseOver()){
					buttons.get(1).changeMouseOver(false);
					buttons.get(1).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(buttons.get(2).isInside(e.getX(), e.getY())&&!buttons.get(0).hasMouseOver()){
					buttons.get(2).changeMouseOver(true);
					buttons.get(2).changeColors(Color.DARK_GRAY, Color.BLUE, Color.LIGHT_GRAY);
				}if(!buttons.get(2).isInside(e.getX(), e.getY())&&buttons.get(0).hasMouseOver()){
					buttons.get(2).changeMouseOver(false);
					buttons.get(2).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(buttons.get(3).isInside(e.getX(), e.getY())&&!buttons.get(0).hasMouseOver()){
					buttons.get(3).changeMouseOver(true);
					buttons.get(3).changeColors(Color.DARK_GRAY, Color.BLUE, Color.LIGHT_GRAY);
				}if(!buttons.get(3).isInside(e.getX(), e.getY())&&buttons.get(0).hasMouseOver()){
					buttons.get(3).changeMouseOver(false);
					buttons.get(3).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}
			} catch(NullPointerException ex){

			} catch(IndexOutOfBoundsException ex){

			}
		}

	}
	private class MouseClickHandler implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if(buttons.get(0).isInside(e.getX(), e.getY())){
				 Menu m =new Menu();
				 mainFrame.setVisible(false);
			}if(buttons.get(1).isInside(e.getX(), e.getY())){
				 Menu m =new Menu();
				 mainFrame.setVisible(false);
			}if(buttons.get(2).isInside(e.getX(), e.getY())){
				 Menu m =new Menu();
				 mainFrame.setVisible(false);
			}if(buttons.get(3).isInside(e.getX(), e.getY())){
				 Menu m =new Menu();
				 mainFrame.setVisible(false);
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mousePressed(MouseEvent arg0) {

		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	public void notifyDeath() {
	}
}
