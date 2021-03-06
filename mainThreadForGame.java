package tryTwoMessedWithPaint;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * Based off of Java Minesweeper Game
 *
 * Author: Jan Bodnar
 * Website: http://zetcode.com
 */

public class mainThreadForGame extends JFrame {

    private JLabel statusbar;

    public mainThreadForGame() {

        initUI();
    }

    private void initUI() {

    	//dont completely know what this does but its important I think sorta
        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);

        add(new GameSetupAndPlayer(statusbar));
		
        setResizable(false);
        pack();

        setTitle("Cards");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	
    	//ignore this it works
        EventQueue.invokeLater(() -> {

            var ex = new mainThreadForGame();
            ex.setVisible(true);
        });
        System.out.println("OK");
    }
}