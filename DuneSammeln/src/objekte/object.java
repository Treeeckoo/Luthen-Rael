package objekte;

import java.awt.Color;

import basis.*;

public abstract class object {
	
	protected int x,y,size;
	protected Color color;
	protected Stift stift;
	protected boolean tru;
	protected boolean angecklickt;
	protected boolean fertig;
	
	
		public object() {
			size = 64;
			x=50;
			y=50;
			stift = new Stift();
			tru = true;
			angecklickt = false;
			fertig = false;
			
		}
			public abstract void checkClick(int mx, int my);
				
				
			
		
		
		
		
		public void setPos(int sx, int sy) {
			x = sx;
			y = sy;
			stift.bewegeBis(sx, sy);
		}
		
		
		
		
		public void setX(int nx) {
			x = nx;
		}
		public void setY(int ny) {
			y = ny;
		}
		public void setSize(int ns) {
			size = ns;
		}
		public void setColor(Color nc) {
			color =nc;
		}
		
		
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getSize() {
			return size;
		}
		public Color getColor() {
			return color;
		}
		public boolean wurderadiert() {
			return tru;
			
		}
		public boolean getAngeklickt() {
	    	return angecklickt;
	    }
		public boolean getfertig() {
			return fertig;
		}
		public void setfertig(boolean a) {
			fertig = a;
		}
		
	



}
