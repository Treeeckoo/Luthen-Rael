
package objekte;

import Sprites.SpiceBild;

public class Spice extends object {

    private SpiceBild spice;

    public Spice() {

        super();

        spice = new SpiceBild();

        angecklickt = false;
        size = 40;
    }

    public void malen() {

        spice.setLayer(1);
        spice.setPos(x, y);
        spice.setSichtbar(false);
    }

    public void radieren() {

        if (!fertig) {
            spice.setSichtbar(false);
        }
    }

    @Override
    public void checkClick(int mx, int my) {

        if (mx > x && my > y && mx < x + size && my < y + size) {

            radieren();

            System.out.println("spice");

            angecklickt = true;
        }
    }

    @Override
    public void aufDecken() {

        spice.setSichtbar(true);
        fertig = true;
    }
}
