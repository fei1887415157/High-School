import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

class Menu_Effect {



	private ArrayList<BufferedImage> list = new ArrayList<>();



	void start() {
		for (int i = 1; i < 152; i++) {
			try {
				if (i < 10) {
					list.add(ImageIO.read(getClass().getResourceAsStream(
							"Menu_Effect" + File.separator + "img000" + i + ".png")));
				} else if (i < 100) {
					list.add(ImageIO.read(getClass().getResourceAsStream(
							"Menu_Effect" + File.separator + "img00" + i + ".png")));
				} else {
					list.add(ImageIO.read(getClass().getResourceAsStream(
							"Menu_Effect" + File.separator + "img0" + i + ".png")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	public BufferedImage get(int i) {
		return list.get(i - 1);
	}


	public void clear() {
		list.clear();
	}

	public int size() {
		return list.size();
	}




}
