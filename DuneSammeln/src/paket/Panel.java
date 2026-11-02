package paket;

import objekte.*;
import Sprites.MainBild;
import Sprites.RoverBild;
import basis.*;

public class Panel {
	private Wurm[] wurm;
	private Spice[] spice;
	private Crawler crawler;
	private Fenster fenster;
	private Knopf ende;
	private Maus maus;
	private Tastatur tastatur;
	private RoverBild rover;

	public Panel() {

		fenster = new Fenster("DuneSpiel", 800, 560);
		ende = new Knopf("Ende", 20, 20, 80, 40);
		tastatur = new Tastatur();
		crawler = new Crawler();
		wurm = new Wurm[4];
		spice = new Spice[10];
		maus = new Maus();

		starten();
	}

	public void starten() {
		SpielfeldMalen();
		loop();
	}

	public void SpielfeldMalen() {
		for (int i = 0; i < 4; i++) {
			wurm[i] = new Wurm();
			wurm[i].setPos(Hilfe.zufall(170, 695), Hilfe.zufall(85, 450));

			if (i != 0) {
				while (wurm[i].getX() - wurm[i - 1].getX() < 200 && wurm[i].getY() - wurm[i - 1].getY() < -200)  {

					wurm[i].setPos(Hilfe.zufall(170, 695), Hilfe.zufall(85, 450));
				}
			}

			wurm[i].malen();
		}
		for (int i = 0; i < 10; i++) {
			spice[i] = new Spice();
			spice[i].setPos(Hilfe.zufall(170, 695), Hilfe.zufall(85, 450));
			
			if (i != 0) {
				while (spice[i].getX() - spice[i - 1].getX() < 150 && spice[i].getY() - spice[i - 1].getY() < -150) {

					spice[i].setPos(Hilfe.zufall(170, 695), Hilfe.zufall(85, 450));
				}
			}
			spice[i].malen();
		}

		crawler.malen();
	}

	public void loop() {
		while (!ende.wurdeGedrueckt()) {
			Hilfe.warte(1);
			if (maus.istGedrueckt()) {
				for (int i = 0; i < 10; i++) {
					ClickeSpice(i);
				}
				for (int i = 0; i < 4; i++) {
					ClickeWurm(i);
				}
			}
			if (tastatur.wurdeGedrueckt()) {
				char taste = tastatur.holeZeichen();

				if (taste == 'w') {
					crawler.bewege("Oben");
				}
				if (taste == 's') {
					crawler.bewege("Unten");
				}
				if (taste == 'a') {
					crawler.bewege("Links");
				}
				if (taste == 'd') {
					crawler.bewege("Rechts");
				}
			}

			if (ende.wurdeGedrueckt()) {
				fenster.gibFrei();
				fenster.setzeSichtbar(false);
			}
		}
	}

	public void ClickeSpice(int i) {
		spice[i].checkClick(crawler.getX(), crawler.getY()); // oben links

		spice[i].checkClick(crawler.getX() + 64, crawler.getY()); // oben rechts

		spice[i].checkClick(crawler.getX(), crawler.getY() + 64); // unten links

		spice[i].checkClick(crawler.getX() + 64, crawler.getY() + 64); // unten rechts
	}

	public void ClickeWurm(int i) {
		wurm[i].checkClick(crawler.getX(), crawler.getY()); // oben links

		wurm[i].checkClick(crawler.getX() + 64, crawler.getY()); // oben rechts

		wurm[i].checkClick(crawler.getX(), crawler.getY() + 64); // unten links

		wurm[i].checkClick(crawler.getX() + 64, crawler.getY() + 64); // unten rechts
	}
}
