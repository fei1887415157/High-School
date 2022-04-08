//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//import java.awt.RenderingHints;
//import java.util.ArrayList;
//
//
//
//public class LeaderBoard {
//
//	private int frameX, frameY;
//
//
//	boolean canClick = true, start=false;
//	int[] scores = new int[5];
//	String [] names = new String[5];
//	Rectangle replay = new Rectangle( 3 * (frameX / 10), 3 * frameY / 4,
//			frameX / 4, frameY / 6);
//
//	public LeaderBoard() {
//		for(int i = 0; i< scores.length;i++) {
//			scores[i]=0;
//		}
//	}
//
//	public void start(int s) {
//		if(addScore(s)>=0) {
//			//		JOptionPane     //get name so you can add to leaderboard
//		}
//
//	}
//
//	public void clicked() {
//		canClick = false;
//		start = true;
//	}
//
//	public boolean canClick() {
//		return canClick;
//	}
//
//	public boolean canAddScore(int s) {
//		for(int i = scores.length -1 ; i >= 0; i--) {
//			if(s > scores[i])
//				return true;
//		}
//
//		return false;
//	}
//
//	public int addScore(int s) {
//		int temp = 0;
//		if(canAddScore(s)) {
//			for(int i = 0; i <scores.length;i++) {
//				if(s>scores[i] && i!=4) {
//
//					for(int c = scores.length-1;c>=i;c--) {
//						scores[c] = scores[c-1];
//					}
//					scores[i] = s;
//					return 1;
//				}
//
//				else if(s>scores[i] && i==4) {
//					scores[i] = s;
//					return 1;
//				}
//			}
//		}
//		return -1;
//	}
//	public void paint(Graphics g1) {
//		Graphics2D g = (Graphics2D) g1;
//		g.setColor(Color.white);
//		g.fillRect((int) ((Game.SCREEN_SIZE.getWidth()/3)-5),0 , (int) ((Game.SCREEN_SIZE.getWidth()/3)+10), (int) Game.SCREEN_SIZE.getHeight()-5);
//		g.setColor(Color.BLACK);
//		g.fillRect((int) ((Game.SCREEN_SIZE.getWidth()/3)),5 , (int) ((Game.SCREEN_SIZE.getWidth()/3)), (int) Game.SCREEN_SIZE.getHeight()-10);
//		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
//		g.setColor(Color.yellow);
//		g.drawString("Leaderboard", (int) ((Game.SCREEN_SIZE.getWidth()/3)+20), 50);
//		g.setColor(Color.white);
//		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
//		for(int i = 1; i <=scores.length;i++) {
//			g.drawString(String.valueOf(scores[i-1]), (int) (3*(Game.SCREEN_SIZE.getWidth()/5)), (int) ((i+2)*(Game.SCREEN_SIZE.getHeight()/10)));
//		}
//		g.setColor(Color.GRAY);
//		g.fill(replay);
//		g.setColor(Color.yellow);
//		g.setFont(new Font("TimesRoman", Font.BOLD, 60));
//		g.drawString("Replay", (int)(4*Game.SCREEN_SIZE.getWidth()/10),(int)((3*Game.SCREEN_SIZE.getHeight()/4)+20));
//
//	}
//
//	public Rectangle getReplay() {
//		return replay;
//	}
//
//
//
//
//}
//
//
