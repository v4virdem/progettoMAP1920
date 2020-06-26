package sleepGame;

import baseClasses.Game;
import baseClasses.Item;
import baseClasses.Move;
import baseClasses.Room;
import command.Command;
import command.CommandType;
import item.OpenableItem;
import item.PickubleItem;
import item.PushableItem;
import item.ReadableItem;
import item.UselessItem;
import item.WearableItem;

/*
 * Classe che estende Game ed inizializza il gioco, in particolare "SleepGame"
 * «Control»
 */
public class SleepGame extends Game {
	@Override
	public void init() {

		//Creazione di tutte le stanze
		Room hall = new Room(1, "Ingresso", 
				"Sei all'INGRESSO"
						+ "\nC'è un tappeto, un porta-ombrelli, e un tavolino...",
						"Sotto al tavolino c'è un gatto bizzarro. "
								+ "\nÉ un gatto-corno!? Ha un solo orecchio in testa, ma com'è possibile? "
								+ "\nOh, guarda! Sta vomitando qualcosa...Un sveglia..?");
		Room hallway_1 = new Room(2, "Corridoio", 
				"Sei nel CORRIDOIO\nMA che strano corridoio è mai questo?",
				"C'è solo un bottone rosso.");
		Room kitchen = new Room(3, "Cucina",
				"Sei in CUCINA "
						+ "\nÉ una giornata soleggiata,"
						+ " \nC'è un buon odore di caffè, qualcuno deve averlo appena preparato...",
						"Sembra una mattina come tante,\nMa noti un biglietto accartocciato sul tavolo.");
		Room balcony = new Room(4, "Balcone",
				"Sei sul BALCONE "
						+ "\nIl cielo è proprio strano oggi! "
						+ "\nIl mattino e la notte sembrano fondersi. Dovresti preoccuparti?", 
						"C'è dell'immondizia.");
		Room livingRoom = new Room(5, "Salotto",
				"Sei nel SALOTTO "
						+ "\nC'è un tappeto e un vaso di fiori che stanno appassendo, che peccato...", 
						"Non l'avevi vista? c'è anche una TV in fondo alla stanza, "
								+ "\nMamma la guardava sempre, chissà dov'è ora...");
		Room bedroom_1 = new Room(6, "Stanza da letto",
				"\nSei nella tua STANZA DA LETTO e ti sei appena svegliato. "
						+ "\nSei a terra e il letto, la finestra, la porta e tutto quello che ti circonda"
						+ "\nSembrano almeno cinque volte più grandi di te."
						+ "\nProva a guardarti intorno.",
						"Non c'è nulla di particolare, "
								+ "\nApparte uno strano zaino vicino la porta, prova ad aprirlo.");
		Room hallway_2 = new Room(7, "Corridoio", 
				"Sei nel CORRIDOIO "
						+ "\nCi sono solo due porte e sui muri ci sono i soliti noiosi vecchi quadri.", 
						"Non c'è nulla di strano.");
		Room bathroom = new Room(8, "Bagno", 
				"Sei nel BAGNO "
						+ "\nC'è la solita tavoletta alzata, e lo specchio macchiato.",
						"C'è qualcosa di strano in quella finestra chiusa, "
								+ "\nChissà se il pulsante per aprirla funziona ancora...");
		Room storageRoom= new Room(9, "Sgabuzzino", 
				"Sei nello SGABUZZINO "
						+ "\nCi sono scope, scatoloni e secchi.", 
						"Dietro alle scope noti una cassa forte "
								+ "\nPotresti 'prendere in prestito' tutti i soldi di papà, "
								+ "\nma quale sarà la password?");
		Room office = new Room(10, "Studio",
				"Sei nello STUDIO di tuo padre "
						+ "\nDi solito non ti è permesso entrare qui! "
						+ "\nSe ti vedesse,ti potrebbe picchiare! "
						+ "\n('BRUTTO BACAROSPO!',la sua voce rimbomba nello studio).",
						"Ti guardi intorno e sul PC di tuo padre è attaccato un post-it.");
		Room hallway_3 = new Room(11, "Corridoio",
				"Sei nel CORRIDOIO "
						+ "\nMa quanto è lungo questo corridoio?" , 
						"C'è una mosca che gira intorno al lampadario"
								+ "\nGuardando bene c'è un porticina minuscola!"
								+ "\nPUOI ANDARE: in tutte le direzioni");
		Room secretRoom = new Room(12, "Stanza segreta" ,
				"Hai trovato una STANZA SEGRETA! ma c'è sempre stata?",
				"Non ci sono finestre o mobili, "
						+ "\nAl centro della stanza ci sono degli ingranaggi.");
		Room bedroom_2 = new Room(13, "Stanza da letto dei tuoi genitori", 
				"Sei nella STANZA DA LETTO dei tuoi genitori "
						+ "\nQuell'armadio antico donato dalla bisnonna ti ha sempre fatto schifo, "
						+ "\nchissà quando si decideranno a gettarlo.", 
						"Proprio sotto a quel tremendo armadio noti un bigliettino accartocciato, "
								+ "\ndiamogli un occhiata.");

		//Creazione di tutti gli item presenti nel gioco
		PickubleItem alarmClock = new PickubleItem (1, "sveglia", 
				"É rotta, non ha nè lancette, nè pile.");
		alarmClock.setAlias(new String[] {"orologio"});
		PickubleItem cell = new PickubleItem (2 , "pile", 
				"Sono delle pile, sono cariche.");
		cell.setAlias(new String[] {"stilo", "batterie"});
		PickubleItem needle = new PickubleItem (3 , "lancette", 
				"Sono delle lancette nuove di zecca.");
		needle.setAlias(new String[] {"aghi"});
		PickubleItem mechanism = new PickubleItem (4 , "ingranaggi", 
				"Sono degli ingranaggi, a cosa serviranno?");
		mechanism.setAlias(new String[] {"meccanismo", "motore"});
		ReadableItem note_1 = new ReadableItem (5 , "bigliettino", 
				"'Sei sicuro di essere sveglio?'");
		note_1.setAlias(new String[] {"note", "nota", "biglietto", "foglietto", "fogliettino", "carta"});
		ReadableItem note_2 = new ReadableItem (6 , "bigliettino", 
				"'Tic Tac, Tic Tac'");
		note_2.setAlias(new String[] {"note", "nota", "biglietto", "foglietto", "fogliettino", "carta"});
		ReadableItem note_3 = new ReadableItem (7 , "bigliettino",
				"'75372'");
		note_3.setAlias(new String[] {"note", "nota", "biglietto", "foglietto", "fogliettino", "carta"});
		ReadableItem note_4 = new ReadableItem (8 , "bigliettino", 
				"'Chi dorme non piglia 18 -UniversitarioAnonimo'");
		note_4.setAlias(new String[] {"note", "nota", "biglietto", "foglietto", "fogliettino", "carta"});
		PushableItem buttonLight = new PushableItem (9 , "interruttore",
				"SONO UN BOTTONE INUTILE AHAHAHAHAHAH");
		buttonLight.setAlias(new String[] {"bottone", "pulsante", "tasto", "luce", "lampadina", "l'interruttore" });
		PushableItem tv = new PushableItem (10 , "televisore", 
				"'TG-Cose, si informa tutta la popolazione che è in atto una guerra contro uno dei virus più strani. "
						+ "\nATTENZIONE! Contraendolo si rischia di cadere in un sonno profondo, "
						+ "\nda cui sarà quasi impossibile risvegliarsi...'");
		tv.setAlias(new String[] {"tv", "televisione"});
		PushableItem buttonWindow = new PushableItem (11 , "interruttore", 
				"La finestra si è aperta e fuori è buio..."
						+ "\ncontinuiamo ad esplorare, è tutto molto strano");
		buttonWindow.setAlias(new String[] {"bottone", "pulsante", "tasto", "l'interruttore"});
		OpenableItem safeBox = new OpenableItem (12, "cassaforte", 
				"Nella cassaforte ci sono: delle lancette ed un bigliettino "
						+ "\nMa niente soldi, peccato...");
		safeBox.setAlias(new String[] {"cassetta"});
		WearableItem ring = new WearableItem (13, "anello", 
				"Prova ad indossarlo!");
		ring.setAlias(new String[] {"gioiello", "l'anello"});
		UselessItem pictures = new UselessItem (14, "quadri", 
				"Non hai mai guardato così da vicino questi quadri"
						+ "\nChe quasi ti sembra non riconoscerli.");
		pictures.setAlias(new String[] {"quadro", "immagini", "tela", "dipinto"});
		UselessItem fly = new UselessItem(15, "mosca", 
				"HA DIECI OCCHI!!!");
		fly.setAlias(new String[] {"moscerino", "insetto"});

		this.setInventory(new OpenableItem(16, "zaino", 
				"Grazie a questo zaino\npotrai portare con te quasi tutti gli oggetti"
						+ "\nche incontrarai nel tuo cammino."));

		//Aggiunta item nei loro contenitori
		safeBox.getItemList().add(note_4);
		safeBox.getItemList().add(needle);
		getInventory().getItemList().add(ring);

		//Aggiunta degli item nelle stanze corrispondenti
		hall.getItems().add(alarmClock);
		hallway_1.getItems().add(buttonLight);
		kitchen.getItems().add(note_1);
		balcony.getItems().add(cell);
		livingRoom.getItems().add(tv);
		hallway_2.getItems().add(pictures);
		bathroom.getItems().add(buttonWindow);
		storageRoom.getItems().add(safeBox);
		office.getItems().add(note_2);
		hallway_3.getItems().add(fly);
		secretRoom.getItems().add(mechanism);
		bedroom_2.getItems().add(note_3);

		//Definizione di tutti i collegamenti tra le varie stanze
		hall.setNearbyRooms(null, livingRoom, hallway_1, null);
		hallway_1.setNearbyRooms(null, null, kitchen, hall);
		kitchen.setNearbyRooms(null, hallway_2, balcony, hallway_1);
		balcony.setNearbyRooms(null, null, null, kitchen);
		livingRoom.setNearbyRooms(hall, storageRoom, office, null);
		bedroom_1.setNearbyRooms(null, null, hallway_2, null);
		hallway_2.setNearbyRooms(kitchen, hallway_3, bathroom, bedroom_1);
		bathroom.setNearbyRooms(null, null, null, hallway_2);
		storageRoom.setNearbyRooms(livingRoom, null, null, null);
		office.setNearbyRooms(null, null, hallway_3, livingRoom);
		hallway_3.setNearbyRooms(hallway_2, bedroom_2, secretRoom, office);
		secretRoom.setNearbyRooms(null, null, null, hallway_3);
		bedroom_2.setNearbyRooms(hallway_3, null, null, null);

		//Stanza iniziale
		this.setCurrentRoom(bedroom_1);

		//Creazione comandi
		Command north = new Command(CommandType.NORTH, "nord");
		north.setAlias(new String[] {"n"});
		Command south = new Command(CommandType.SOUTH, "sud");
		south.setAlias(new String[] {"s"});
		Command west = new Command(CommandType.WEST, "ovest");
		west.setAlias(new String[] {"o"});
		Command east = new Command(CommandType.EAST, "est");
		east.setAlias(new String[] {"e"});
		Command look = new Command(CommandType.LOOK, "guarda");
		look.setAlias(new String[] {"osserva", "trova", "cerca", "sbircia", "ispeziona"});
		Command open = new Command(CommandType.OPEN, "apri");
		open.setAlias(new String[] {"aprire", "tocca"});
		Command pickUp = new Command(CommandType.PICK_UP, "raccogli");
		pickUp.setAlias(new String[] {"prendi", "afferra", "acchiappa"});
		Command push = new Command(CommandType.PUSH, "premi");
		push.setAlias(new String[] {"spingi", "schiaccia", "pigia", "accendi"});
		Command wear = new Command(CommandType.WEAR, "indossa");
		wear.setAlias(new String[] {"metti" , "infila"});
		Command remove = new Command(CommandType.REMOVE, "rimuovi");
		remove.setAlias(new String[] {"sfila" , "leva", "togli"});
		Command read = new Command(CommandType.READ, "leggi");
		read.setAlias(new String[] {"sfoglia"});
		Command place = new Command(CommandType.PLACE, "luogo");
		place.setAlias(new String [] {"stanza", "posizione"});
		Command map = new Command(CommandType.MAP, "mappa");
		map.setAlias(new String [] {"piantina", "cartina"});

		//aggiunti comandi alla lista dei comandi
		this.getCommands().add(north);
		this.getCommands().add(south);
		this.getCommands().add(west);
		this.getCommands().add(east);
		this.getCommands().add(look);
		this.getCommands().add(open);
		this.getCommands().add(pickUp);
		this.getCommands().add(push);
		this.getCommands().add(wear);
		this.getCommands().add(remove);
		this.getCommands().add(read);
		this.getCommands().add(place);
		this.getCommands().add(map);
		
	}
	@Override
	public void doMove(Move move) {

		//Tiene conte se si è piccoli
		boolean smallSize = this.getWornItem().isEmpty() ? true : false;

		//Caso in cui non viene individuata nessuna mossa
		if (move.getCommandType().isEmpty()) {
			System.out.println("*ERRORE* : non ho capito quello che hai scritto, riprova con un altro comando :)");

		} else if (move.getItem().isEmpty() && move.getInvItem().isEmpty()) {

			if(move.getCommandType().get() == CommandType.LOOK){
				System.out.println(this.getCurrentRoom().getLookDescription());

			}else if (move.getCommandType().get() == CommandType.PLACE) {
				System.out.println("Sei in : " + this.getCurrentRoom().getName());

			} else if (move.getCommandType().get() == CommandType.MAP) {
				System.out.println("\tINGRESSO--------CORRIDOIO--------CUCINA--------BALCONE");
				System.out.println("\t   |                                |                 ");
				System.out.println("\t   |         STANZA DA LETTO----CORRIDOIO------BAGNO  ");
				System.out.println("\t   |                                |                 ");
				System.out.println("\tSALOTTO-----------STUDIO--------CORRIDOIO             ");
				System.out.println("\t   |                                |                 ");
				System.out.println("\tSGABUZZINO                   STANZA DA LETTO          ");
			} else {

				//Tiene conto se nella direzione indicata c'è una stanza
				boolean hasRoom = true;
				//Tiene conte se è stato effettuato un movimento da una stanza ad un'altra
				boolean movement = false;
				
				if (move.getCommandType().get() == CommandType.NORTH) {
					if (!smallSize) {
						if (this.getCurrentRoom().getNorth() != null) {
							this.setCurrentRoom(this.getCurrentRoom().getNorth());
							movement = true;
						} else hasRoom = false;
					}
				} 
				
				else if (move.getCommandType().get() == CommandType.SOUTH) {
					if (!smallSize) {
						if (this.getCurrentRoom().getSouth() != null) {
							this.setCurrentRoom(this.getCurrentRoom().getSouth());
							movement = true;
						} else hasRoom = false;
					}
				} 
				
				else if (move.getCommandType().get() == CommandType.EAST) {
					if (!smallSize && this.getCurrentRoom().getId() != 11) {
						if (this.getCurrentRoom().getEast() != null) {
							this.setCurrentRoom(this.getCurrentRoom().getEast());
							movement = true;
						} else hasRoom = false;
					} else if (smallSize && this.getCurrentRoom().getId() == 11) {

						this.setCurrentRoom(this.getCurrentRoom().getEast());
						movement = true;
					}
				}
				
				else if (move.getCommandType().get() == CommandType.WEST) {
					if (!smallSize) {
						if (this.getCurrentRoom().getWest() != null) {
							this.setCurrentRoom(this.getCurrentRoom().getWest());
							movement = true;
						} else hasRoom = false;
					}
				}

				if (movement) {
					//Nel caso in cui è stato effettuato uno spostamento
					System.out.println(this.getCurrentRoom().getDescription());

				} else if (!hasRoom) {
					//Nel caso in cui non ci sia una stanza nella direzione indicata
					System.out.println("(D'OH) Non puoi muoverti in questa direzione!!");

				} else if (smallSize) {
					//se si è piccoli per compiere un'azione
					System.out.println("*ATTENZIONE*: Sei troppo piccolo per fare questo!");

				} else System.out.println("*ERRORE* : non mi prendere in giro!");
			}

		}

		else if (move.getItem().isEmpty() || move.getInvItem().isEmpty()) {

			//TUTTI GLI ALTRI COMANDI
			if (move.getCommandType().get() == CommandType.LOOK) {

				if (move.getItem().isPresent() && !(move.getItem().get() instanceof ReadableItem)) {
					System.out.println(move.getItem().get().getDescription());

				} else if (move.getInvItem().isPresent() && !(move.getInvItem().get() instanceof ReadableItem)) {
					System.out.println(move.getInvItem().get().getDescription());
					if (move.getInvItem().get().getId() == 17) {
						System.out.println("Hai aperto gli occhi, ti svegli e sei in ospedale."
								+ "	\nSta arrivando un dottore: 'Hai vinto la tua battaglia contro il virus del sonno!!"
								+ "	\nCiò significa che sei riuscito a trovare tutto quel che ti serviva per svegliarti."
								+ "	\nRiusciranno anche gli altri a farlo?'"
								+ "	\nIL GIOCO È TERMINATO, COMPLIMENTI!");
						System.exit(0);
					}

				} else System.out.println("*ATTENZIONE*: Puoi solo leggere questo oggetto!");

			} else if (move.getCommandType().get() == CommandType.OPEN) {

				if (move.getInvItem().isPresent()) {

					//Controlla se l'oggeto è l'inventario
					if(move.getInvItem().get().equals(this.getInventory())) {

						if(this.getInventory().getItemList().isEmpty()) {
							System.out.println("Lo zaino è vuoto!");

						} else {
							if(!this.getInventory().isOpened()) {

								this.getInventory().setOpened(true);
								this.getCurrentRoom().setLookDescription("Non c'è nulla di particolare.\nVai ad esplorare!");
							}

							System.out.println("Nello zaino c'è:");
							for(Item item : this.getInventory().getItemList()) {
								System.out.println("-" + item.getName());	
							}

						}

						//L'oggetto appartiene all'inventario ma non è apribile
					} else System.out.println("*ATTENZIONE*: Non è possibile aprire questo oggetto!");

					//Controlla se l'ogetto della stanza è di tipo apribile
				} else if (move.getItem().get() instanceof OpenableItem) {

					if (!smallSize) {
						OpenableItem item = (OpenableItem) move.getItem().get();

						if (item.isOpened()) {
							System.out.println("É già aperto!");
							for (Item safeBoxItem : this.getCurrentRoom().getItems()) {
								if (safeBoxItem.getId() != 12) {
									System.out.println(safeBoxItem.getName());	
								}
							}
						} else {
							SafeBox windowSafeBox = new SafeBox();

							do {
								windowSafeBox.setVisible(true);								
								windowSafeBox.setAlwaysOnTop(true);

								if (windowSafeBox.getTxtPassword().equals("75372")) {
									System.out.println("WOW! SEI RIUSCITO AD APRIRLA!");
									System.out.println("\nNella cassaforte hai trovato: ");
									windowSafeBox.setVisible(false);
									item.setOpened(true);

									for (Item safeBoxItem : item.getItemList()) {
										System.out.println(safeBoxItem.getName());
										this.getCurrentRoom().getItems().add(safeBoxItem);
									}
								}
							} while (windowSafeBox.isVisible());

						}
					} else System.out.println("*ATTENZIONE*: Sei troppo piccolo per aprire questo oggetto!");

					//L'oggetto appartiene alla stanza ma non è apribile
				} else System.out.println("*ATTENZIONE*: Non è possibile aprire questo oggetto!");

			} else if (move.getCommandType().get() == CommandType.WEAR) {

				if(move.getInvItem().isPresent() && move.getInvItem().get() instanceof WearableItem) {
					this.setWornItem((WearableItem) move.getInvItem().get());
					this.getInventory().getItemList().remove(move.getInvItem().get());
					System.out.println("Hai indossato :" + move.getInvItem().get().getName());

					if (this.getWornItem().get().getId() == 13) {
						System.out.println("WOW! Sei tornato alle tue dimensioni naturali!");
					} 

				} else if (move.getItem().isPresent()) {
					System.out.println("*ATTENZIONE*: Stai già indossando : " + this.getWornItem().get().getName());

				} else System.out.println("*ATTENZIONE*: Non è possibile indossare questo oggetto!");

			} else if (move.getCommandType().get() == CommandType.REMOVE) {

				if (this.getWornItem().isEmpty()) {
					System.out.println("*ATTENZIONE*: Non hai nessun oggetto addosso!");

				} else if (move.getItem().isPresent()) {		
					this.setWornItem(null);
					this.getInventory().getItemList().add(move.getItem().get());
					System.out.println("L'oggetto : " + move.getItem().get().getName() + " è stato spostato nello zaino.");

					if (move.getItem().get().getId() == 13) {
						System.out.println("Togliendoti l'anello sei tornato piccolo.");
					}

				} else System.out.println("*ATTENZIONE*: Non puoi togliere oggetti che non indossi!");

			} else if (move.getCommandType().get() == CommandType.PICK_UP) {

				if (move.getItem().isPresent() && move.getItem().get() instanceof PickubleItem ) {
					if (!smallSize) {
						this.getInventory().getItemList().add(move.getItem().get());
						this.getCurrentRoom().getItems().remove(move.getItem().get());
						System.out.println("L'oggetto : " + move.getItem().get().getName() + " è stato messo nello zaino.");

						//controlla che l'item siano le pile
						if (move.getItem().get().getId() == 2) {
							this.getCurrentRoom().setLookDescription("");
						}
						if (this.getInventory().getItemList().size() == 4) {
							System.out.println("Dallo zaino proviene una luce strana. Che cosa mai sarà successo?");
							this.getInventory().getItemList().clear();
							UselessItem newAlarmClock = new UselessItem(17, "sveglia nuova", "La sveglia inizia a suonare.\n");
							newAlarmClock.setAlias(new String[] {"orologio", "sveglia"});
							this.getInventory().getItemList().add(newAlarmClock);
						}

					} else System.out.println("*ATTENZIONE*: Sei troppo piccolo per prendere questo oggetto!");

				} else { 
					System.out.println("*ATTENZIONE* : Non puoi metterlo nello zaino!");
				}

			} else if (move.getCommandType().get() == CommandType.PUSH) {

				if (move.getItem().isPresent() && move.getItem().get() instanceof PushableItem) {
					if (!smallSize) {
						System.out.println(move.getItem().get().getDescription());

					} else System.out.println("*ATTENZIONE*: Sei troppo piccolo per premere questo oggetto!");

				}else System.out.println("*ATTENZIONE*: Non puoi premere questo oggetto!");

			} else if (move.getCommandType().get() == CommandType.READ) {

				if (move.getItem().isPresent() && move.getItem().get() instanceof ReadableItem) {
					if (!smallSize) {
						System.out.println(move.getItem().get().getDescription());

					} else System.out.println("*ATTENZIONE*: Sei troppo piccolo per leggere questo oggetto!");

				} else System.out.println("*ATTENZIONE*: Non puoi leggere questo oggetto!");

			} 

		}

	} 

}

