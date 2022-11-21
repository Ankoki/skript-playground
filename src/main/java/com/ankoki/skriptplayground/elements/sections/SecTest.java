package com.ankoki.skriptplayground.elements.sections;

import ch.njol.skript.Skript;
import ch.njol.skript.config.SectionNode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.Section;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.TriggerItem;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.util.List;

public class SecTest extends Section {

	static {
		Skript.registerSection(SecTest.class,
				"skript-playground section");
	}

	@Override
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, ParseResult parseResult, SectionNode sectionNode, List<TriggerItem> list) {
		loadCode(sectionNode);
		return true;
	}

	@Override
	protected TriggerItem walk(Event event) {
		return this.walk(event, true);
	}

	@Override
	public String toString(Event event, boolean b) {
		return "skript-playground section";
	}
}
