import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;




public class GamePanel extends JPanel implements ActionListener , KeyListener {
	//GamePanel g = new GamePanel();
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    int currentState = MENU;
    
    Font titleFont;
    Font captionFont;
    
    Rocketship rocket = new Rocketship(250, 700, 50, 50);
    objectManager objManager = new objectManager(rocket);
    
    Timer frameDraw;
    Timer alienSpawn;
    
    GamePanel(){
        titleFont = new Font("Arial", Font.PLAIN, 48);
        captionFont = new Font("Arial", Font.PLAIN, 28);    	
    	
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
    }
    
    
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	
	
	
	void startGame(){
	    alienSpawn = new Timer(2000 , objManager);
	    alienSpawn.start();
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
	 void updateGameState() {  
		 objManager.update();
	 }
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
	 void drawGameState(Graphics g) {

			if (gotImage) {
				g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
			} else {
				 g.setColor(Color.black);
				 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			}
		 
		 objManager.draw(g);
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("League Invaders", 80, 80);
		 
		 g.drawString("You Died", 20, LeagueInvaders.HEIGHT/2);
		 
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
		    	if(currentState == MENU) startGame();
		        currentState++;
		    }
		}   
		if(e.getKeyCode()==KeyEvent.VK_SPACE && currentState == GAME) {
			objectManager.addProjectile(rocket.getProjectile()); //Made thing static may need to remove that
			//objectManager.addProjectile(new projectile(10, 10, 100, 100));		
			System.out.println("Shoot");
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    rocket.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    rocket.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    rocket.left();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    rocket.right();
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
