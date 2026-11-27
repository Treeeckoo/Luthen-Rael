
package paket;

import java.awt.Color;

import Sprites.RoverBild;
import basis.*;

public class Crawler {

    
    private int x, y, size,i;
    private Color color;
    private Stift stift;
    private RoverBild rover;


    public Crawler() {
        size = 64;
        x = 155;
        y = 100;
        stift = new Stift();
        rover = new RoverBild();
        i = Hilfe.zufall(1, 4);
        rover.ladeMap();
    }


    public void malen() {
        color = color.red;
        stift.bewegeBis(x, y);
        stift.bewegeBis(x + 1, y + 1);

        rover.setLayer(1);
        rover.setPos(x, y);
    }

    
    public void radieren() {
        color = color.white;
        stift.setzeFarbe(color);
        stift.bewegeBis(x, y);
        stift.zeichneRechteck(size, size);
        stift.bewegeBis(x + 2, y + 2);
        stift.fuelle(color, color);
    }


    public void setPos(int sx, int sy) {
        x = sx;
        y = sy;
        stift.bewegeBis(sx, sy);
    }


    public void setSicht(boolean b) {
        rover.setSichtbar(b);
    }


    public void bewege(String s) {
        Hilfe.warte(1);
        int a = 0;

        // Nach oben
        if (y > 85 && 510 >= y) {
            if ("Oben".equals(s)) {
                rover.oben();
                Hilfe.warte(1);
                radieren();

                for (int i = 1; i < 2; i++) {
                    a = i;
                }

                y = y - a;
            }

            malen();
        }

        // Nach rechts
        if (x >= 145 && 695 >= x) {
            if ("Rechts".equals(s)) {
                rover.rechts();
                Hilfe.warte(1);
                radieren();

                for (int i = 1; i < 2; i++) {
                    a = i;
                }

                x = x + a;
            }

            malen();
        }

        // Nach unten
        if (y >= 50 && 450 >= y) {
            if ("Unten".equals(s)) {
                rover.unten();
                Hilfe.warte(1);
                radieren();

                for (int i = 1; i < 2; i++) {
                    a = i;
                }

                y = y + a;
            }

            malen();
        }

        // Nach links
        if (x >= 160 && 700 >= x) {
            if ("Links".equals(s)) {
                rover.links();
                Hilfe.warte(1);
                radieren();

                for (int i = 1; i < 2; i++) {
                    a = i;
                }

                x = x - a;
            }

            malen();
        }
    }
    public void Extract() {
    	
    	if(i==1) {
    		rover.links();
    		Hilfe.warte(750);
    		for(int b = x; b>-200;b--) {
    			x= x-1;
    			malen();
    			Hilfe.warte(5);
    		}
    	}
    	if(i==2) {
    		rover.rechts();
    		Hilfe.warte(750);
    		for(int b = x; b<900;b++) {
    			x= x+1;
    			malen();
    			Hilfe.warte(5);
    		}
    	}
    	if(i==3) {
    		rover.oben();
    		Hilfe.warte(750);
    		for(int b = y; b>-200;b--) {
    			y= y-1;
    			malen();
    			Hilfe.warte(5);
    		}
    	}
    	if(i==4) {
    		rover.unten();
    		Hilfe.warte(750);
    		for(int b = y; b<700;b++) {
    			y= y+1;
    			malen();
    			Hilfe.warte(5);
    		}
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
        color = nc;
    }

    void setZ(int nz) {
        rover.setLayer(nz);
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
