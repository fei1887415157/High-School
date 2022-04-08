import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageHandler {

	static BufferedImage getImage(String name){
		try {
			return ImageIO.read(ImageHandler.class.getResource(name));
		} catch(IOException e) {
			System.out.println("Could not find image \"" + name + "\"");
			System.exit(-1);
			return null;
		}
	}

}
