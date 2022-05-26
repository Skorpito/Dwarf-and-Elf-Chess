package tryTwoMessedWithPaint;

import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameSetupAndPlayer extends JPanel{
    private final int GAME_WIDTH = 640;
	private final int GAME_HEIGHT = 640;
	private final int CARD_WIDTH = 80;
	private final int CARD_HEIGHT = 80;
	
	private ArrayList<Drawables> drawables= new ArrayList<Drawables>();
	private JLabel statusbar;
	
	
	//private JFrame testFrame =new JFrame("JFrame Color Example");
	
	public GameSetupAndPlayer(JLabel statusbar) {
	    this.setSize(GAME_WIDTH, GAME_HEIGHT);

        this.statusbar = statusbar;
        createCards();
    }

	//getters and Setters
	public int gameWidth() {
		return GAME_WIDTH;
	}
	public int gameHeight() {
		return GAME_HEIGHT;
	}
	public int cardWidth() {
		return CARD_WIDTH;
	}
	public int cardHeight() {
		return CARD_HEIGHT;
	}
	
	//This contains the things that need to be set up before the game starts
	private void createCards() {
		setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		addMouseListener(new CardListener());
		Drawables.setGame(this);
        newGame();
	}
	
	
	private void newGame() {
		
		//draw all the nessary things
		int space=0;
		for(int i =0; i<=GAME_WIDTH-CARD_WIDTH-space; i=i+CARD_WIDTH+space) {

			drawables.add(new Card(i));
		}
	}
	

	/**
	 * 
	 * okay this is a son of a female dog 
	 * 	This is what is executed whenever you want to paint something 
	 * Can not have multiple seperate methods for separate things
	 * Thus we go through the drawables arraylist and paint each one of those instead
	 * to modify what is painted modify that
	 */

	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);     
        
        Graphics2D g2d = (Graphics2D) g.create();
        for (Drawables drawable : drawables) {
            drawable.paint(g2d);
        }
        g2d.dispose();
        //drawables=new ArrayList<Drawables>();
	}


	//This handles the user interaction
	private class CardListener extends MouseAdapter{
		 public void mousePressed(MouseEvent e) {
			 int x = e.getX();
			 int y = e.getY();
			 
			 int whichRectangle =x/CARD_WIDTH;
			 drawables.add(new Marker(whichRectangle));
			 
			 //redraw the scene with all of the objs in drawable
			 repaint();
			 System.out.println("PRESSED");
		 }
	}
}
