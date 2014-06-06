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
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import EPIC.Main.STATE;


public class Menu extends JPanel{
	private JFrame mainFrame;
	private LinkedList<Button> buttons = new LinkedList<>();
	Image img1 = Toolkit.getDefaultToolkit().getImage("C:/Users/Shadow/workspace/GameEPIC/src/images/Banner.png");
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int sX = d.width;
    private int sY = d.height;
    private int p1X = sX;
    private int p1Y = sY;
    private boolean startClicked = false;
    public EPIC.Main.STATE state = STATE.onePLAYER;

	public Menu() {
		if(state == STATE.onePLAYER){
	        p1X = sX;
	        p1Y = sY;
	    }else if(state == STATE.twoPLAYER){
	        p1X = sX/2;
	        p1Y = sY;
	    }else if(state == STATE.threePLAYER){
	        p1X = sX/2;
	        p1Y = sY/2;
	    }else if(state == STATE.fourPLAYER){
	        p1X = sX/2;
	        p1Y = sY/2;
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
		initButtons();
		initCheck();
		// initPlayer();
		repaint();
	}
	public void initCheck(){
		if (startClicked == true){
			initMultiButtons();
			}
	}
	public void initButtons() {
		//Game g,int x,int y, int width, int height,String text,Color outlineColor,Color innerColor,Color textColor,int type
		buttons.add(new Button(sX-75,sY/10,75,20,"Start",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));//add buttons here
		}
	public void initMultiButtons(){
		buttons.add(new Button(sX-75,(sY/10)+20,75,20,"1 Player",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button(sX-75,(sY/10)+40,75,20,"2 Player",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button(sX-75,(sY/10)+60,75,20,"3 Player",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
		buttons.add(new Button(sX-75,(sY/10)+80,75,20,"4 Player",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));
	}
	public void paint(Graphics g) {
		//Draw your epic title screen stuff here
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    g.drawImage(img1, 0, 0, sX, 100, this);
		g.setFont(new Font("serif", Font.BOLD, 20));
		//Draw all buttons
		for(int i = 0;i<buttons.size();i++){
			buttons.get(i).draw((Graphics2D)g);
		}
		g.setColor(Color.CYAN);
		g.setFont(new Font("monospaced", Font.BOLD, 52));
		g.drawString("E.P.I.C", 0, sY/2);
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
				}if(!buttons.get(1).isInside(e.getX(), e.getY())&&buttons.get(1).hasMouseOver()){
					buttons.get(1).changeMouseOver(true);
					buttons.get(1).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(1).isInside(e.getX(), e.getY())&&buttons.get(1).hasMouseOver()){
					buttons.get(1).changeMouseOver(false);
					buttons.get(1).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(2).isInside(e.getX(), e.getY())&&buttons.get(2).hasMouseOver()){
					buttons.get(2).changeMouseOver(true);
					buttons.get(2).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(2).isInside(e.getX(), e.getY())&&buttons.get(2).hasMouseOver()){
					buttons.get(2).changeMouseOver(false);
					buttons.get(2).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(3).isInside(e.getX(), e.getY())&&buttons.get(3).hasMouseOver()){
					buttons.get(3).changeMouseOver(true);
					buttons.get(3).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(3).isInside(e.getX(), e.getY())&&buttons.get(3).hasMouseOver()){
					buttons.get(3).changeMouseOver(false);
					buttons.get(3).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(4).isInside(e.getX(), e.getY())&&buttons.get(4).hasMouseOver()){
					buttons.get(4).changeMouseOver(true);
					buttons.get(4).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}if(!buttons.get(4).isInside(e.getX(), e.getY())&&buttons.get(4).hasMouseOver()){
					buttons.get(4).changeMouseOver(false);
					buttons.get(4).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}
			} catch(NullPointerException ex){

			} catch(IndexOutOfBoundsException ex){

			}
		}

	}
	private class MouseClickHandler implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if(buttons.get(0).isInside(e.getX(), e.getY())){
				initMultiButtons();
				repaint();
			}if(buttons.get(1).isInside(e.getX(), e.getY())){
				mainFrame.setVisible(false);
				Main m = new Main();
				PlayerOne one = new PlayerOne();
			}if(buttons.get(2).isInside(e.getX(), e.getY())){
				Main.state = Main.STATE.twoPLAYER;
				mainFrame.setVisible(false);
				Main m = new Main();
				PlayerOne one = new PlayerOne();
				PlayerTwo two = new PlayerTwo();
				two.setLocation(sX/2,0);
			}if(buttons.get(3).isInside(e.getX(), e.getY())){
				Main.state = Main.STATE.threePLAYER;
				mainFrame.setVisible(false);
				Main m = new Main();
				PlayerOne one = new PlayerOne();
				PlayerTwo two = new PlayerTwo();
				two.setLocation(sX/2,0);
			}if(buttons.get(4).isInside(e.getX(), e.getY())){
				Main.state = Main.STATE.fourPLAYER;
				mainFrame.setVisible(false);
				Main m = new Main();
				PlayerOne one = new PlayerOne();
				PlayerTwo two = new PlayerTwo();
				two.setLocation(sX/2,0);
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

	 public static void main(String args[]) {
		 Menu t = new Menu();
	 }
}
