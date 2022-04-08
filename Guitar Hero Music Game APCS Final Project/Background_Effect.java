import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Background_Effect {

	private ArrayList<BufferedImage> list = new ArrayList<>();


	void start() {
		for (int i = 1; i < 602; i++) {
			try {
				if (i < 10) {
					list.add(ImageIO.read(getClass().getResourceAsStream(
							"Background_Effects.png" + File.separator + "img000" + i + ".jpg")));
				} else if (i < 100) {
					list.add(ImageIO.read(getClass().getResourceAsStream(
							"Background_Effects.png" + File.separator + "img00" + i + ".jpg")));
				} else {
					list.add(ImageIO.read(getClass().getResourceAsStream(
							"Background_Effects.png" + File.separator + "img0" + i + ".jpg")));
				}
			} catch (Exception ignored) {
			}

		}
	}



	BufferedImage get(int i) {
		return list.get(i - 1);
	}

	public void clear() {
		list.clear();
	}

	public int size() {
		return list.size();
	}




}
