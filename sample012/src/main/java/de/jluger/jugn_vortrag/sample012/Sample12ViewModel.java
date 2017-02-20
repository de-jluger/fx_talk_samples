package de.jluger.jugn_vortrag.sample012;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Sample12ViewModel {
	private ObservableList<MyTableEntry> tableList = FXCollections.observableArrayList();
	private Callback<CellDataFeatures<MyTableEntry, Integer>, ObservableValue<Integer>> idCellValueFactory = (
			CellDataFeatures<MyTableEntry, Integer> c) -> c.getValue().getIdProperty().asObject();
	private Callback<CellDataFeatures<MyTableEntry, String>, ObservableValue<String>> textCellValueFactory = (
			CellDataFeatures<MyTableEntry, String> c) -> c.getValue().getTextProperty();

	public Sample12ViewModel() {
		tableList.add(new MyTableEntry(1, "Zeile1"));
		tableList.add(new MyTableEntry(2, "Zeile2"));
		tableList.add(new MyTableEntry(3, "Zeile3"));
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
