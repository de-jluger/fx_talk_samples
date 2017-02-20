package de.jluger.jugn_vortrag.sample010;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyTableEntry {
	private IntegerProperty spalte1Property = new SimpleIntegerProperty();
	private StringProperty vortragProperty = new SimpleStringProperty();
	private ObjectProperty<Short> wertungProperty = new SimpleObjectProperty<>();
	private ObjectProperty<Object> spalte4Property = new SimpleObjectProperty<>();
	
	public MyTableEntry(int spalte1,String vortrag,short wertung) {
		spalte1Property.setValue(spalte1);
		vortragProperty.setValue(vortrag);
		wertungProperty.setValue(wertung);
		spalte4Property.setValue(null);
	}

	public IntegerProperty getSpalte1Property() {
		return spalte1Property;
	}

	public StringProperty getVortragProperty() {
		return vortragProperty;
	}

	public ObjectProperty<Short> getWertungProperty() {
		return wertungProperty;
	}
	
	public Short getWertung() {
		return wertungProperty.getValue();
	}

	public ObjectProperty<Object> getSpalte4Property() {
		return spalte4Property;
	}

	@Override
	public String toString() {
		return "MyTableEntry [spalte1Property=" + spalte1Property + ", vortragProperty=" + vortragProperty
				+ ", wertungProperty=" + wertungProperty + ", spalte4Property=" + spalte4Property + "]";
	}
}
