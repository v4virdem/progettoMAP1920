
package baseClasses;

import java.util.List;

import java.util.Optional;

import command.Command;
import command.CommandType;
import item.OpenableItem;
import item.WearableItem;

/*
 * Modella il parser generico
 * «Entity»
 */
public abstract class Parser {

	//controlla che il comando in input appartenga alla lista dei comandi
	public Optional<CommandType> checkForCommand(String token, List<Command> commands) {

		for (Command command : commands) {
			if (command.getName().equals(token) || command.getAlias().contains(token)) {
				return Optional.of(command.getType());
			}
		} return Optional.empty();
	}

	//controlla che l'item in input appartenga alla lista degli item
	public Optional<Item> checkForItem(String token, List<Item> items) {

		for (Item item : items) {
			if (item.getName().equals(token) || item.getAlias().contains(token)) {
				return Optional.of(item);
			}
		} return Optional.empty();
	} 

	public abstract Move parse(String cliInput, List<Command> commands, List<Item> items, OpenableItem invetory, Optional<WearableItem> wornItem);
}
