import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class MeatBoyLevel extends JPanel implements ActionListener{
	private Timer time;
	private MeatBoy player;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private ArrayList<Platform> platformList;
	public MeatBoyLevel(Component c)   {
		platformList = new ArrayList<Platform>();
		for(int i=0;i<4;i++){
			for (int i2 = 0; i2<4; i2++)
			{
			Platform plat = new Platform(i*50+300,400-i2*100,50,50);
			plat.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			platformList.add(plat);
			}
			Platform test = new Platform(130,350-i*50,50,50);
			test.setColor(Color.GREEN);
			platformList.add(test);
		}
		Platform test = new Platform(130,450,50,50);
		test.setColor(Color.GREEN);
		platformList.add(test);
		Platform ground = new Platform(50,500,450,50);
		ground.setColor(Color.GREEN);
		platformList.add(ground);
		player = new MeatBoy(c,this);	
		time=new Timer(17,this);
		time.start();
		
	}
	public void update(){
		player.move();	
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		player.draw(g);	
		for(Platform p:platformList){
			p.draw(g);
		}
	}
	public ArrayList<Platform> getPlatforms(){
		return platformList;
	}
	public void actionPerformed(ActionEvent e){
		update();
		repaint();
	}
	
}