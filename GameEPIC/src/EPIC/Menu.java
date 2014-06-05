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


public class Menu extends JPanel{
	private JFrame mainFrame;
	private LinkedList<Button> buttons = new LinkedList<>();
	Image img1 = Toolkit.getDefaultToolkit().getImage("C:/Users/Shadow/workspace/GameEPIC/src/images/Banner.png");
	Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int sX = d.width;
    private int sY = d.height;

	public Menu() {
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
		repaint();
	}

	public void initButtons() {
		//Game g,int x,int y, int width, int height,String text,Color outlineColor,Color innerColor,Color textColor,int type
		buttons.add(new Button(sX-75,sY/10,75,20,"Start",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));//add buttons here
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
				}
				if(!buttons.get(0).isInside(e.getX(), e.getY())&&buttons.get(0).hasMouseOver()){
					buttons.get(0).changeMouseOver(false);
					buttons.get(0).changeColors(Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK);
				}
			} catch(NullPointerException ex){

			} catch(IndexOutOfBoundsException ex){
				
			}
		}

	}
	private class MouseClickHandler implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if(buttons.get(0).isInside(e.getX(), e.getY())){
				 Main g =new Main();
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
	
	 public static void main(String args[]) {
		 Menu t = new Menu();
	 }
}
