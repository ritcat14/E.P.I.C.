
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
    private int p1X = sX;
    private int p1Y = sY;
    public enum STATE{
        onePLAYER,
        twoPLAYER,
        threePLAYER,
        fourPLAYER
    };
    public static STATE state = STATE.onePLAYER;

	public Main() {
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
		repaint();
	}

	public void initButtons() {
		//Game g,int x,int y, int width, int height,String text,Color outlineColor,Color innerColor,Color textColor,int type
		buttons.add(new Button(sX-75,sY/10,75,20,"Menu",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.BLACK,1));//add buttons here
	}
	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setFont(new Font("serif", Font.BOLD, 20));
		g.setColor(Color.DARK_GRAY);
		g.drawRoundRect(sX-75, sY/11, 75, 100, 5, 5);
		g.fillRoundRect(sX-75, sY/11, 75, 100, 5, 5);
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
				 Menu g =new Menu();
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
	public STATE getState(){
		return state;
	}
}
