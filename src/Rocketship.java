import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Rocketship rocket;
	int Rspeed = 10;
	Rocketship(int x, int y, int width, int height){
		super(x,y,width,height);	
		if (needImage) {
		    loadImage ("rocket.png");
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
	void update() {
		super.update();
	}
	void draw(Graphics g) {
		update();
		//System.err.println(x);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
    public void up() {
        y-=speed*Rspeed;
    }
    public void down() {
        y+=speed*Rspeed;
    }
    public void left() {
        x-=speed*Rspeed;
    }
    public void right() {
        x+=speed*Rspeed;
    }


	public projectile getProjectile() {
		int ProjectileSize = 20;
		//System.out.println("s "+new projectile(rocket.x+(rocket.width/2), rocket.y, 100, 100));
        return new projectile((x+(width/2))-ProjectileSize/2, y, ProjectileSize, ProjectileSize);
	}	 
}
