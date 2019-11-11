import java.awt.Color;
import java.awt.Rectangle;

public class GameObject {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed;
	 Boolean isActive;
	 Rectangle collisionBox;

	GameObject(int x, int y, int width, int height) {
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 
		 collisionBox = new Rectangle(x, y, width, height);
		 
		 isActive = true;
		 speed = 1;
	}
	void update() {
		collisionBox.setBounds(x, y, width, height);
		
		
	}
}
