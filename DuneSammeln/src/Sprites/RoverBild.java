package Sprites;

import basis.Bild;

public class RoverBild extends MainBild{
	protected Bild Rover, RoverLeft, RoverRight, RoverUp;
	protected Bild map;
	public RoverBild() {
		super();
		
		Rover = new Bild("/Sprittes/RoverOben.png");
		RoverLeft = new Bild("/Sprittes/RoverLeft.png");
		RoverRight = new Bild("/Sprittes/RoverRight.png");
		RoverUp = new Bild("/Sprittes/Rover.png");
		
		RoverLeft.setzeSichtbar(false);
		Rover.setzeSichtbar(false);
		RoverUp.setzeSichtbar(false);
	}

	@Override
	public void setPos(int nx, int ny) {
		Rover.setzePosition(nx, ny);
		RoverLeft.setzePosition(nx, ny);
		RoverRight.setzePosition(nx, ny);
		RoverUp.setzePosition(nx, ny);
		
	}

	@Override
	public void setLayer(int layer) {
		Rover.setzeZOrdnung(layer);
		RoverLeft.setzeZOrdnung(layer);
		RoverRight.setzeZOrdnung(layer);
		RoverUp.setzeZOrdnung(layer);
		
	}

	@Override
	public void ladeMap() {
		map = new Bild("/Sprittes/map.png");
		map.setzePosition(150, 80);
		map.setzeZOrdnung(2);
	}
	
	public void rechts() {
		Rover.setzeSichtbar(false);
		RoverLeft.setzeSichtbar(false);
		RoverRight.setzeSichtbar(true);
		RoverUp.setzeSichtbar(false);
	}
	public void links() {
		Rover.setzeSichtbar(false);
		RoverLeft.setzeSichtbar(true);
		RoverRight.setzeSichtbar(false);
		RoverUp.setzeSichtbar(false);
	}
	public void oben() {
		Rover.setzeSichtbar(true);
		RoverLeft.setzeSichtbar(false);
		RoverRight.setzeSichtbar(false);
		RoverUp.setzeSichtbar(false);
	}
	public void unten() {
		Rover.setzeSichtbar(false);
		RoverLeft.setzeSichtbar(false);
		RoverRight.setzeSichtbar(false);
		RoverUp.setzeSichtbar(true);
	}

	@Override
	public void setSichtbar(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
	
	
