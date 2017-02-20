package de.jluger.jugn_vortrag.sample005;

import java.util.function.UnaryOperator;

import javafx.scene.control.TextFormatter.Change;

public class DoubleChangeFilter implements UnaryOperator<Change> {

	@Override
	public Change apply(Change t) {
		if (t.getControlNewText().equals(t.getControlText())) {
			return t;
		}
		for(char c:t.getControlNewText().toCharArray()) {
			if ((c<'0'||c>'9')&&c!='.'&&c!=',') {
				return null;
			}
		}
		return t;
	}

}
