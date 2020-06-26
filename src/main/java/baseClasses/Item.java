package baseClasses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Modella gli item che faranno parte della partita
 * «Entity»
 */
public abstract class Item {

	//Informazioni dell'item
	private final int id; 
	private final String name;
	private String description;
	private Set<String> alias;

	public Item(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public Set<String> getAlias() {
		return alias;
	}

	public void setAlias(String[] alias) {
		this.alias = new HashSet<>(Arrays.asList(alias));
	}

}
