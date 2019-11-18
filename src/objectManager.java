import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager implements ActionListener {
	Rocketship rocket;
	static ArrayList<projectile> projectiles = new ArrayList<projectile>();
	ArrayList<alien> aliens = new ArrayList<alien>();
	int score = 0;
	
	objectManager(Rocketship rocket){
		this.rocket = rocket;
		//addAlien();
	}
	
	int getScore() {
		return score;
	}
	
	static void addProjectile(projectile p) {
		projectiles.add(p);
	}
	public projectile getProjectile() {
        return new projectile(rocket.x+(rocket.width/2), rocket.y, 10, 10);
	}	 
	void addAlien() {
		Random random = new Random();
		
		aliens.add(new alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}	
	
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {
				if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)){
					aliens.get(i).isActive = false;
					score++;
					System.err.println(aliens.size());
				}
			}

		}
		
		for (int i = 0; i < aliens.size(); i++) {
			if(rocket.collisionBox.intersects(aliens.get(i).collisionBox)){
				rocket.isActive = false;
				
				
				GamePanel.currentState = GamePanel.END;
				aliens.get(i).isActive = false;
				//System.err.println("EEEEEEEEEEEEEEEEEEEE");
				
				
			}

		}		
		
	}
	
	void update() {
		checkCollision();
		purgeObjects();

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}		
		
	}
	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isActive){
				projectiles.remove(i);
			}
		}	
		for (int i = 0; i < aliens.size(); i++) {
			if(!aliens.get(i).isActive){
				aliens.remove(i);
			}
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		addAlien();
	}
}
