package ja;

import basis.*;
import java.awt.Color;

public class Panel {

	private Fenster fensti;
	private Quadrat[][] quadrat;
	private KotenderEnes kotenes;
	private Kreis kreis;
	private Knopf enes;
	private Maus tom;
	private Color[] fabi;
	private int[] karten;
	private int spieler;
	private int farbe;
	private Color color3;

	private TextFeld textfeld, textfeld1, textfeld2;
	private ZahlenFeld zahlenfeld, zahlenfeld1;

	public Tastatur Key;

	public Panel() {

		fensti = new Fenster(800, 855);

		textfeld = new TextFeld();
		textfeld1 = new TextFeld();
		textfeld2 = new TextFeld();

		zahlenfeld = new ZahlenFeld();
		zahlenfeld1 = new ZahlenFeld();

		farbe = 0;

		
		quadrat = new Quadrat[5][5];

		kreis = new Kreis();

		enes = new Knopf("BomberEnes", 72, 775, 110, 50);

		tom = new Maus();

		kotenes = new KotenderEnes();

		fabi = new Color[] { Farbe.rgb(168, 91, 105), Farbe.rgb(184, 107, 77), Farbe.rgb(187, 160, 82),
				Farbe.rgb(105, 141, 101), Farbe.rgb(74, 124, 117), Farbe.rgb(82, 123, 168), Farbe.rgb(100, 90, 160),
				Farbe.rgb(141, 90, 145), Farbe.rgb(140, 109, 83), Farbe.rgb(95, 107, 115), Farbe.rgb(132, 148, 74),
				Farbe.rgb(147, 127, 153), Farbe.rgb(36, 34, 41) };

		
		karten = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		spieler = 1;

		starteAlles();
	}

	public void starteAlles() {

		Operation();

		drawQuadrat();

		Mische();

		Redo();
	}

	private void drawQuadrat() {

		int anzahl = 0;
		farbe = 0;

		for (int i = 0; i < 5; i++) {

			for (int b = 0; b < 5; b++) {

				quadrat[i][b] = new Quadrat();

				quadrat[i][b].setX(85 + 130 * b);
				quadrat[i][b].setY(150 + 130 * i);
				quadrat[i][b].setSize(100);

				quadrat[i][b].setColor(fabi[karten[farbe]]);

				quadrat[i][b].Malen();

				anzahl++;

				
				if (anzahl == 2 && farbe < 11) {

					farbe++;
					anzahl = 0;
				}
			}
		}
	}

	public void Mische() {

		int x, y, z, v;

		for (int i = 1; i < 300; i++) {

			x = Hilfe.zufall(0, 4);
			y = Hilfe.zufall(0, 4);

			v = Hilfe.zufall(0, 4);
			z = Hilfe.zufall(0, 4);

			color3 = quadrat[x][y].getColor();

			quadrat[x][y].setColor(quadrat[v][z].getColor());
			quadrat[v][z].setColor(color3);

			quadrat[x][y].neumalen();
			quadrat[v][z].neumalen();
		}

		for (int n = 0; n < 5; n++) {

			for (int m = 0; m < 5; m++) {

				quadrat[n][m].deckneumalen();

				quadrat[n][m].setaufgedeckt(false);
				quadrat[n][m].setersterClick(true);
				quadrat[n][m].setfertig(false);
			}
		}
	}

	public void Redo() {

		int tempi = -1;
		int tempb = -1;

		while (!enes.wurdeGedrueckt()) {

			Hilfe.warte(1);

			textfeld.setzeText("Spieler " + spieler + " ist dran");

			if (tom.istGedrueckt()) {

				for (int i = 0; i < 5; i++) {

					for (int b = 0; b < 5; b++) {

						quadrat[i][b].BorderEnes(tom.hPosition(), tom.vPosition());

						quadrat[i][b].geklickt(tom.hPosition(), tom.vPosition());

						if (quadrat[i][b].getaufgedeckt() && !quadrat[i][b].getfertig()
								&& !quadrat[i][b].getersterClick()) {

							quadrat[i][b].Malen();

							
							if (tempi == -1) {

								tempi = i;
								tempb = b;
							}

							
							else if (!(tempi == i && tempb == b)) {

								quadrat[i][b].Malen();

								Hilfe.warte(300);

								
								if (quadrat[tempi][tempb].getColor().equals(quadrat[i][b].getColor())) {

									quadrat[tempi][tempb].setfertig(true);
									quadrat[i][b].setfertig(true);

									quadrat[tempi][tempb].Malen();
									quadrat[i][b].Malen();

									kotenes.plusPunkt();

									if (kotenes.getSpieler1()) {

										zahlenfeld.setzeZahl(kotenes.getPunkte1());

									} else {

										zahlenfeld1.setzeZahl(kotenes.getPunkte2());
									}
								}

							
								else {

									Hilfe.warte(300);

									quadrat[tempi][tempb].setaufgedeckt(false);

									quadrat[i][b].setaufgedeckt(false);

									
									quadrat[tempi][tempb].setersterClick(true);

									quadrat[i][b].setersterClick(true);

									quadrat[tempi][tempb].deckneumalen();

									quadrat[i][b].deckneumalen();

									
									kotenes.wechsleSpieler();

									if (kotenes.getSpieler1()) {
										spieler = 1;
									} else {
										spieler = 2;
									}

									Hilfe.warte(20);
								}

								
								tempi = -1;
								tempb = -1;
							}
						}
					}
				}
			}
		}

		
		fensti.gibFrei();
		fensti.setzeSichtbar(false);
	}

	public void Operation() {

		fensti.setzeHintergrundFarbe(Farbe.rgb(246, 243, 232));

		fensti.setzeTitel("Das BomberQuadrat");

		enes.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));

		enes.setzeSchriftGroesse(12);

		// Spieleranzeige
		textfeld.setzePosition(75, 25);
		textfeld.setzeGroesse(200, 40);
		textfeld.setzeEditierbar(false);
		textfeld.setzeSchriftGroesse(25);
		textfeld.setzeText("Spieler " + spieler + " ist dran");
		textfeld.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));

		// Spieler 1
		textfeld1.setzePosition(405, 15);
		textfeld1.setzeGroesse(192, 30);
		textfeld1.setzeEditierbar(false);
		textfeld1.setzeSchriftGroesse(20);
		textfeld1.setzeText("Punkte von Spieler 1:");
		textfeld1.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));

		// Spieler 2
		textfeld2.setzePosition(405, 75);
		textfeld2.setzeGroesse(192, 30);
		textfeld2.setzeEditierbar(false);
		textfeld2.setzeSchriftGroesse(20);
		textfeld2.setzeText("Punkte von Spieler 2:");
		textfeld2.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));

		// Punkte Spieler 1
		zahlenfeld.setzePosition(600, 15);
		zahlenfeld.setzeGroesse(30, 30);
		zahlenfeld.setzeEditierbar(false);
		zahlenfeld.setzeSchriftGroesse(20);
		zahlenfeld.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));
		zahlenfeld.setzeZahl(0);

		// Punkte Spieler 2
		zahlenfeld1.setzePosition(600, 75);
		zahlenfeld1.setzeGroesse(30, 30);
		zahlenfeld1.setzeEditierbar(false);
		zahlenfeld1.setzeSchriftGroesse(20);
		zahlenfeld1.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));
		zahlenfeld1.setzeZahl(0);
	}
}
