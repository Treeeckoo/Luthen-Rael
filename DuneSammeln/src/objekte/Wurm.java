package objekte;

public class Wurm extends object {
	
	public Wurm() {
		super();
	}
	
	public void malen() {
		color = color.black;
		stift.zeichneKreis(size/2);
		stift.bewegeBis(x+1, y+1);
		stift.fuelle(color, color);
	}
	
	public void radieren() {
		color = color.white;
		stift.setzeFarbe(color);
		stift.bewegeBis(x, y);
		stift.zeichneKreis(size/2);
		
		stift.fuelle(color, color);
		wurderadiert();
	}
	
	

	@Override
	public void checkClick(int mx, int my) {
	    int radius = size / 2;

	    int dx = mx - x;
	    int dy = my - y;

	    if (dx * dx + dy * dy <= radius * radius) {
	        radieren();
	    }
	}
	
	

}
