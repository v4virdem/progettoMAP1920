package baseClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import command.Command;
import item.OpenableItem;
import item.WearableItem;

/*
 * Modella la partita
 * «Entity»
 */
public abstract class Game {

	private OpenableItem inventory ;
	private WearableItem wornItem = null;
	private List<Command> commands = new ArrayList<>();
	private Room currentRoom; 

	public OpenableItem getInventory() {
		return this.inventory;
	}

	public void setInventory(OpenableItem inventory) {
		this.inventory = inventory;
	}

	public Optional<WearableItem> getWornItem() {
		return Optional.ofNullable(this.wornItem);
	}

	public void setWornItem(WearableItem item) {
		this.wornItem = item;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}

	public abstract void init();

	public abstract void doMove(Move move);
}
