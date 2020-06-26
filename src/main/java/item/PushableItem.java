package item;

import baseClasses.Item;

/*
 * Modella gli item che possono essere premuti
 * «Entity»
 */
public final class PushableItem extends Item {

	//Definisce se un'item è stato premuto o no
	private boolean pushed = false;

	public PushableItem(int id, String name, String description) {
		super(id, name, description);
	}

	public boolean isPushed() {
		return pushed;
	}

	public void setPpushed(boolean pushed) {
		this.pushed = pushed;
	}

}
