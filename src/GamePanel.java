import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;




public class GamePanel extends JPanel implements ActionListener , KeyListener {
	//GamePanel g = new GamePanel();

    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    int currentState = MENU;
    
    Font titleFont;
    Font captionFont;
    
    
    
    Timer frameDraw;
    
    GamePanel(){
        titleFont = new Font("Arial", Font.PLAIN, 48);
        captionFont = new Font("Arial", Font.PLAIN, 28);    	
    	
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    
    }
    

    
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}

	}
	
	 void updateMenuState() {  }
	 void updateGameState() {  }
	 void updateEndState()  {  }
	 
	 
	 
	 void drawMenuState(Graphics g) {  
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("League Invaders", 80, 80);
		 
		 g.drawString("Press ENTER to start", 20, LeagueInvaders.HEIGHT/2);
		 
		 g.setFont(captionFont);
		 g.drawString("Press SPACE for instructions", 60, LeagueInvaders.HEIGHT-80);
		 
		 
	 }
	 void drawGameState(Graphics g) {  }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("League Invaders", 80, 80);
		 
		 g.drawString("You Done Died", 20, LeagueInvaders.HEIGHT/2);
		 
		 g.setFont(captionFont);
		 g.drawString("Press SPACE for life", 60, LeagueInvaders.HEIGHT-80);
		 
		 
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("hello");
		repaint();
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
