package Sprites;

import basis.Bild;

public class MainBild {
	private Bild map,player;
	
	public MainBild() {
		map = new Bild("/Sprittes/map.png");
		map.setzePosition(150, 80);
		player = new Bild("/Sprittes/player.png");
		player.setzePosition(250, 250);
		
	}
	public void setZ() {
		map.setzeZOrdnung(0);
	}
	public void setPostition(int nx, int ny) {
		player.setzePosition(nx,ny);
	}
	
	
}
