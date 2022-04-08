import java.awt.*;

class Note {


	private boolean start = false;
	private double time;
	private final int speed = 20;
	private int x;
	private int y;
	//color: 1 = green; 2 = red; 3 = yellow; 4 = blue; 5 = orange
	private int color;

	private int rA = 50;
	private int rb = 40;




	Note(int x, int color, double time){
		this.x = x;
		this.y = -50;
		this.color = color;
		this.time = time;
	}


	void paint(Graphics graphics) {

		Graphics2D g = (Graphics2D) graphics;


		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


		g.setColor(Color.white);
		g.fillOval(x, y, 50, 50);


		Color color;
		switch (this.color) {
			case 1:
				color = Color.green;
				break;
			case 2:
				color = Color.red;
				break;
			case 3:
				color = Color.yellow;
				break;
			case 4:
				color = Color.blue;
				break;
			case 5:
				color = Color.orange;
				break;


			default:
				color = Color.white;
		}

		g.setColor(color);
		g.fillOval(x + (rA - rb) / 2, y + (rA - rb) / 2, rb, rb);

		move();


	}




	void move(){
		y += speed;
	}



	int getY() {
		return y;
	}


	double getTime() {
		return time;
	}

	boolean isStart() {
		return start;
	}

	void setStart(boolean start) {
		this.start = start;
	}
}
