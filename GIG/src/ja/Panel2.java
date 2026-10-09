package ja;



import basis.*;
import java.awt.Color;

public class Panel2 {
	private Fenster fensti;
	private Quadrat[][] quadrat;
	private Kreis kreis;
	private Knopf enes;
	private Maus tom;
	private Color fabi;
	private Bilder bild;
	
	
	
	
	public Tastatur Key;
public Panel2() {
	
		fensti = new Fenster(800,855);
		quadrat = new Quadrat[16][16];
		kreis = new Kreis();
		enes= new Knopf("BomberEnes",72,775 ,110,50);
		tom= new Maus();
		fabi= Color.black;
		bild= new Bilder();
		
		
		
		
		
		starteAlles();
		
		
		
	}
	

	public void starteAlles() {
		 Operation();
		 drawQuadrat();

		 
		 Redo();
		 
		
	
	}
	private void drawQuadrat() {
		int counter =0;
		int counterQuadrat =0;
		
		for(int i = 0; i < 5; i++) {
			for(int b = 0; b < 5; b++) {
				counter++;
				counterQuadrat++;
				if(counter==2) {
					counter=0;
					fabi = Farbe.rgb(Hilfe.zufall(95,235),Hilfe.zufall(95,235), Hilfe.zufall(95,235));
				}
				
			quadrat[i][b] = new Quadrat();
			quadrat[i][b].setX(75 + 140*b);
			quadrat[i][b].setY(75 +140*i);
			quadrat[i][b].setSize(100);
			quadrat[i][b].setColor(fabi);
	
				quadrat[i][b].Malen();
		
				System.out.println("Objekte:"+counter);
				System.out.println("davon Quadrate:"+counterQuadrat);
			}
			Hilfe.warte(1);			
			}
			}			
		
	

	public void Redo() {

		while(!enes.wurdeGedrueckt()){
			Hilfe.warte(1);		
			if(tom.istGedrueckt()) {
				for(int i = 0; i < 5; i++) {
					for(int b = 0; b < 5; b++) {
					quadrat[i][b].BorderEnes(tom.hPosition(), tom.vPosition());
					
					}
			}
				
			}
			if(enes.wurdeGedrueckt()) {
				fensti.gibFrei();
				fensti.setzeSichtbar(false);
			}
			
		}
	}
	public void Operation(){
		fensti.setzeHintergrundFarbe(Farbe.rgb(246, 243, 232));
		fensti.setzeTitel("Das BomberQuadrat");
		enes.setzeHintergrundFarbe(Farbe.rgb(219, 218, 208));
		
	}
}

