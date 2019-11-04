import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Rocketship rocket;

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
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
    public void up() {
        y-=speed;
    }
    public void down() {
        y+=speed;
    }
    public void left() {
        x-=speed;
    }
    public void right() {
        x+=speed;
    }


	public projectile getProjectile() {
        return new projectile(rocket.x+(rocket.width/2), rocket.y, 10, 10);
	}	 
}
