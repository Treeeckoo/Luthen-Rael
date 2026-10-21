package Sprites;


public abstract class MainBild {
	
	public MainBild() {
		
		
	}
	public abstract void setPos(int nx, int ny);
	
	public abstract void setLayer(int layer);
	
	public abstract void ladeMap();
	
	public abstract void setSichtbar(boolean b);
	
}
