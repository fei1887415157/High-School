
import javax.swing.*;
import java.awt.Graphics;
import java.io.IOException;
import java.util.*;

public class FroggerGame {


	private final int FROGMOVEMENTSPEED = 10;
	
	// what are the things you see in the game?
	List<GameObject> gos = new ArrayList<>();
	
	// list of autos should come from loadLevel
	List<GameObject> autos = new ArrayList<>();
	
	// list of logs
	List<GameObject> logs = new ArrayList<>();
	
	
	
	Frog frog;
	int level = 1;
	public FroggerGame() throws IOException {
		
		frog = new Frog(100, 0, 50, 50,  null);


		
		loadLevel();
	}
	
	
	
	private void loadLevel() throws IOException {
		// this is just an idea.  Maybe store the different levels as text files
		LevelReaderWriter.writeLevel();
		ArrayList levelObjects = LevelReaderWriter.readLevel(level);
		gos.clear();
		/*if(levelObjects != null) {
			for(List<GameObject> list: levelObjects) {
				if(list != null) {
					for(GameObject go: list) {
						if(go instanceof Log)
							logs.add(go);
						if(go instanceof Auto)
							autos.add(go);
						gos.add(go);
					}
				}
			}
		}*/
//		gos.add(frog);
		for (int i = 0; i < levelObjects.size(); i++) {
			gos.add((GameObject) levelObjects.get(i));
		}



	}






	void keyHit(String s) {
		switch (s) {
			case "left":
				frog.getRect().translate(- FROGMOVEMENTSPEED, 0);
				break;
			case "right":
				frog.getRect().translate(FROGMOVEMENTSPEED, 0);
				break;
			case "up":
				frog.getRect().translate(0, - FROGMOVEMENTSPEED * 5);
				break;
			case "down":
				frog.getRect().translate(0, FROGMOVEMENTSPEED * 5);
				break;
		}


	}





	public void draw(Graphics g) {
		for(GameObject go:gos) {
			go.draw(g);
		}

		frog.draw(g);
	}

	
	
	
	
	
	
	
	
}
