package ja;

public class KotenderEnes {

	private int Punkte1;
	private int Punkte2;

	private boolean S1istdran;
	private boolean S2istdran;

	public KotenderEnes() {

		Punkte1 = 0;
		Punkte2 = 0;

		S1istdran = true;
		S2istdran = false;
	}

	public void wechsleSpieler() {

		if (S1istdran) {

			S1istdran = false;
			S2istdran = true;

		} else {

			S2istdran = false;
			S1istdran = true;
		}
	}

	public void plusPunkt() {

		if (S1istdran) {

			Punkte1++;

		} else if (S2istdran) {

			Punkte2++;
		}
	}

	public boolean getSpieler1() {
		return S1istdran;
	}

	public boolean getSpieler2() {
		return S2istdran;
	}

	public int getPunkte1() {
		return Punkte1;
	}

	public int getPunkte2() {
		return Punkte2;
	}
}
