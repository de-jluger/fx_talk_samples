package de.jluger.jugn_vortrag.sample014;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyTableEntry {
	private IntegerProperty idProperty = new SimpleIntegerProperty();
	private StringProperty textProperty = new SimpleStringProperty();
	
	public MyTableEntry(int id,String text) {
		idProperty.setValue(id);
		textProperty.setValue(text);
	}

	public IntegerProperty getIdProperty() {
		return idProperty;
	}

	public StringProperty getTextProperty() {
		return textProperty;
	}
}
