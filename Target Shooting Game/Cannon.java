import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cannon {

	private BufferedImage cannon;

	public void start() {

		try {
			cannon = ImageIO.read(new File("res/Cannon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getCannonImage() {
		return cannon;
	}
}
