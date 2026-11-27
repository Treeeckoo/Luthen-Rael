
package paket;

import objekte.*;
import Sprites.BGBIld;
import Sprites.MainBild;
import Sprites.RoverBild;
import Sprites.SpiceBild;
import basis.*;

public class Panel {

	
	private Wurm[] wurm;
	private Spice[] spice;
	private object[] gegenstaende;
	private Crawler crawler;
	private Fenster fenster;
	private Knopf ende;
	private Maus maus;
	private Tastatur tastatur;
	private RoverBild rover;
	private RiesenWurm riesenwurm;
	private UI ui;
	private BGBIld bg;

	private String objects;


	public Panel() {
		fenster = new Fenster("DuneSpiel", 800, 560);
		ende = new Knopf("Ende", 20, 20, 80, 40);
		farben();
		tastatur = new Tastatur();

		riesenwurm = new RiesenWurm();
		String objects = "Wurm ";
		ui = new UI(riesenwurm);

		maus = new Maus();
		bg = new BGBIld();
		bg.setSichtbar(true);
		bg.setPos(1, 1);
		bg.setLayer(10);
		starten();
	}

	
	private void farben() {
		ende.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
		ende.setzeRand(Farbe.rgb(84, 79, 74),2);ende.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));
		
	}


	public void starten() {
		Schwierigkeit();
		SpielfeldMalen();
		loop();
	}

	// Schwierigkeitsauswahl
	public void Schwierigkeit() {
		while (ui.getDifSelect() != true) {
			ui.Difficulty();
			Hilfe.warte(1);
		}
	}

	// Spielfeld
	public void SpielfeldMalen() {

		int a, b, c, d, e, f;
		e = ui.getWurmcount();
		f = ui.getSpicecount();

		crawler = new Crawler();
		wurm = new Wurm[e];
		spice = new Spice[f];

		gegenstaende = new object[e + f];
		String objects = "Wurm " + e + " Spice " + f;
		ui.setZFs(e, f);
		System.out.println(objects);

		// Wurm
		for (int i = 0; i < e; i++) {

			wurm[i] = new Wurm();
			gegenstaende[i] = wurm[i];

			wurm[i].setPos(Hilfe.zufall(234, 631), Hilfe.zufall(149, 386));

			for (int j = 0; j < i; j++) {

				a = wurm[j].getX();
				b = wurm[j].getY();

				c = wurm[i].getX();
				d = wurm[i].getY();

				if (a - c >= -128 && a - c <= 128 && b - d >= -128 && b - d <= 128) {

					wurm[i].setPos(Hilfe.zufall(234, 631), Hilfe.zufall(149, 386));

					j = -1;
				}
			}
		}

		// Spice
		for (int i = 0; i < f; i++) {

			spice[i] = new Spice();
			gegenstaende[e + i] = spice[i];

			spice[i].setPos(Hilfe.zufall(170, 700), Hilfe.zufall(85, 490));

			// Abstandskontrolle
			for (int j = 0; j < i; j++) {

				a = spice[j].getX();
				b = spice[j].getY();

				c = spice[i].getX();
				d = spice[i].getY();

				if (a - c >= -60 && a - c <= 60 && b - d >= -60 && b - d <= 60) {

					spice[i].setPos(Hilfe.zufall(170, 700), Hilfe.zufall(85, 490));

					j = -1;
				}
			}

			
			for (int j = 0; j < e; j++) {

				a = wurm[j].getX() - 64;
				b = wurm[j].getY() - 64;

				c = spice[i].getX();
				d = spice[i].getY();

				if (c < a + 100 && c + 32 > a && d < b + 100 && d + 32 > b) {

					spice[i].setPos(Hilfe.zufall(170, 700), Hilfe.zufall(85, 490));

					j = -1;
				}
			}
		}

		
		// Polymorphie damit Sie etwas drin haben, bin zu faul alles auszutauschen.
		for (int i = 0; i < gegenstaende.length; i++) {
			gegenstaende[i].malen();
		}

		crawler.malen();
	}

	// Mausklick
	private boolean was_pressed = false;

	
	public void loop() {

		while (!ende.wurdeGedrueckt()) {

			Hilfe.warte(1);

			boolean pressed = maus.istGedrueckt();

		
			if (pressed && !was_pressed) {

				// Spice einsammeln
				for (int i = 0; i < spice.length; i++) {
					ClickeSpice(i);

					if (spice[i].getAngeklickt() == true && spice[i].getfertig() != true) {

						spice[i].setfertig(true);
						spice[i].aufDecken();
						ui.setZFs(ui.getZF2(), ui.getZF3() - 1);
						ui.setGramm(ui.getGramm() + 200);
					}
				}

				// Wurm anklicken
				for (int i = 0; i < wurm.length; i++) {
					ClickeWurm(i);

					if (wurm[i].getAngeklickt() == true && wurm[i].getfertig() != true) {

						wurm[i].setfertig(true);
						wurm[i].aufDecken();
						System.out.println("wurm");
						riesenwurm.setMeter(riesenwurm.getMeter() + 17500);
						ui.setZFs(ui.getZF2() - 1, ui.getZF3());
						ui.setGramm(ui.getGramm() - (Hilfe.zufall(0,200)));
					}
				}
			}

			was_pressed = pressed;

			// Bewegung
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

			// Meter
			if (riesenwurm.getMeter() <= 100000) {

				riesenwurm.setMeter(riesenwurm.getMeter() + 1);

				ui.showMeter();
			} else {
				riesenwurm.ende((crawler.getX() - 64), (crawler.getY() - 64));

				Hilfe.warte(1000);
				fenster.gibFrei();
				fenster.setzeSichtbar(false);
			}

			// Spielende anzeigen
			if (ui.Show()== true) {
				for (int i = 0; i < gegenstaende.length; i++) {
					gegenstaende[i].aufDecken();
					
				}
				if(ui.getaufdeck()) {
				System.out.println("Spiel terminiert");	
				}
				ui.setaufdeck(false);
						}
			if (ui.Extract()==true) {
				crawler.Extract();
				
			}

			// Spiel beenden
			if (ende.wurdeGedrueckt()) {
				for (int i = 0; i < gegenstaende.length; i++) {
					gegenstaende[i].aufDecken();
				}

				riesenwurm.ende((crawler.getX() - 64), (crawler.getY() - 64));

				for (int s = 120; s > 5; s--) {
					Hilfe.warte(90);

					crawler.malen();
					riesenwurm.setSize(s, s);

					if (s > 115) {

						riesenwurm.setPoos(crawler.getX() + 2, crawler.getY() + 2);
						crawler.setZ(0);

					} else {
						crawler.setZ(7);
						crawler.setSicht(false);

						if (s < 100 && s > 60) {
							riesenwurm.setPoos(crawler.getX() + (-s + 100), crawler.getY() + (-s + 100));
						}

						if (s < 30) {
							riesenwurm.setPoos(crawler.getX() + (-s + 60), crawler.getY() + (-s + 60));
						}
					}
				}

				fenster.gibFrei();
				fenster.setzeSichtbar(false);
			}
		}
	}

	
	public void ClickeSpice(int i) {

		spice[i].checkClick(crawler.getX() + 22, crawler.getY() + 18);
		spice[i].checkClick(crawler.getX() + 40, crawler.getY());
		spice[i].checkClick(crawler.getX(), crawler.getY() + 40);
		spice[i].checkClick(crawler.getX() + 40, crawler.getY() + 40);
	}

	
	public void ClickeWurm(int i) {

		wurm[i].checkClick(crawler.getX() + 18, crawler.getY() + 18);
		wurm[i].checkClick(crawler.getX() + 47, crawler.getY());
		wurm[i].checkClick(crawler.getX(), crawler.getY() + 38);
		wurm[i].checkClick(crawler.getX() + 47, crawler.getY() + 38);
	}

	
	public String getObjocts() {
		return objects;
	}
}
