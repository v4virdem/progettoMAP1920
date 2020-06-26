package baseClasses;

import java.util.ArrayList;
import java.util.List;

/*
 * Modella una stanza.
 * «Entity»
 */
public class Room {

	//Informazioni della stanza
	private final int id;
	private final String name;
	private String description;
	private String lookDescription;

	//Lista di oggetti presenti nella stanza
	private List<Item> items = new ArrayList<>();

	//Riferimenti alle altre stanze
	private Room north = null;
	private Room south = null;
	private Room east = null;
	private Room west = null;

	public Room(int id,String name, String description, String lookDescription) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.lookDescription = lookDescription;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLookDescription() {
		return lookDescription;
	}

	public void setLookDescription(String lookDescription) {
		this.lookDescription = lookDescription;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	//Get & Set Stanze vicine
	public void setNearbyRooms(Room north, Room south, Room east, Room west) {
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	public Room getSouth() {
		return south;
	}

	public Room getNorth() {
		return north;
	}

	public Room getEast() {
		return east;
	}

	public Room getWest() {
		return west;
	}

}
