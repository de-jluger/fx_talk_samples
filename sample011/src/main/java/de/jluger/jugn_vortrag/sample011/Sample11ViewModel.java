package de.jluger.jugn_vortrag.sample011;

import java.math.BigInteger;
import java.security.SecureRandom;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Sample11ViewModel {
	private static SecureRandom random = new SecureRandom();
	private ObservableList<MyTableEntry> tableList = FXCollections.observableArrayList();
	private Callback<CellDataFeatures<MyTableEntry, Integer>, ObservableValue<Integer>> idCellValueFactory = (
			CellDataFeatures<MyTableEntry, Integer> c) -> c.getValue().getIdProperty().asObject();
	private Callback<CellDataFeatures<MyTableEntry, String>, ObservableValue<String>> textCellValueFactory = (
			CellDataFeatures<MyTableEntry, String> c) -> c.getValue().getTextProperty();

	public Sample11ViewModel() {
		tableList.add(new MyTableEntry(1, "Zeile1\nZeile2\nZeile3"));
		tableList.add(new MyTableEntry(2, new BigInteger(1300, random).toString(320)));
		tableList.add(new MyTableEntry(3, "Zeile1\nZeile2\n"+new BigInteger(1300, random).toString(320)));
	}

	public ObservableList<MyTableEntry> getTableList() {
		return tableList;
	}

	public Callback<CellDataFeatures<MyTableEntry, Integer>, ObservableValue<Integer>> getIdCellValueFactory() {
		return idCellValueFactory;
	}

	public Callback<CellDataFeatures<MyTableEntry, String>, ObservableValue<String>> getTextCellValueFactory() {
		return textCellValueFactory;
	}

}
