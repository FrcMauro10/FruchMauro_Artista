# FruchMauro_Artista

Il programma simula la situazione di un artista da strada che esegue ritratti a dei clienti.
Esso utilizza i semafori come meccanismo di sincronizzazione tra i processi. Il semaforo "sedie" nel oggeto "Artista" garantisce che un solo numero limitato di clienti possa ocupare le sedie contemporaneamente. I semafori sono utili per controllare l'acceso alle risorse condivise e per garantire una sincronizzazione correta tra i processi.

 - ## Classe Artista

      La classe Artista gestisce le sedie disponibili attraverso l'implementazione di un semaforo e um tempo massimo di attesa. Inoltre si occupa anche di rappresentare l'artista che esegue un ritratto. L'Artista forniscee i seguenti metodi: 
    - occupaSedia -> per occupare una sedia;
    - liberaSedia -> per liberare una sedia;
    - eseguiRitratto -> per eseguire il ritratto.

    Esempio del codice:
    
```package myPackage;
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
```

 - ## Classe Cliente

      La classe Cliente implementa l'interfaccia Runnable e rappresenta un cliente che desidera fare un ritratto. Ogni cliente ha un identificatore "id" e una referenza all'oggetto "Artista".
      
      Esempio del codie:
      
```
    

