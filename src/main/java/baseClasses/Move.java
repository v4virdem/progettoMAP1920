package baseClasses;

import java.util.Optional;

import command.CommandType;

/*
 * Modella la mossa da effettuare conservando il comando e l'eventuale oggetto
 * «Entity»
 */
public class Move {

	//comando
	private CommandType command; 
	//oggetto nella stanza
	private Item item; 
	//oggetto nell'inventario o l'inventario stesso
	private Item invItem; 

	public Move(CommandType command, Item item, Item invItem) {
		this.command = command;
		this.item = item;
		this.invItem = invItem;
	}

	public Optional<CommandType> getCommandType() {
		return Optional.ofNullable(command);
	}

	public Optional<Item> getItem() {
		return Optional.ofNullable(item);
	}

	public Optional<Item> getInvItem() {
		return Optional.ofNullable(invItem);
	}
}
