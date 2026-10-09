package ja;

import basis.*;

public class Bilder {
private Bild Drache;
private Bild Drache2;
private Bild Drache3;

private Bild Monte;
private Bild Monte2;
private Bild Monte3;

private Bild Tim;
private Bild Tim2;
private Bild Tim3;

private Bild Redo;
private Bild Redo2;
private Bild Redo3;

public Bilder() {
Drache= new Bild("/Bilder/Drache.png");
Drache.setzeSichtbar(false);
Drache2= new Bild("/Bilder/Drache2.png");
Drache2.setzeSichtbar(false);
Drache3= new Bild("/Bilder/Drache3.png");
Drache3.setzeSichtbar(false);

Monte= new Bild("/Bilder/MontanaBlack.png");
Monte.setzeSichtbar(false);
Monte2= new Bild("/Bilder/Monte.png");
Monte2.setzeSichtbar(false);
Monte3= new Bild("/Bilder/Monte2.png");
Monte3.setzeSichtbar(false);

Redo= new Bild("/Bilder/Redo.png");
Redo.setzeSichtbar(false);
Redo2= new Bild("/Bilder/Redo2.png");
Redo2.setzeSichtbar(false);
Redo3= new Bild("/Bilder/Redo3.png");
Redo3.setzeSichtbar(false);

Tim= new Bild("/Bilder/Tim.png");
Tim.setzeSichtbar(false);
Tim2= new Bild("/Bilder/Tim2.png");
Tim2.setzeSichtbar(false);
Tim3= new Bild("/Bilder/Tim3.png");
Tim3.setzeSichtbar(false);
	}
public void zeigeBild() {
	
	
	Drache.ladeBild();
	Drache.setzeGroesse(200,200);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
