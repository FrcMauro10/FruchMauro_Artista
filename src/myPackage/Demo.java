package myPackage;

/*
 * Classe principale per eseguire il programma artista da strada
 * @author Fruch Mauro 4CIA
 */

public class Demo {
	
	public static void main(String[] args) {
		int numSedie = 4;         						//numero di sedie disponibili
		int tMax = 5000;								//tempo massimo di attesa per una sedia					
		int numClienti = 10;							//numero di clienti che arrivano
	
		Artista a = new Artista(numSedie, tMax);
	
		for(int i = 0; i <= numClienti; i++) {
			Cliente c = new Cliente(i,a);
			Thread tC = new Thread(c);					//Thread del cliente
			tC.start();	
		
			try {
				Thread.sleep(2000);						//Intervallo di tempo tra l'arrivo di un cliente e l'altro
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
