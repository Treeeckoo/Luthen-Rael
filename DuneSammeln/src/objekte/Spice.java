package objekte;

import Sprites.SpiceBild;

public class Spice extends object {
	private SpiceBild spice;
	
	public Spice() {
		super();
		spice = new SpiceBild();
	}
	
	public void malen() {
		spice.setLayer(1);
		spice.setPos(x, y);
	}
	
	public void radieren() {
		spice.setSichtbar(false);
	}

	@Override
	public void checkClick(int mx, int my) {
		if(mx > x && my > y && mx < x + size && my < y + size) {
			radieren();

	        System.out.println("spice");
		}
		
	}
}
