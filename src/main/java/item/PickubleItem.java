package item;

import baseClasses.Item;

/*
 * Modella gli item che possono essere presi
 * «Entity»
 */
public final class PickubleItem extends Item {

	//Definisce se un'item è stato preso o no
	private boolean picked = false;

	public PickubleItem(int id, String name, String description) {
		super(id, name, description);
	}

	public boolean isPicked() {
		return picked;
	}

	public void setPicked(boolean picked) {
		this.picked = picked;
	}

}
