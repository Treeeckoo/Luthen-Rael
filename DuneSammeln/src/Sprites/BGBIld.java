package Sprites;

import basis.Bild;

public class BGBIld extends MainBild{

	private Bild bg;
	public BGBIld() {
		
		bg = new Bild("/Sprittes/DuneBG.png");
		bg.setzeSichtbar(false);
	}
	@Override
	public void setPos(int nx, int ny) {
		bg.setzePosition(nx, ny);
		
	}

	@Override
	public void setLayer(int layer) {
		bg.setzeZOrdnung(layer);
		
	}

	@Override
	public void ladeMap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSichtbar(boolean b) {
		bg.setzeSichtbar(b);
		
	}

}
