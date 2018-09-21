package me.auto.utils;

import me.auto.generator.Circle;
import me.auto.generator.FromTo;
import me.auto.generator.Generator;
import me.auto.generator.Line;
import me.auto.generator.Square;

public enum GenType {

	CIRCLE, FROMTO, LINE, SQUARE;
	
	public Generator craftGenerator() {
		switch(this) {
		case CIRCLE: return new Circle();
		case FROMTO: return new FromTo();
		case LINE: return new Line();
		case SQUARE: return new Square();
		default: return null;
		}
	}
	
}
