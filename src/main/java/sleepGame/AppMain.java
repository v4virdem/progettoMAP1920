package sleepGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import baseClasses.Game;
import baseClasses.Move;

/**
 * Inizializza l'applicazione e gestisce l'input dell'utente.
 * «Boundary»
 */
public final class AppMain {

	private static Map<String, CommandHandler> commands = new HashMap<>();
	private static boolean exit = false;

	private static Game game;

	static {

		commands.put("aiuto", AppMain::handleHelp);
		commands.put("inizia", AppMain::handleStart);
		commands.put("esci", AppMain::handleQuit);

	}

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ItaParser parser = new ItaParser();

		System.out.println("Hei tu, si proprio TU! C'è qualcosa di strano in tutto questo. Scopri cos'è!\n");
		System.out.println("Scrivi 'inizia' per iniziare il gioco, oppure scrivi 'aiuto' per vedere la lista dei comandi.");

		while (!exit) {

			System.out.println();
			System.out.print("> ");

			try {

				String command = reader.readLine().toLowerCase().trim();

				CommandHandler handler = commands.get(command);
				if (handler == null) {
					if(game != null) {

						Move move = parser.parse(command, game.getCommands(), game.getCurrentRoom().getItems(), game.getInventory(), game.getWornItem());
						game.doMove(move);

					} else System.out.println("*ATTENZIONE*: Devi prima iniziare una nuova partita! \nScrivi 'inizia' per iniziare.");

				} else handler.handle(reader);

			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

		}

		try {
			reader.close();
		} catch (IOException e) {}


	}

	private static void handleHelp(final BufferedReader reader) {

		System.out.println("\nCOMANDI GIOCO");
		System.out.println(" ESCI\t> esci dalla partita");
		System.out.println("\n- Ti puoi muovere nelle seguenti direzioni:");
		System.out.println("  NORD\t> shortcut: 'n'");
		System.out.println("  SUD\t> shortcut: 's'");
		System.out.println("  EST\t> shortcut: 'e'");
		System.out.println("  OVEST\t> shortcut: 'o'");
		System.out.println("\n  MAPPA\t> visualizza la mappa del gioco");
		System.out.println("  LUOGO\t> shortcut: 'stanza' o 'posizione', specifica la stanza in cui ti trovi");

		System.out.println("\n- Ecco cosa pouoi fare durante il gioco: ");
		System.out.println("  GUARDA\t> osserva i dettagli di una stanza o un oggetto");
		System.out.println("  APRI  \t> apre un oggetto");
		System.out.println("  RACCOGLI\t> prende un oggetto e lo mette nello zaino");
		System.out.println("  PREMI  \t> preme un oggetto");
		System.out.println("  INDOSSA\t> indossa l'oggetto specificato");
		System.out.println("  RIMUOVI\t> rimuove l'oggetto indossato e lo ripone nello zaino");
		System.out.println("  LEGGI \t> legge qualcosa");

	}

	private static void handleStart(final BufferedReader reader) {

		if (game != null) {

			try {

				while (true) {

					System.out.print("Sicuro di voler iniziare una nuova partita? (si/no) > ");
					String choice = reader.readLine();
					if (choice.equals("si")) {

						game = new SleepGame();
						game.init();

						System.out.println("Nuova partita avviata");
						System.out.println(game.getCurrentRoom().getDescription());
						break;

					} else if (choice.equals("no")) {
						break;
					} else {
						System.out.println("*ERRORE* : Scegli se iniziare una nuova partita scrivendo 'si' o 'no'\n");
					}

				}

			} catch (IOException e) {}

		} else {

			game = new SleepGame();
			game.init();

			System.out.println("Nuova partita avviata, Buona fortuna!");
			System.out.println(game.getCurrentRoom().getDescription());

		}

	}

	private static void handleQuit(final BufferedReader reader) {

		try {

			while (true) {

				System.out.print("Sicuro di voler terminare questa fantastica avventura? (si/no) > ");
				String choice = reader.readLine();
				if (choice.equals("si")) {
					exit = true;
					break;
				} else if (choice.equals("no")) {
					break;
				} else {
					System.out.println("*ERRORE* : Scegli se terminare la partita scrivendo 'si' o 'no'\n");
				}

			}

		} catch (IOException e) {}

	}

	private interface CommandHandler {

		void handle(BufferedReader reader);

	}
}
