package item;

import java.util.ArrayList;
import java.util.List;

import baseClasses.Item;

/*
 * Modella gli item che possono essere aperti
 * «Entity»
 */
public final class OpenableItem extends Item {

	//Definisce se un'oggetto è stato aperto o no
	private boolean opened = false;

	//Lista di item che l'item potrà contenere
	private List<Item> itemList = new ArrayList<Item>();

	public OpenableItem(int id, String name, String description) {
		super(id, name, description);
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

}