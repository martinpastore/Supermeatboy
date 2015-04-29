import java.awt.event.KeyEvent;


public class MeatBoyRunnable implements Runnable {
	private MeatBoyInput input;
	private MeatBoy meatboy;
	private double dx;	//needs to eventually slow to a stop, rather than immediately decrease to 0. Needs implementation below
	private double dy;  //needs toeventually slow to a stop, rather than immediately decrease to 0. Needs implementation below
	public MeatBoyRunnable(MeatBoyInput i, MeatBoy m){
		dx =.25;
		dy=.25;
		input=i;
		meatboy =m;
	}
	@Override
	public void run() {
		while(meatboy.isAlive()){
			if(input.isKeyPressed(KeyEvent.VK_LEFT)){
				meatboy.setXVel(-2);
			}
			else if(input.isKeyPressed(KeyEvent.VK_RIGHT)){
				meatboy.setXVel(2);
			}
			else{
				meatboy.setXVel(0);
			}
			if(input.isKeyPressed(KeyEvent.VK_UP)){
				meatboy.setYVel(-2);
			}
			else if(input.isKeyPressed(KeyEvent.VK_DOWN)){
				meatboy.setYVel(2);
			}
			else{
				meatboy.setYVel(0);
			}
			try {
				Thread.sleep(100);	//this should be the frame rate, right now it is 10 fps
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}