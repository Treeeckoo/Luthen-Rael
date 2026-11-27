
package paket;

import java.awt.Color;

import Sprites.SpiceBild;
import basis.*;
import objekte.RiesenWurm;

public class UI {

    private RiesenWurm rw;
    private Rollbalken UIMeter;
    private Knopf leicht, mittel, schwer, Aufdecken, extract;
    private int wurmcount, spicecount;
    private boolean difselct, aufdecken, extractt;
    private int i, gramm;
    private ZahlenFeld zf, zf2, zf3;
    private SpiceBild sb;
    private TextFeld TF, TF2, GrammSpice;

    public UI(RiesenWurm rw) {

        this.rw = rw;

        UIMeter = new Rollbalken();

        leicht = new Knopf("leicht", 10, 100, 120, 75);
        mittel = new Knopf("mittel", 10, 200, 120, 75);
        schwer = new Knopf("schwer", 10, 300, 120, 75);
        extract = new Knopf("Extract",25, 525, 110, 30);
        Aufdecken = new Knopf("Show", 730, 20, 67, 25);

        UIMeter.setzePosition(150, 20);

        Feldsalat();

        difselct = false;
        extractt=false;
        aufdecken = false;

        UIMeter.setzeGroesse(400, 30);

        FarbenSetzen();

        int i = rw.getMeter();
        gramm = 0;

        sb = new SpiceBild();
        sb.setPos(30, 380);
        sb.setSize(100, 100);
        sb.setLayer(9);
    }

    private void FarbenSetzen() {

        leicht.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        leicht.setzeRand(Farbe.rgb(84, 79, 74), 2);
        leicht.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        mittel.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        mittel.setzeRand(Farbe.rgb(84, 79, 74), 2);
        mittel.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        schwer.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        schwer.setzeRand(Farbe.rgb(84, 79, 74), 2);
        schwer.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        Aufdecken.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        Aufdecken.setzeRand(Farbe.rgb(84, 79, 74), 2);
        Aufdecken.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        UIMeter.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        UIMeter.setzeRand(Farbe.rgb(84, 79, 74), 2);
        UIMeter.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        GrammSpice.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        GrammSpice.setzeRand(Farbe.rgb(84, 79, 74), 2);
        GrammSpice.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        zf.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        zf.setzeRand(Farbe.rgb(84, 79, 74), 2);
        zf.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        TF.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        TF.setzeRand(Farbe.rgb(84, 79, 74), 2);
        TF.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        zf2.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        zf2.setzeRand(Farbe.rgb(84, 79, 74), 2);
        zf2.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        TF2.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        TF2.setzeRand(Farbe.rgb(84, 79, 74), 2);
        TF2.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));

        zf3.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        zf3.setzeRand(Farbe.rgb(84, 79, 74), 2);
        zf3.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));
        
        extract.setzeHintergrundFarbe(Farbe.rgb(122, 115, 108));
        extract.setzeRand(Farbe.rgb(84, 79, 74), 2);
        extract.setzeSchriftFarbe(Farbe.rgb(255, 255, 255));
    }

    private void Feldsalat() {

        GrammSpice = new TextFeld(25, 480, 110, 40);
        GrammSpice.setzeSchriftGroesse(28);
        GrammSpice.setzeEditierbar(false);

        zf = new ZahlenFeld(555, 20, 27, 25);
        zf.setzeEditierbar(false);

        TF = new TextFeld(600, 20, 40, 25);
        TF.setzeEditierbar(false);
        TF.setzeText("Wurm");

        zf2 = new ZahlenFeld(640, 20, 20, 25);
        zf2.setzeEditierbar(false);

        TF2 = new TextFeld(660, 20, 40, 25);
        TF2.setzeEditierbar(false);
        TF2.setzeText("Spice");

        zf3 = new ZahlenFeld(700, 20, 20, 25);
        zf3.setzeEditierbar(false);
    }

    // Schwierigkeitsauswahl
    public void Difficulty() {

        if (leicht.wurdeGedrueckt()) {

            System.out.println("Leicht erkannt");
            setCounts(2, 15);
            difselct = true;

            mittel.gibFrei();
            schwer.gibFrei();
        }

        if (mittel.wurdeGedrueckt()) {

            System.out.println("Mittel erkannt");
            setCounts(4, 10);
            difselct = true;

            mittel.setzePosition(10, 100);
            leicht.gibFrei();
            schwer.gibFrei();
        }

        if (schwer.wurdeGedrueckt()) {

            System.out.println("Schwer erkannt");
            setCounts(6, 6);
            difselct = true;

            schwer.setzePosition(10, 100);
            leicht.gibFrei();
            mittel.gibFrei();
        }
    }

    public void setTF(String b) {
        TF.setzeText(b);
    }

    public void setZFs(int a, int b) {
        zf2.setzeZahl(a);
        zf3.setzeZahl(b);
    }

    public int getZF2() {
        return (int) zf2.zahl();
    }

    public int getZF3() {
        return (int) zf3.zahl();
    }

    public void setaufdeck(boolean b) {
        aufdecken = b;
    }

    public void setCounts(int a, int b) {
        wurmcount = a;
        spicecount = b;
    }

    public int getWurmcount() {
        return wurmcount;
    }

    public int getSpicecount() {
        return spicecount;
    }

    public void showMeter() {

        UIMeter.setzeWert(rw.getMeter() / 1000);

        if (rw.getMeter() / 1000 >= i / 1000 + 1) {

            System.out.println(rw.getMeter() / 1000);
            i = rw.getMeter();
            zf.setzeZahl(rw.getMeter() / 1000);
        }
    }

    public boolean getDifSelect() {
        return difselct;
    }

    public boolean getaufdeck() {
        return aufdecken;
    }

    public void setDifSelect(boolean ifselct) {
        ifselct = difselct;
    }

    public void setGramm(int g) {

        gramm = g;

        if (g < 1000) {
            GrammSpice.setzeText(g + "g");
        }

        if (g > 1000) {
            GrammSpice.setzeText(g / 1000 + "." + (g - 1000) + "kg");
        }
    }

    public int getGramm() {
        return gramm;
    }

    
    public boolean Show() {

        if (Aufdecken.wurdeGedrueckt()) {
            aufdecken = true;
        }

        return aufdecken;
    }
    public boolean Extract() {
    	if(extract.wurdeGedrueckt()) {
    		extractt = true;
    	}
    	return extractt;
    	
    }
}
