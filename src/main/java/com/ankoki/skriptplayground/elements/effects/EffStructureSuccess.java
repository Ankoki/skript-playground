package com.ankoki.skriptplayground.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.structures.StructCommand;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.skriptlang.skript.lang.structure.Structure;

import java.util.List;

public class EffStructureSuccess extends Effect {

	static {
		Skript.registerEffect(EffStructureSuccess.class,
				"skript-playground success structure %string%");
	}

	private Expression<String> stringExpr;

	@Override
	public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean, ParseResult parseResult) {
		stringExpr = (Expression<String>) exprs[0];
		return true;
	}

	@Override
	protected void execute(Event event) {
		String string = stringExpr.getSingle(event);
		if (string != null)
			Bukkit.broadcastMessage(string);
	}

	@Override
	public List<Class<? extends Structure>> getUsableStructures() {
		return List.of(StructCommand.class);
	}

	@Override
	public String toString(Event event, boolean b) {
		return "skript-playground success structure " + stringExpr.toString(event, b);
	}

}
