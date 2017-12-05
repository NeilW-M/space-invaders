package wave;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class WaveCreator extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private boolean trackingMouse = false;
	
	private int mx = -50, my = 50;
	
	private String[] parameters = {
			"1", //Name of file
			"10", //Speed
			"3,10", //Type,Number
	};
	
	private Canvas canvas = new Canvas();
	
	private List<int[]> coords = new ArrayList<int[]>();
	
	private Keys kl = new Keys();
	private MouseMotionListener ml = new Mouse();
	
	public WaveCreator() {
		createFile();
		
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Wave Creator.");
		setResizable(false);
		
		addKeyListener(kl);
		
		add(canvas);
		
		canvas.addMouseMotionListener(ml);
		
		setVisible(true);
		
		canvas.createBufferStrategy(2);
	}
	
	/**
	 * Creates a new file with the name specified.
	 * @param split
	 */
	private void createFile() {
		try {
			File file = new File("waves/" + "wave" + parameters[0] + ".txt");
			if(file.createNewFile()) {
				System.out.println("File Created.");
			} else {
				System.out.println("File not created.");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile() {
		try {
			FileWriter writ = new FileWriter("waves/" + parameters[0] + ".txt");
			writ.write(parameters[1] + "\n");
			writ.write("switch\n");
			writ.write(parameters[2] + "\n");
			writ.write("switch\n");
			for(int i = 0; i < coords.size(); i++) {
				for(int j = 0; j < coords.get(i).length; j++) {
					writ.write(coords.get(i)[0] + "," + coords.get(i)[1] + "\n");
				}
			}
			writ.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public void update() {
		
	}
	*/
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		 long lastTime = System.nanoTime();
	     double nanoSecondConversion =   1000000000.0 / 60;
	     double deltaSeconds = 0;
	     while(true) {
	    	 long now = System.nanoTime();
	         deltaSeconds += (now - lastTime) / nanoSecondConversion;
	         while(deltaSeconds >= 2) {
	             //update();
	             deltaSeconds = 0;
	         }
	         render();
	         lastTime = now;
	     }
	}
	
	public static void main(String[] args) {		
		WaveCreator wave = new WaveCreator();
		Thread thrd = new Thread(wave);
		thrd.start();
	}
	
	private class Keys extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_SPACE) {
				if(trackingMouse)
					trackingMouse = false;
				else if(!trackingMouse)
					trackingMouse = true;
			}
			
			if(key == KeyEvent.VK_W) {
				trackingMouse = false;
				writeToFile();
			}
		}
	}
	
	private class Mouse extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			if(trackingMouse) {
				mx = e.getX();
				my = e.getY();
				System.out.println(mx + "." + my);
				int[] temp = {mx, my};
				coords.add(temp);
			}
		}
	}
}
