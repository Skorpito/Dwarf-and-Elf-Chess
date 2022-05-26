package tryTwoMessedWithPaint;

import java.awt.Graphics2D;
//import java.awt.BasicStroke;
import java.awt.Rectangle;
import java.awt.Color;


/**
 * This class is the superclass to all of the things can be drawn
 * can probably be better done in an abstract class but idk
 * to draw something new just make sure it has the paint() method
 *
 */
public class Drawables {
	protected static GameSetupAndPlayer Game;
	
	public static void setGame(GameSetupAndPlayer newGame) {
		Game=newGame;
	}
	
	public void paint(Graphics2D g2d) {
		
	}
}

class Card extends Drawables{
	private int x;
//	private int y=0;
	
	public Card(int xLocation) {
		x=xLocation;
	}
	
	public void paint(Graphics2D g2d) {
		((Graphics2D) g2d).setStroke(new java.awt.BasicStroke(10));

		g2d.draw(new Rectangle(x,0,Game.getWidth(),Game.getHeight()));
				
	}
}

class Marker extends Drawables{
	private int cardLoc;
	
	public Marker(int locationOfCard) {
		cardLoc=locationOfCard;
	}
	
	
	public void paint(Graphics2D g2d) {
		//((Graphics2D) g2d).setStroke(new java.awt.BasicStroke(10));
	    g2d.setPaint(Color.red);
		g2d.fillRect((int)((cardLoc+0.5)*Game.cardWidth()-(50/2)),Game.cardHeight()/2,50,50);
		
				
	}
}