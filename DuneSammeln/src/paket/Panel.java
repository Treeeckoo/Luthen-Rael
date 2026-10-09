package paket;

import objekte.*;
import basis.*;
public class Panel {
	private Wurm[] wurm;	
	private Spice[] spice;
	private Crawler crawler;
	private Fenster fenster;
	private Knopf ende;
	private Maus maus;
	private Tastatur tastatur;
	
	
	
	public Panel() {
		
		fenster = new Fenster("DuneSpiel", 1240, 860);
		ende = new Knopf("Ende",20,20,80,40);
		tastatur = new Tastatur();
		crawler = new Crawler();
		wurm = new Wurm[5];
		spice = new Spice[5];
		maus = new Maus();
		
		starten();
	}
	
	public void starten() {
		SpielfeldMalen();
		loop();
	}
	
	public void SpielfeldMalen() {
		for(int i =0;i<5;i++) {
			wurm[i] = new Wurm();
			wurm[i].setPos(Hilfe.zufall(200, 800), Hilfe.zufall(200, 800));
			wurm[i].malen();
			
			spice[i] = new Spice();
			spice[i].setPos(Hilfe.zufall(200, 800), Hilfe.zufall(200, 800));
			spice[i].malen();
			
			
			crawler.malen();
			
		}
	}
	
	
	public void loop() {
		while(!ende.wurdeGedrueckt()) {
			Hilfe.warte(1);
			if(maus.istGedrueckt()) {
				for(int i=0;i<5;i++) {
					Clicke(i);
					
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
			
			
			
			
			
			
			
			
			
			
			
			if(ende.wurdeGedrueckt()) {
				fenster.gibFrei();
				fenster.setzeSichtbar(false);
			}
		}
	}

	public void Clicke(int i) {
			wurm[i].checkClick(crawler.getX(), crawler.getY());			 // oben links
			
			wurm[i].checkClick(crawler.getX()+50, crawler.getY());	// oben rechts
			
			wurm[i].checkClick(crawler.getX(), crawler.getY()+50);		// unten links
			
			wurm[i].checkClick(crawler.getX()+50, crawler.getY()+50);	// unten rechts
			
			spice[i].checkClick(crawler.getX(), crawler.getY());			 // oben links
			
			spice[i].checkClick(crawler.getX()+50, crawler.getY());	// oben rechts
			
			spice[i].checkClick(crawler.getX(), crawler.getY()+50);		// unten links
			
			spice[i].checkClick(crawler.getX()+50, crawler.getY()+50);	// unten rechts
		}
}
