package ja;



import basis.*;


public class Panel {
	private Fenster fensti;
	private Quadrat[][] quadrat;
	
	
	
	
	
	public Tastatur Key;
public Panel() {
		fensti = new Fenster(960,1080);
		quadrat = new Quadrat[16][16];
		
		
		
		
		
		
		starteAlles();
		
		
		
	}
	

	public void starteAlles() {
	 
		 drawQuadrat();
	
	
		
	
	}
	private void drawQuadrat() {
		int counter =0;
		int counterQuadrat =0;
		int a =1;
		int b=1;
		int c=1;
		for(int i = 0; i < 16; i++) {
		
			
			quadrat[i][b] = new Quadrat();
			quadrat[i][b].setX(140*c);
			quadrat[i][b].setY(140*a);
			quadrat[i][b].setSize(100);
			quadrat[i][b].setColor(Farbe.rgb(Hilfe.zufall(1,255),Hilfe.zufall(1,255), Hilfe.zufall(1,255)));
	
				quadrat[i][b].Malen();
				counter++;
				counterQuadrat++;
			
				System.out.println("Objekte:"+counter);
				System.out.println("davon Quadrate:"+counterQuadrat);
				
			
			
			c++;
				
			if(c==5) {
				a++;
				c=1;
			}
		
			
				
		
			Hilfe.warte(1);			
			
		
	}
}
}

