package de.jluger.jugn_vortrag.sample004;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Hello world!
 *
 */
public class Sample004 {
	public static void main(String[] args) {
		StringProperty halloProperty = new SimpleStringProperty("Hallo ");
		StringProperty subjectProperty = new SimpleStringProperty("Welt");
		StringExpression greeting = halloProperty.concat(subjectProperty);
		System.out.println(greeting.getValue());
		subjectProperty.setValue("JUG-N");
		System.out.println(greeting.getValue());
		IntegerProperty firstOperandProperty = new SimpleIntegerProperty(10);
		IntegerProperty secondOperandProperty = new SimpleIntegerProperty(12);
		NumberBinding sumBinding = firstOperandProperty.add(secondOperandProperty).add(5);
		System.out.println(sumBinding.getValue());
		BooleanBinding minorBinding = sumBinding.lessThan(10);
		System.out.println(minorBinding.getValue());
		secondOperandProperty.setValue(-7);
		System.out.println(minorBinding.getValue());
		StringBinding minorAsStringBinding = new When(minorBinding).then("Kleiner Wert").otherwise("Großer Wert");
		System.out.println(minorAsStringBinding.getValue());
		ObservableList<String> stringList = FXCollections.observableArrayList();
		StringBinding listSizeAsTextBinding = Bindings.size(stringList).asString();
		new JFXPanel();//Braucht graphischen Kontext.
		Label label = new Label();
		label.textProperty().bind(listSizeAsTextBinding);
		System.out.println(label.getText());
		label.disableProperty().bind(minorBinding);
		TextField textField = new TextField();
		textField.textProperty().bindBidirectional(subjectProperty);
		System.exit(0);
	}
}
