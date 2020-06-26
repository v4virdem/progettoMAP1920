# SleepGame - avventura testuale 

**ESAME** : Metodi Avanzati di Programmazione

**STUDENTI** : Valentina Vetrugno e Luigi Matera

**CASO DI STUDIO** : Sviluppo di un'avventura testuale utilizzando il linguaggio Java.


1. **INTRODUZIONE**

   SleepGame è un'avventura testuale sviluppata in Java 11. Si tratta di un gioco all'interno del quale il giocatore verrà catapultato in un sogno, dove esplorerà una casa fino a capire che in realtà si trova in un sogno. Solo trovando tutti gli oggetti necessari potrà svegliarsi da tutto questo.

   Il giocatore dovrà immettere i comandi da tastiera.
   E' possibile muoversi nelle stanze, prendere oggetti, osservarli, leggerli e molto altro. 

2. **DETTAGLI SCELTE PROGETTUALI EFFETTUATE**

   Il codice è stato strutturato in 4 package, ognuno con una determinata funzione.
   Nel primo (**baseClasses**) troviamo Game, Item e Parser (classi astratte) , Room e Move che faranno da base nel creare una qualsiasi nuova avventura.
   *Es.* Grazie al fatto che Game sia astratta e che il metodo *doMove()* sia astratto ci permette di averne differenti implementazioni in base alle necessità dell'avventura creata.
   Item abbiamo deciso di sfruttarlo come base per tutti i tipi di oggetti che avranno funzioni differenti.
   Infine Parser è una classe astratta che fornisce il metodo parse() da implementare in base alla lingua con cui l'utente dovrà interagire con il gioco.

   Nel successivo (**command**) troviamo due classi che si occupano di definire una il tipo di comandi che potranno essere effettuati, la seconda da effettivamente un nome ed eventuali alias al comando da utilizzare. 
   CommandType è stata pensata per permettere al gioco di non avere dipendenze linguistiche sui comandi. 
   *Es.* il comando "NORD" verrà associato al comando di tipo "NORTH" presente nella classe enumerativa CommandType. In questo modo il nostro comando potrà avere un qualsiasi nome, ma sarà pur sempre un comando di tipo "NORTH" e quindi avrà il comportamento che avranno tutti i comandi di questo tipo.

   Andando avanti possiamo trovare  **item**, nel quale vi sono le specializzazioni di tutti gli oggetti che derivano dalla classe Item descritta in precedenza.

   Nell'ultimo package (**sleepGame**) troviamo tutte le classe che rendono possibile l'esecuzione del nostro gioco. 
   In particolare, AppMain è la classe che permette al gioco di essere avviato e si occupa dell'interazione programma-utente.
   ItaParser, che eredita da Parser, implementa il metodo parse() per la lingua Italiana.

   Troviamo anche SleepGame, che estende Game, nel quale è stato effettivamente definito tutto ciò che avremo nel gioco : stanze (con nome, descrizione), oggetti (con nome, descrizione e gli alias attraverso i quali si può interagire con essi), comandi(nome e alias) e come vengono effettuate la varie mosse attraverso il doMove().

   Infine è stata creata SafeBox , una finestra che mostra un tastierino numerico e permette all'utente di inserire la password della cassaforte presente nel gioco, scomparirà nel momento in cui sarà scritta la password corretta o verrà chiusa la finestra manualmente.

3. **DETTAGLI IMPLEMENTATIVI SIGNIFCATIVI**

   Per noi l'implementazione del metodo doMove() in SleepGame è stata molto importante perchè con essa è stato possibile permettere al giocatore di muoversi e compiere le varie azioni.

   Questo metodo riceve una mossa decodificata da ItaParser contenente : il tipo di mossa da effettuare e un'eventuale oggetto su cui eseguirla.

   Perciò è stato diviso in tre sezioni principali :

   - la prima sezione si occupa dell'eventualità in cui il tipo di mossa sia nulla. In questo caso si avrà un messaggio di errore;

   - la seconda si occupa del caso in cui riceveremo solo un comando (senza un oggetto). Potremo quindi muoverci solo se nella direzione definita vi sia una stanza, osservare nella stanza in cui ci troviamo ricevendo la descrizione dettagliata della stanza, oppure guardare la mappa della casa da noi creata;

   - la terza si occupa dell'eventualità in cui in input abbiamo sia un comando , che un oggetto su cui effettuarlo. In questo caso ogni comando avrà un suo tipo di controlli e modo per essere effettuato. 

     *Es* Nel caso in cui ci troviamo nella stanza Sgabuzzino e vogliamo aprire la cassaforte, quello che accadrà, dando il comando da tastiera "apri cassaforte", sarà: 

     - la mossa verrà parsata ed arriverà in input come comando 'apri' che è di tipo OPEN e l'oggetto cassaforte che fa parte degli oggetti definiti apribili(OpenableItem)
     - verranno quindi saltate le prime due sezioni che comprendono i casi in cui non vi siano oggetti nel comando
     - controlla che l'oggetto da aprire non sia lo zaino (che nel nostro gioco rappresenta l'inventario)
     - controlla che l'oggetto sia di tipo apribile(OpenableItem)
     - controlla che l'oggetto non sia già stato aperto
     - se stato aperto viene stampato un messaggio che avvisa l'utente che l'oggetto è già stato aperto. 
       Se l'oggetto aperto è la cassaforte mostra la lista degli oggetti presenti in essa.
     - se l'oggetto non è stato aperto ed è proprio la cassaforte, appare una finestra nella quale è possibile inserire la password per aprirla.
     - la finestra rimarrà aperta fino a che non verrà inserita la password corretta oppure l'utente non decidesse di chiuderla per continuare il gioco.
