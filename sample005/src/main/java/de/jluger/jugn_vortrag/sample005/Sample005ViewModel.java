package de.jluger.jugn_vortrag.sample005;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class Sample005ViewModel {
	private ObservableList<Operation> operationList = FXCollections.observableArrayList();
	private TextFormatter<Double> op1Formatter = new TextFormatter<>(new DoubleStringConverter(), null,
			new DoubleChangeFilter());
	private TextFormatter<Double> op2Formatter = new TextFormatter<>(new DoubleStringConverter(), null,
			new DoubleChangeFilter());
	private ObjectProperty<Operation> selectedOperationItem = new SimpleObjectProperty<>();
	private StringConverter<Operation> operationConverter = new StringConverter<Operation>() {
		
		@Override
		public String toString(Operation object) {
			if (object.getId()==1) {
				return "+";
			} else {
				return "-";
			}
		}
		
		@Override
		public Operation fromString(String string) {
			return null;
		}
	}; 
	private BooleanProperty calcDisableProperty = new SimpleBooleanProperty();
	private StringProperty resultProperty = new SimpleStringProperty();

	public Sample005ViewModel() {
		operationList.add(new Operation(1, (Double op1, Double op2) -> op1 + op2));
		operationList.add(new Operation(2, (Double op1, Double op2) -> op1 - op2));
		calcDisableProperty.bind(op1Formatter.valueProperty().isNull().or(op2Formatter.valueProperty().isNull()));
		selectedOperationItem.setValue(operationList.get(0));
	}

	public void calculate() {
		Double op1 = op1Formatter.getValue();
		Double op2 = op2Formatter.getValue();
		Double result = selectedOperationItem.getValue().getCalcFunction().apply(op1, op2);
		resultProperty.setValue(result.toString());
	}

	public ObservableList<Operation> getOperationList() {
		return operationList;
	}

	public TextFormatter<Double> getOp1Formatter() {
		return op1Formatter;
	}

	public TextFormatter<Double> getOp2Formatter() {
		return op2Formatter;
	}

	public ObjectProperty<Operation> getSelectedOperationItem() {
		return selectedOperationItem;
	}
	
	public StringConverter<Operation> getOperationConverter() {
		return operationConverter;
	}

	public BooleanProperty getCalcDisableProperty() {
		return calcDisableProperty;
	}

	public StringProperty getResultProperty() {
		return resultProperty;
	}
	
}
