package Sprites;

import basis.Bild;

public class WurmBild extends MainBild {
private Bild worm;
	
	public WurmBild() {
		worm = new Bild("/Sprittes/worm.png");
	}
	@Override
	public void setPos(int nx, int ny) {
		worm.setzePosition(nx, ny);
		
	}

	@Override
	public void setLayer(int layer) {
		worm.setzeZOrdnung(layer);
		
	}

	@Override
	public void ladeMap() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void setSichtbar(boolean b) {
		worm.setzeSichtbar(b);
		
	}

}

