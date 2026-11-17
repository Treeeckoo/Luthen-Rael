package paket;
import basis.*;
import objekte.RiesenWurm;

public class UI {

    private RiesenWurm rw;
    private Rollbalken UIMeter;

    public UI(RiesenWurm rw) {

        this.rw = rw;

        UIMeter = new Rollbalken();
        UIMeter.setzePosition(150, 20);
        UIMeter.setzeGroesse(400, 30);
    }

    public void showMeter() {
        UIMeter.setzeWert(rw.getMeter()/1000);
        System.out.println(rw.getMeter()/1000);
    }
}