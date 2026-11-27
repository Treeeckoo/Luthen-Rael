
package objekte;

import Sprites.WurmBild;

public class Wurm extends object {

    private WurmBild wurm;

    public Wurm() {

        super();

        wurm = new WurmBild();

        angecklickt = false;
    }

    public void malen() {

        wurm.setLayer(1);
        wurm.setPos(x - 31, y - 31);
        wurm.setSichtbar(false);
    }

    public void radieren() {

        if (!fertig) {
            wurm.setSichtbar(false);
        }
    }

    @Override
    public void checkClick(int mx, int my) {

        int radius = size / 2;

        int dx = mx - x;
        int dy = my - y;

        if (dx * dx + dy * dy <= radius * radius) {

            radieren();
            angecklickt = true;
        }
    }

    @Override
    public void aufDecken() {

        wurm.setSichtbar(true);
        fertig = true;
    }
}
