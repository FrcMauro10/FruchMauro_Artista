package myPackage;
import java.util.Random;
import java.util.concurrent.Semaphore;

//Classe che rappresenta l'artista

class Artista{
	private Semaphore sedie;
	private int maxTempAtessa;
	
	//Costruttore
	
	public Artista(int numSedie, int tempMaX) {                
		sedie = new Semaphore(numSedie);
		this.maxTempAtessa = tempMaX;
	}
	
	public boolean occupaSedia(Cliente c) {										//Metodo per occupare una sedia																	
		if(sedie.tryAcquire(maxTempAtessa)) {									//Il cliente cerca di occupare una sedia
			System.out.println("Il cliente ha occupato una sedia. ");
			return true;
		}else {
			return false;
		}
	}
	
	public void liberaSedia(Cliente c) {										//Metodo per liberare una sedia
		sedie.release();														
		System.out.println("Il cliente ha lasciato la sedia. ");
		
	}
	
	public void eseguiRitratto(Cliente c) {										//Metodo per eseguire un ritratto
		Random rand = new Random();
		int t = rand.nextInt(5000) + 1000;										//Imposto il tempo del ritratto tra 1 e 6 secondi
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


