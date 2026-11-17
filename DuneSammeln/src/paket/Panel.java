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
	private RiesenWurm riesenwurm;
	private UI ui;

	public Panel() {

		fenster = new Fenster("DuneSpiel", 800, 560);
		ende = new Knopf("Ende", 20, 20, 80, 40);
		tastatur = new Tastatur();
		crawler = new Crawler();
		riesenwurm = new RiesenWurm();

		wurm = new Wurm[4];
		spice = new Spice[10];

		ui = new UI(riesenwurm);

		maus = new Maus();

		starten();
	}

	public void starten() {
		SpielfeldMalen();
		loop();
	}

	public void SpielfeldMalen() {

		int a, b, c, d;

		// WÜRMER
		for (int i = 0; i < 4; i++) {

			wurm[i] = new Wurm();

			wurm[i].setPos(Hilfe.zufall(234, 631), Hilfe.zufall(149, 386));

			for (int j = 0; j < i; j++) {

				a = wurm[j].getX();
				b = wurm[j].getY();

				c = wurm[i].getX();
				d = wurm[i].getY();

				if (a - c >= -128 && a - c <= 128 &&			
				    b - d >= -128 && b - d <= 128) {

					wurm[i].setPos(Hilfe.zufall(234, 631), Hilfe.zufall(149, 386));

					j = -1;
				}
			}

			wurm[i].malen();
		}

		for (int i = 0; i < 10; i++) {

			spice[i] = new Spice();

			spice[i].setPos(Hilfe.zufall(170, 700), Hilfe.zufall(85, 490));

			
			for (int j = 0; j < i; j++) {

				a = spice[j].getX();
				b = spice[j].getY();

				c = spice[i].getX();
				d = spice[i].getY();

				if (a - c >= -60 && a - c <= 60 && 
					b - d >= -60 && b - d <= 60) {

					spice[i].setPos(Hilfe.zufall(170, 700), Hilfe.zufall(85, 490));

					j = -1;
				}
			}

			for (int j = 0; j < 4; j++) {

				a = wurm[j].getX() - 64;
				b = wurm[j].getY() - 64;

				c = spice[i].getX();
				d = spice[i].getY();

				if (c < a + 100 && c + 32 > a &&
					d < b + 100 && d + 32 > b) {

					spice[i].setPos(Hilfe.zufall(170, 700), Hilfe.zufall(85, 490));

					j = -1;
				}
			}

			spice[i].malen();
		}

		crawler.malen();
	}

	private boolean was_pressed = false;
	public void loop() {

		while (!ende.wurdeGedrueckt()) {

			Hilfe.warte(1);
			
			boolean pressed = maus.istGedrueckt();
			
			if (pressed && !was_pressed) {

				for (int i = 0; i < 10; i++) {
					ClickeSpice(i);
				}

				for (int i = 0; i < 4; i++) {
					ClickeWurm(i);
					if (wurm[i].getAngeklickt()==true && wurm[i].getfertig()!= true) {
						
						wurm[i].setfertig(true);
						 System.out.println("wurm");
						 riesenwurm.setMeter(riesenwurm.getMeter()+12500);
						
					}
					
					
				}
			}
			
			was_pressed = pressed;

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
			
			if (riesenwurm.getMeter()<=200000) {
				
				riesenwurm.setMeter(riesenwurm.getMeter()+1);

				ui.showMeter();
			}else {
				riesenwurm.ende((crawler.getX()-64), (crawler.getY()-64));
			}

			if (ende.wurdeGedrueckt()) {
				
				riesenwurm.ende((crawler.getX()-64), (crawler.getY()-64));
				
				Hilfe.warte(1000);
				fenster.gibFrei();
				fenster.setzeSichtbar(false);
			}
		}
	}

	public void ClickeSpice(int i) {

		spice[i].checkClick(crawler.getX(), crawler.getY());
		spice[i].checkClick(crawler.getX() + 57, crawler.getY());
		spice[i].checkClick(crawler.getX(), crawler.getY() + 48);
		spice[i].checkClick(crawler.getX() + 57, crawler.getY() + 48);
	}

	public void ClickeWurm(int i) {

		wurm[i].checkClick(crawler.getX(), crawler.getY());
		wurm[i].checkClick(crawler.getX() + 57, crawler.getY());
		wurm[i].checkClick(crawler.getX(), crawler.getY() + 48);
		wurm[i].checkClick(crawler.getX() + 57, crawler.getY() + 48);
	}

	
	
	
}