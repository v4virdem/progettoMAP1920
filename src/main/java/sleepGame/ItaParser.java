package sleepGame;

import java.util.List;
import java.util.Optional;

import baseClasses.Item;
import baseClasses.Move;
import baseClasses.Parser;
import command.Command;
import command.CommandType;
import item.OpenableItem;
import item.WearableItem;

/*
 * Modella il Parser per la lingua italiana
 * «Boundary»
 */
public final class ItaParser extends Parser{

	@Override
	public Move parse(String cliInput, List<Command> commands, List<Item> items, OpenableItem inventory, Optional<WearableItem> wornItem) {

		String[] tokens = cliInput.split("\\s+");
		int i = 0;

		//Controlla se il primo token è un comando
		Optional<CommandType> foundCommand = checkForCommand(tokens[i], commands);
		if (foundCommand.isPresent()) {
			i++;
			while (i < tokens.length) { 
				//Controlla se il token successivo è l'inventario
				if(inventory.getName().equals(tokens[i])) {
					return new Move(foundCommand.get(), null, inventory);
				}
				//Controlla se il token successivo è un'item indossato
				if (wornItem.isPresent() && wornItem.get().getName().equals(tokens[i])) {
					return new Move(foundCommand.get(), wornItem.get(), null);
				}

				//Controlla se il token successivo è un item della stanza o è un item dell'invetario
				Optional<Item> foundItem = checkForItem(tokens[i], items);
				Optional<Item> foundInvItem = checkForItem(tokens[i], inventory.getItemList());

				if (foundItem.isPresent()) {
					return new Move(foundCommand.get(), foundItem.get(), null);
				} else if(foundInvItem.isPresent()) {
					return new Move(foundCommand.get(), null, foundInvItem.get());
				} else if (i == tokens.length-1) {
					return new Move (null, null, null);
				} else i++;

			}
			return new Move(foundCommand.get(), null, null);

		} return new Move (null, null, null);

	}

}
