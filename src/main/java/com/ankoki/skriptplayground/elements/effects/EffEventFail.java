package com.ankoki.skriptplayground.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.Nullable;

public class EffEventFail extends Effect {

	static {
		Skript.registerEffect(EffEventFail.class,
				"skript-playground fail event %string%");
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
	public @Nullable Class<? extends Event>[] getUsableEvents() {
		return CollectionUtils.array(PlayerDeathEvent.class);
	}

	@Override
	public String toString(Event event, boolean b) {
		return "skript-playground fail event " + stringExpr.toString(event, b);
	}

}
