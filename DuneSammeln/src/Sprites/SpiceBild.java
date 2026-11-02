package Sprites;

import basis.Bild;

public class SpiceBild extends MainBild {
private Bild spice;
	
	public SpiceBild() {
		spice = new Bild("/Sprittes/spice.png");
	}
	@Override
	public void setPos(int nx, int ny) {
		spice.setzePosition(nx, ny);
	}

	@Override
	public void setLayer(int layer) {
		spice.setzeZOrdnung(layer);
	}

	@Override
	public void ladeMap() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSichtbar(boolean b) {
		spice.setzeSichtbar(b);
		
	}

}
