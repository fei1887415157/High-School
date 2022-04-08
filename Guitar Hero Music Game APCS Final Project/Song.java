import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.ArrayList;


public class Song {


	private ArrayList<Double> listGreen = new ArrayList<>();
	private ArrayList<Double> listRed = new ArrayList<>();
	private ArrayList<Double> listYellow = new ArrayList<>();
	private ArrayList<Double> listBlue = new ArrayList<>();
	private ArrayList<Double> listOrange = new ArrayList<>();


	private AudioInputStream audioInputStream;
	private Clip clip;

	private double time = 0;

	private final double D = 6.5;

	private boolean played = false;



	void start() {

		play();
		fillList();

	}





	private void play() {
		try {
			URL url = getClass().getResource("Cover.wav");
			audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.setFramePosition(0);
			clip.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	void replay() {
		if (clip != null) {
			clip.stop();
			time = 0;
			clip.setMicrosecondPosition(0);
			clip.start();
		}
	}

	public void stopPlay() {
		clip.stop();
	}

	void startPlaying() {
		played = true;
		time = 20;
		try {
			URL url = getClass().getResource("PlasticLove.wav");
			clip.stop();
			audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.setMicrosecondPosition(20 * 1000000);  //six zeros
			clip.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public double getClipLength() {
		if (clip != null)
			return clip.getMicrosecondLength() * 1000000;
		return 0;
	}

	public boolean isPlayed() {
		return played;
	}

	double getClipPosition() {
		return time;
	}

	void increaseTime() {
		time += 0.02;
	}

	private void fillList() {
		fillListGreen();
		fillListRed();
		fillListYellow();
		fillListBlue();
		fillListOrange();
	}


	private void fillListGreen() {
		String green = "36.44\n" +
				"36.94\n" +
				"37.44\n" +
				"44.44\n" +
				"44.94\n" +
				"45.44\n" +
				"47.19\n" +
				"48.69\n" +
				"52.69\n" +
				"55.19\n" +
				"56.69\n" +
				"58.69\n" +
				"62.19\n" +
				"62.32\n" +
				"62.44\n" +
				"68.44\n" +
				"68.94\n" +
				"69.44\n" +
				"76.44\n" +
				"76.94\n" +
				"77.44\n" +
				"79.19\n" +
				"80.69\n" +
				"84.69\n" +
				"87.19\n" +
				"88.69\n" +
				"90.69\n" +
				"94.19\n" +
				"97.94\n" +
				"98.94\n" +
				"101.94\n" +
				"102.94\n" +
				"105.94\n" +
				"106.94\n" +
				"108.19\n" +
				"110.19\n" +
				"113.94\n" +
				"114.94\n" +
				"117.94\n" +
				"118.94\n" +
				"121.69\n" +
				"124.19\n" +
				"124.32\n" +
				"124.44\n" +
				"133.69\n" +
				"137.32\n" +
				"137.57\n" +
				"140.19\n" +
				"146.44\n" +
				"146.94\n" +
				"147.44\n" +
				"154.44\n" +
				"154.94\n" +
				"155.44\n" +
				"157.19\n" +
				"158.69\n" +
				"162.69\n" +
				"165.19\n" +
				"166.69\n" +
				"168.69\n" +
				"172.19\n" +
				"175.94\n" +
				"176.94\n" +
				"179.94\n" +
				"180.94\n" +
				"183.94\n" +
				"184.94\n" +
				"186.19\n" +
				"188.19\n" +
				"191.94\n" +
				"192.94\n" +
				"195.94\n" +
				"196.94\n" +
				"199.69\n" +
				"202.19\n" +
				"202.32\n" +
				"202.44\n" +
				"210.07\n" +
				"218.07\n" +
				"226.07\n" +
				"234.07\n" +
				"242.07\n" +
				"250.07\n" +
				"258.07";

		int start = 0, end = 1, index = 0;
		for (int i = 0; i < green.length(); i++) {
			double num;
			if (green.substring(start, end).equals("\n")) {
				num = Double.parseDouble(green.substring(index, end));
				index += end - index;
				listGreen.add(num - D);
			}
			start++;
			end++;
		}
	}
	private void fillListRed() {
		String red = "32.44\n" +
		"32.94\n" +
		"33.44\n" +
		"36.69\n" +
		"37.19\n" +
		"40.44\n" +
		"40.94\n" +
		"41.44\n" +
		"41.94\n" +
		"44.69\n" +
		"45.19\n" +
		"47.44\n" +
		"51.69\n" +
		"53.19\n" +
		"55.44\n" +
		"58.94\n" +
		"60.44\n" +
		"64.44\n" +
		"64.94\n" +
		"65.44\n" +
		"68.69\n" +
		"69.19\n" +
		"72.44\n" +
		"72.94\n" +
		"73.44\n" +
		"73.94\n" +
		"76.69\n" +
		"77.19\n" +
		"79.44\n" +
		"83.69\n" +
		"85.19\n" +
		"87.44\n" +
		"90.94\n" +
		"92.44\n" +
		"94.19\n" +
		"94.69\n" +
		"97.69\n" +
		"98.19\n" +
		"99.19\n" +
		"101.69\n" +
		"102.19\n" +
		"103.19\n" +
		"108.44\n" +
		"110.44\n" +
		"113.69\n" +
		"114.19\n" +
		"115.19\n" +
		"117.69\n" +
		"118.19\n" +
		"119.19\n" +
		"121.44\n" +
		"122.57\n" +
		"125.69\n" +
		"127.94\n" +
		"129.94\n" +
		"130.44\n" +
		"131.94\n" +
		"133.94\n" +
		"136.94\n" +
		"137.19\n" +
		"137.44\n" +
		"140.19\n" +
		"140.69\n" +
		"142.44\n" +
		"142.94\n" +
		"143.44\n" +
		"143.94\n" +
		"146.69\n" +
		"147.19\n" +
		"150.44\n" +
		"150.94\n" +
		"151.44\n" +
		"151.94\n" +
		"154.69\n" +
		"155.19\n" +
		"157.44\n" +
		"161.69\n" +
		"163.19\n" +
		"165.44\n" +
		"168.94\n" +
		"170.44\n" +
		"172.19\n" +
		"172.69\n" +
		"175.69\n" +
		"176.19\n" +
		"177.19\n" +
		"179.69\n" +
		"180.19\n" +
		"181.19\n" +
		"186.44\n" +
		"188.44\n" +
		"191.69\n" +
		"192.19\n" +
		"193.19\n" +
		"195.69\n" +
		"196.19\n" +
		"197.19\n" +
		"199.44\n" +
		"200.57\n" +
		"209.94\n" +
		"210.19\n" +
		"217.94\n" +
		"218.19\n" +
		"225.94\n" +
		"226.19\n" +
		"233.94\n" +
		"234.19\n" +
		"241.94\n" +
		"242.19\n" +
		"249.94\n" +
		"250.19\n" +
		"257.94\n" +
		"258.19\n";

		int start = 0, end = 1, index = 0;
		for (int i = 0; i < red.length(); i++) {
			double num;
			if (red.substring(start, end).equals("\n")) {
				num = Double.parseDouble(red.substring(index, end));
				index += end - index;
				listRed.add(num - D);
			}
			start++;
			end++;
		}
	}
	private void fillListYellow() {
		String yellow = "32.69\n" +
		"33.19\n" +
		"33.69\n" +
		"33.94\n" +
		"38.44\n" +
		"40.69\n" +
		"41.19\n" +
		"41.69\n" +
		"42.19\n" +
		"46.44\n" +
		"47.69\n" +
		"48.94\n" +
		"51.19\n" +
		"52.19\n" +
		"53.94\n" +
		"55.69\n" +
		"56.94\n" +
		"62.19\n" +
		"62.32\n" +
		"62.44\n" +
		"64.69\n" +
		"65.19\n" +
		"65.69\n" +
		"65.94\n" +
		"70.44\n" +
		"72.69\n" +
		"73.19\n" +
		"73.69\n" +
		"74.19\n" +
		"78.44\n" +
		"79.69\n" +
		"80.94\n" +
		"83.19\n" +
		"84.19\n" +
		"85.96\n" +
		"87.49\n" +
		"88.96\n" +
		"94.69\n" +
		"95.19\n" +
		"97.19\n" +
		"98.57\n" +
		"99.57\n" +
		"101.19\n" +
		"102.57\n" +
		"103.57\n" +
		"105.19\n" +
		"105.69\n" +
		"106.19\n" +
		"107.15\n" +
		"108.69\n" +
		"109.94\n" +
		"110.69\n" +
		"113.19\n" +
		"114.57\n" +
		"115.57\n" +
		"117.19\n" +
		"118.57\n" +
		"119.57\n" +
		"121.19\n" +
		"121.96\n" +
		"122.19\n" +
		"124.19\n" +
		"124.32\n" +
		"124.44\n" +
		"125.96\n" +
		"127.19\n" +
		"127.82\n" +
		"129.19\n" +
		"129.82\n" +
		"130.07\n" +
		"131.82\n" +
		"132.07\n" +
		"136.19\n" +
		"136.44\n" +
		"140.69\n" +
		"141.19\n" +
		"142.69\n" +
		"143.19\n" +
		"143.69\n" +
		"144.19\n" +
		"148.44\n" +
		"150.69\n" +
		"151.19\n" +
		"151.69\n" +
		"152.19\n" +
		"156.44\n" +
		"157.69\n" +
		"158.94\n" +
		"161.19\n" +
		"162.19\n" +
		"163.96\n" +
		"165.69\n" +
		"166.94\n" +
		"172.69\n" +
		"173.19\n" +
		"175.19\n" +
		"176.57\n" +
		"177.57\n" +
		"179.19\n" +
		"180.57\n" +
		"181.57\n" +
		"183.19\n" +
		"183.69\n" +
		"184.19\n" +
		"185.19\n" +
		"186.69\n" +
		"187.94\n" +
		"188.69\n" +
		"191.19\n" +
		"192.57\n" +
		"193.57\n" +
		"195.19\n" +
		"196.57\n" +
		"197.57\n" +
		"199.19\n" +
		"199.94\n" +
		"200.19\n" +
		"202.19\n" +
		"202.32\n" +
		"202.44\n" +
		"205.94\n" +
		"207.69\n" +
		"207.94\n" +
		"213.94\n" +
		"215.69\n" +
		"215.94\n" +
		"221.94\n" +
		"223.69\n" +
		"223.94\n" +
		"229.94\n" +
		"231.69\n" +
		"231.94\n" +
		"237.94\n" +
		"239.69\n" +
		"239.94\n" +
		"245.94\n" +
		"247.69\n" +
		"247.94\n" +
		"253.94\n" +
		"255.69\n" +
		"255.94\n";

		int start = 0, end = 1, index = 0;
		for (int i = 0; i < yellow.length(); i++) {
			double num;
			if (yellow.substring(start, end).equals("\n")) {
				num = Double.parseDouble(yellow.substring(index, end));
				index += end - index;
				listYellow.add(num - D);
			}
			start++;
			end++;
		}
	}
	private void fillListBlue() {
		String blue = "37.94\n" +
		"45.94\n" +
		"47.94\n" +
		"50.69\n" +
		"53.44\n" +
		"55.94\n" +
		"59.69\n" +
		"60.19\n" +
		"69.94\n" +
		"77.94\n" +
		"79.94\n" +
		"82.69\n" +
		"85.44\n" +
		"87.94\n" +
		"91.69\n" +
		"92.19\n" +
		"95.19\n" +
		"95.69\n" +
		"96.69\n" +
		"100.69\n" +
		"104.69\n" +
		"106.57\n" +
		"107.57\n" +
		"109.19\n" +
		"111.19\n" +
		"112.69\n" +
		"116.69\n" +
		"120.69\n" +
		"126.69\n" +
		"127.69\n" +
		"128.69\n" +
		"129.69\n" +
		"131.69\n" +
		"135.69\n" +
		"138.19\n" +
		"141.19\n" +
		"141.69\n" +
		"147.94\n" +
		"155.94\n" +
		"157.94\n" +
		"160.69\n" +
		"163.44\n" +
		"165.94\n" +
		"169.69\n" +
		"170.19\n" +
		"173.19\n" +
		"173.69\n" +
		"174.69\n" +
		"178.69\n" +
		"182.69\n" +
		"184.57\n" +
		"185.57\n" +
		"187.19\n" +
		"189.19\n" +
		"181.69\n" +
		"194.69\n" +
		"198.69\n" +
		"204.94\n" +
		"206.19\n" +
		"207.19\n" +
		"212.94\n" +
		"214.19\n" +
		"214.94\n" +
		"220.94\n" +
		"222.19\n" +
		"223.19\n" +
		"228.94\n" +
		"230.19\n" +
		"230.94\n" +
		"236.94\n" +
		"238.19\n" +
		"239.19\n" +
		"244.94\n" +
		"246.19\n" +
		"246.94\n" +
		"252.94\n" +
		"254.19\n" +
		"255.19\n";

		int start = 0, end = 1, index = 0;
		for (int i = 0; i < blue.length(); i++) {
			double num;
			if (blue.substring(start, end).equals("\n")) {
				num = Double.parseDouble(blue.substring(index, end));
				index += end - index;
				listBlue.add(num - D);
			}
			start++;
			end++;
		}
	}
	private void fillListOrange() {
		String orange = "34.44\n" +
		"37.69\n" +
		"42.57\n" +
		"45.69\n" +
		"48.19\n" +
		"50.19\n" +
		"56.19\n" +
		"58.19\n" +
		"62.19\n" +
		"62.32\n" +
		"62.44\n" +
		"66.44\n" +
		"69.69\n" +
		"74.57\n" +
		"77.69\n" +
		"80.19\n" +
		"82.19\n" +
		"88.19\n" +
		"90.19\n" +
		"95.69\n" +
		"96.19\n" +
		"100.19\n" +
		"104.19\n" +
		"108.94\n" +
		"110.94\n" +
		"112.19\n" +
		"116.19\n" +
		"120.19\n" +
		"124.19\n" +
		"124.32\n" +
		"124.44\n" +
		"126.19\n" +
		"128.19\n" +
		"132.44\n" +
		"134.19\n" +
		"135.44\n" +
		"141.69\n" +
		"144.57\n" +
		"147.69\n" +
		"152.57\n" +
		"155.69\n" +
		"158.19\n" +
		"160.19\n" +
		"166.19\n" +
		"168.19\n" +
		"173.69\n" +
		"174.19\n" +
		"178.19\n" +
		"182.19\n" +
		"186.94\n" +
		"188.94\n" +
		"190.19\n" +
		"194.19\n" +
		"198.19\n" +
		"202.19\n" +
		"202.32\n" +
		"202.44\n" +
		"204.44\n" +
		"204.69\n" +
		"205.07\n" +
		"206.69\n" +
		"212.44\n" +
		"212.69\n" +
		"213.07\n" +
		"214.06\n" +
		"220.44\n" +
		"220.69\n" +
		"221.07\n" +
		"222.69\n" +
		"228.44\n" +
		"228.69\n" +
		"229.07\n" +
		"230.69\n" +
		"236.44\n" +
		"236.69\n" +
		"237.07\n" +
		"238.69\n" +
		"244.44\n" +
		"244.69\n" +
		"245.07\n" +
		"246.69\n" +
		"252.44\n" +
		"252.69\n" +
		"253.07\n" +
		"254.69\n";

		int start = 0, end = 1, index = 0;
		for (int i = 0; i < orange.length(); i++) {
			double num;
			if (orange.substring(start, end).equals("\n")) {
				num = Double.parseDouble(orange.substring(index, end));
				index += end - index;
				listOrange.add(num - D);
			}
			start++;
			end++;
		}
	}


	ArrayList<Double> getListGreen() {
		return listGreen;
	}
	ArrayList<Double> getListRed() {
		return listRed;
	}
	ArrayList<Double> getListYellow() {
		return listYellow;
	}
	ArrayList<Double> getListBlue() {
		return listBlue;
	}
	ArrayList<Double> getListOrange() {
		return listOrange;
	}



}



