import java.util.ArrayList;
import java.io.*;

// possible idea for factory who constructs the GameObjects
// in a selected level of the game.  This could be subclassed
// but might be best to have a text file that represents a 
// level and that text file can be read in and the objects in 
// the file
public class LevelReaderWriter {



	public static void writeLevel() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("res/levels/level_1"));
			for (int i = 0; i < 50; i++) {
				writer.write(String.valueOf((int)((Math.random() * 500))));
				if (i != 49) {
					writer.newLine();
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}
	
	
	public static ArrayList<GameObject> readLevel(int levels) throws IOException {

		ArrayList<GameObject> gameObjects = new ArrayList<>();

		//BufferedReader br = new BufferedReader(new FileReader(String.valueOf(file)));


		int x = 0, y = 0;


		try(BufferedReader br = new BufferedReader(new FileReader("res/levels/level_" + levels))) {
			String line = br.readLine();

			int count = 1, objectsIndex = 0;



			while (line != null) {
				if (count == 1) {
					x = Integer.parseInt(line);
					count++;
				} else if (count == 2) {
					y = Integer.parseInt(line);
					count = 1;
				}
				line = br.readLine();


				if (y != 0) {
					GameObject g = new GameObject(x, y, 60, 60, "log");
					gameObjects.add(objectsIndex, g);
					objectsIndex++;
					y = 0;
				}





			}



		}


		return gameObjects;





	}

}
