# FruchMauro_Artista

Il programma simula la situazione di un artista da strada che esegue ritratti a dei clienti.
Esso utilizza i semafori come meccanismo di sincronizzazione tra i processi. Il semaforo "sedie" nel oggeto "Artista" garantisce che un solo numero limitato di clienti possa ocupare le sedie contemporaneamente. I semafori sono utili per controllare l'acceso alle risorse condivise e per garantire una sincronizzazione correta tra i processi.

 - ## Classe Artista

      La classe Artista gestisce le sedie disponibili attraverso l'implementazione di un semaforo e um tempo massimo di attesa. Inoltre si occupa anche di rappresentare l'artista che esegue un ritratto. L'Artista forniscee i seguenti metodi: 
    - occupaSedia -> per occupare una sedia;
    - liberaSedia -> per liberare una sedia;
    - eseguiRitratto -> per eseguire il ritratto.

    Esempio del codice:
    
    ```
    ```

    

