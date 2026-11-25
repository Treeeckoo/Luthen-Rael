package paket;
import basis.*;
import objekte.RiesenWurm;

public class UI {

    private RiesenWurm rw;
    private Rollbalken UIMeter;
    private Knopf leicht, mittel, schwer;
    private int wurmcount, spicecount;
    private boolean difselct;

    public UI(RiesenWurm rw) {
   
        this.rw = rw;

        UIMeter = new Rollbalken();
        leicht = new Knopf("leicht", 10, 100, 125, 75);
        mittel = new Knopf("mittel", 10, 200, 125, 75);
        schwer = new Knopf("schwer", 10, 300, 125, 75);
        UIMeter.setzePosition(150, 20);
        difselct = false;
        UIMeter.setzeGroesse(400, 30);
    }
    public void Difficulty() {
        if (leicht.wurdeGedrueckt()) {
            System.out.println("Leicht erkannt");
            setCounts(2,15);
            difselct = true;
        }

        if (mittel.wurdeGedrueckt()) {
            System.out.println("Mittel erkannt");
            setCounts(4,10);
            difselct = true;
        }

        if (schwer.wurdeGedrueckt()) {
            System.out.println("Schwer erkannt");
            setCounts(6,6);
            difselct = true;
        }
    }

    public void setCounts(int a,int b) {
		wurmcount =a;
		spicecount = b;
	}
    public void showMeter() {
		UIMeter.setzeWert(rw.getMeter() / 1000);
		System.out.println(rw.getMeter() / 1000);
}
    public int getWurmcount() {
    	return wurmcount;
    }
    public int getSpicecount() {
    	return spicecount;
    }
    public boolean getDifSelect() {
    	return difselct;
    }
}
	
