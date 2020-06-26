package command;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Modella i comandi che faranno parte del gioco
 * «Entity»
 */
public final class Command {

	private final CommandType type;
	private final String name;
	private Set<String> alias;

	public Command(CommandType type, String name) {
		this.type = type;
		this.name = name;
	}

	public CommandType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Set<String> getAlias() {
		return alias;
	}

	public void setAlias(String[] alias) {
		this.alias = new HashSet<>(Arrays.asList(alias));
	}

}
