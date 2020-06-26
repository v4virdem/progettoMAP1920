package item;

import baseClasses.Item;

/*
 * Modella gli item che non hanno un utilizzo
 * «Entity»
 */
public final class UselessItem extends Item {

	public UselessItem(int id, String name, String description) {
		super (id, name, description);
	}
}
