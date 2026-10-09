package ja;


import java.awt.Color;

import basis.Farbe;
import basis.Stift;

public class Quadrat {

    private Stift stifti;
    private int xPos;
    private int yPos;
    private int size;
    private Color color;

    public Quadrat() {
        stifti = new Stift();
        color = Color.black;
    }

    public void Malen() {
        stifti.bewegeBis(xPos, yPos);
        stifti.setzeFarbe(color);
        stifti.zeichneRechteck(size, size);

        stifti.bewegeBis(xPos + 1, yPos + 1);
        stifti.fuelle(color, color);
    }

    public void radiere() {
        stifti.bewegeBis(xPos, yPos);
        stifti.setzeFarbe(Color.white);
        stifti.zeichneRechteck(size, size);

        stifti.bewegeBis(xPos + 1, yPos + 1);
        stifti.fuelle(Color.white, Color.white);
    }

    public void setX(int x) {
        xPos = x;
    }

    public int getX() {
        return xPos;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getY() {
        return yPos;
    }

    public void setSize(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }
    public void setColor(Color newColor) {
		color = newColor;
	}
}