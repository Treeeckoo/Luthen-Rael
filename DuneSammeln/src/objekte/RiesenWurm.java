
package objekte;

import Sprites.WurmBild;

public class RiesenWurm extends object {

   
    private WurmBild wurm;
    private int meter;

  
    public RiesenWurm() {

        wurm = new WurmBild();
        wurm.setSichtbar(false);
    }

  
    public void WurmMeter() {
        meter = 10;
    }


    @Override
    public void checkClick(int mx, int my) {
    }

  
    public void ende(int x, int y) {

        wurm.setPos(x, y);
        wurm.setLayer(1);
        wurm.setSize(150, 150);
        wurm.setSichtbar(true);
    }


    public void setMeter(int a) {
        meter = a;
    }


    public int getMeter() {
        return meter;
    }

    @Override
    public void malen() {
        // TODO Auto-generated method stub
    }

    @Override
    public void aufDecken() {
        // TODO Auto-generated method stub
    }


    public void setSize(int a, int b) {
        wurm.setSize(a, b);
    }

    // Position
    public void setPoos(int x, int y) {
        wurm.setLayer(1);
        wurm.setPos(x - 31, y - 31);
    }
}
