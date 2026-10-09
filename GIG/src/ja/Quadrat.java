package ja;

import java.awt.Color;

import basis.Farbe;
import basis.Hilfe;
import basis.Stift;

public class Quadrat {

	private Stift stifti;

	private int xPos;
	private int yPos;
	private int size;

	private Color color;
	private Color deckcolor;

	private boolean aufgedeckt;
	private boolean fertig;
	private boolean ersterClick;

	public Quadrat() {

		stifti = new Stift();

		color = Color.black;

		aufgedeckt = false;
		fertig = false;
		ersterClick = true;
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

	public void neumalen() {

		stifti.bewegeBis(xPos, yPos);

		stifti.setzeFarbe(Color.white);
		stifti.zeichneRechteck(size, size);

		stifti.bewegeBis(xPos + 1, yPos + 1);
		stifti.fuelle(Color.white, Color.white);

		stifti.bewegeBis(xPos, yPos);

		stifti.setzeFarbe(color);
		stifti.zeichneRechteck(size, size);

		stifti.bewegeBis(xPos + 1, yPos + 1);
		stifti.fuelle(color, color);
	}

	public void deckneumalen() {

		deckcolor = Farbe.rgb(98, 88, 81);

		stifti.bewegeBis(xPos, yPos);

		stifti.setzeFarbe(deckcolor);
		stifti.zeichneRechteck(size, size);

		stifti.bewegeBis(xPos + 1, yPos + 1);
		stifti.fuelle(deckcolor, deckcolor);
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

	public Color getColor() {
		return color;
	}

	public void setaufgedeckt(boolean b) {
		aufgedeckt = b;
	}

	public boolean getaufgedeckt() {
		return aufgedeckt;
	}

	public void setersterClick(boolean b) {
		ersterClick = b;
	}

	public boolean getersterClick() {
		return ersterClick;
	}

	public void setfertig(boolean b) {
		fertig = b;
	}

	public boolean getfertig() {
		return fertig;
	}

	public void BorderEnes(int mx, int my) {

		if (istUnterMaus(mx, my) && !fertig) {

			radiere();

			Hilfe.warte(300);

			if (!aufgedeckt) {
				deckneumalen();
			}
		}
	}

	public void geklickt(int mx, int my) {

		if (istUnterMaus(mx, my) && !aufgedeckt && !fertig && ersterClick) {

			Hilfe.warte(300);

			aufgedeckt = true;

			ersterClick = false;

			Malen();
		}
	}

	private boolean istUnterMaus(int mx, int my) {

		return xPos < mx && xPos + size > mx && yPos < my && yPos + size > my;
	}
}
