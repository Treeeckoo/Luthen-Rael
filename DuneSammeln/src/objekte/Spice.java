package objekte;

public class Spice extends object {

	
	public Spice() {
		super();
	}
	
	public void malen() {
		color = color.black;
		stift.zeichneRechteck(size,size);
		stift.bewegeBis(x+1, y+1);
		stift.fuelle(color, color);
	}
	
	public void radieren() {
		color = color.white;
		stift.setzeFarbe(color);
		stift.bewegeBis(x, y);
		stift.zeichneRechteck(size,size);
		stift.bewegeBis(x+2, y+2);
		stift.fuelle(color, color);
		wurderadiert();
	}

	@Override
	public void checkClick(int mx, int my) {
		if(mx > x && my > y && mx < x + size && my < y + size) {
			radieren();
		}
		
	}
}
