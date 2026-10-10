package paket;

import java.awt.Color;

import basis.*;

public class Crawler {
	private int x,y,size;
	private Color color;
	private Stift stift;
	
	public Crawler() {
		size = 50;
		x=150;
		y=150;
		stift = new Stift();
	}
	
	public void malen() {
		color = color.red;
		stift.bewegeBis(x, y);
		stift.setzeFarbe(color);
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
	}
	
	public void setPos(int sx, int sy) {
		x = sx;
		y = sy;
		stift.bewegeBis(sx, sy);
	}
	
	
	
	public void bewege(String s) {
		Hilfe.warte(1);
		int a =0;
		
		if (y>90 && 510 >= y) {
	    if ("Oben".equals(s)) {
	    	radieren();
	    	for(int i =1;i<3;i++) {
	        	a = i;
	        }
	        y = y - a;
	        }
	        malen();
		}

		
		if (x>=130 && 690 >= x) {
	    if ("Rechts".equals(s)) {
	        radieren();
	        for(int i =1;i<3;i++) {
	        	a =i;
	        }
	        x = x + a;
	        }
	        malen();
		}
	        if (y>= 50 && 450 >= y) {
	    if ("Unten".equals(s)) {
	        radieren();
	        for(int i =1;i<3;i++) {
	        	a =i;
	        }
	        y = y + a;
	        }
	        malen();
	        }

	        if (x>=130 && 710 >= x) {
	    if ("Links".equals(s)) {
	    	
	        radieren();
	        for(int i =1;i<3;i++) {
	        	a =i;
	        }
	        x = x - a;
	        }
	        malen();
	    }
	}
	    
	

	void setX(int nx) {
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
}
