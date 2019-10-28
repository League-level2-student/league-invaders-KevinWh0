import javax.swing.JFrame;
import javax.swing.JPanel;

//https://central.jointheleague.org/levels/Level2/Mod2Recipes/InvadersOverview.html
public class LeagueInvaders {
	static JFrame frame = new JFrame();
	public static final  int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	
	static GamePanel panel = new GamePanel();
	


	
	
	
	static void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(panel);
	}
	
	public static void main(String[] args) {
		setup();
		
		
	}
}
