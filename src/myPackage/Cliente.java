package myPackage;

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
		
		if(a.occupaSedia(this)) {                                                  				//Se ci sono sedie disponibili, il cliente occuppa una sedia
			System.out.println("Cliente " + id + " si sedie sulla sedia. ");
			a.eseguiRitratto(this);																//Il cliente si fa fare il ritratto
			System.out.println("Cliente " + id + " ha completato il ritratto. ");
			a.liberaSedia(this);																//Dopo aver finito il cliente lascia la sedia
			System.out.println("Cliente " + id + " lascia l'artista. ");
		}else {																					//Altrimetni il cliente rinuncia al riratto in base al tempo di attesa
			System.out.println("Cliente " + id + " rinuncia al ritratto. ");	
		}
	}
}


		
		

