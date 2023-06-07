# FruchMauro_Artista

Il programma simula la situazione di un artista da strada che esegue ritratti a dei clienti.
Esso utilizza i semafori come meccanismo di sincronizzazione tra i processi. Il semaforo "sedie" nel oggeto "Artista" garantisce che un solo numero limitato di clienti possa ocupare le sedie contemporaneamente. I semafori sono utili per controllare l'acceso alle risorse condivise e per garantire una sincronizzazione correta tra i processi.

 - ## Classe Artista

      La classe Artista gestisce le sedie disponibili attraverso l'implementazione di un semaforo e um tempo massimo di attesa. Inoltre si occupa anche di rappresentare l'artista che esegue un ritratto. L'Artista fornisce i seguenti metodi: 
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
		int t = rand.nextInt(5000) + 1000;									//Imposto il tempo del ritratto tra 1 e 6 secondi
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
      
```package myPackage;

//Classe per rappresentare un cliente

public class Cliente implements Runnable{
	
	private int id;
	private Artista a;
	
	//Costruttore
	
	public Cliente(int i, Artista art) {                     
		this.id = i;
		this.a = art;
	}
	
	public void run(){
		System.out.println("Cliente " + id  + " si avvicina all'artista. ");
		
		if(a.occupaSedia(this)) {                                                  			//Se ci sono sedie disponibili, il cliente occuppa una sedia
			System.out.println("Cliente " + id + " si sedie sulla sedia. ");
			a.eseguiRitratto(this);									     //Il cliente si fa fare il ritratto
			System.out.println("Cliente " + id + " ha completato il ritratto. ");
			a.liberaSedia(this);									     //Dopo aver finito il cliente lascia la sedia
			System.out.println("Cliente " + id + " lascia l'artista. ");
		}else {												//Altrimetni il cliente rinuncia al riratto in base al tempo di attesa
			System.out.println("Cliente " + id + " rinuncia al ritratto. ");	
		}
	}
}
```


- ## Classe Sedia

    La classe Sedia rappresenta una sedia disponibile per i clienti. Ha un identificatore "id" che permette di distingure le sedie tra loro.
      
    Esempio del codice:

```package myPackage;

//Classe per rappresentare una sedia

public class Sedia {
	private int id;
	
	public Sedia(int i) {
		setId(i);
	}
	
	public void setId(int s) {
		this.id = s;
	}
	
	public int getId() {
		return id;
	}
}
```


- ## Classe Demo

    La classe Demo contiene il Main che a sua volta rappresenta la classe principale del programma. All'interno del metodo "main", viene istanziato un oggetto di tipo "Artista" con un numero predefinito di sedie e un tempo massimo di attesa per le stesse.
      
    Esempio del codice:

```
package myPackage;

/*
 * Classe principale per eseguire il programma artista da strada
 * @author Fruch Mauro 4CIA
 */

public class Demo {
	
	public static void main(String[] args) {
		int numSedie = 4;         						//numero di sedie disponibili
		int tMax = 5000;						        //tempo massimo di attesa per una sedia					
		int numClienti = 10;							//numero di clienti che arrivano
	
		Artista a = new Artista(numSedie, tMax);
	
		for(int i = 0; i <= numClienti; i++) {
			Cliente c = new Cliente(i,a);
			Thread tC = new Thread(c);					//Thread del cliente
			tC.start();	
		
			try {
				Thread.sleep(2000);					//Intervallo di tempo tra l'arrivo di un cliente e l'altro
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
```

- ## Considerazioni aggiuntive

-> Vengono creati un certo numero di oggetti "Cliente" e per ognuno di essi viene creato un thread separato. I clienti vengono generati a intervalli casuali.

-> Ogni thread del cliente esegue il metodo "run()", che rappresenta il comportamento del cliente. Il cliente si avvicina all'artista, cerca di occupare una sedia tramite il metodo "occupaSedia" dell'artista. Se riesce a ottenere una sedia, si siede e fa eseguire il ritratto tramite il metodo "eseguiRitratto()". Alla fine, il cliente libera la sedia attraverso il metodo "liberaSedia()". Se un non riesce ad occupare una sedie entro un certo tempo massimo di attesa, esso rinuncia il ritratto.
    
    

		
		

    

