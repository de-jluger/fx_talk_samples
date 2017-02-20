package de.jluger.jugn_vortrag.sample010;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Sample10ViewModel {
	private ObservableList<MyTableEntry> tableList = FXCollections.observableArrayList();
	private Callback<CellDataFeatures<MyTableEntry, Integer>, ObservableValue<Integer>> spalte1CellValueFactory = (
			CellDataFeatures<MyTableEntry, Integer> c) -> c.getValue().getSpalte1Property().asObject();
	private Callback<CellDataFeatures<MyTableEntry, String>, ObservableValue<String>> vortragCellValueFactory = (
			CellDataFeatures<MyTableEntry, String> c) -> c.getValue().getVortragProperty();
	private Callback<CellDataFeatures<MyTableEntry, Short>, ObservableValue<Short>> wertungCellValueFactory = (
			CellDataFeatures<MyTableEntry, Short> c) -> c.getValue().getWertungProperty();
	private Callback<CellDataFeatures<MyTableEntry, Object>, ObservableValue<Object>> spalte4CellValueFactory = (
			CellDataFeatures<MyTableEntry, Object> c) -> c.getValue().getSpalte4Property();

	public Sample10ViewModel() {
		tableList.add(new MyTableEntry(1, "Java", (short)100));
		tableList.add(new MyTableEntry(2, "PHP", (short)0));
		tableList.add(new MyTableEntry(3, "Compliance", (short)-100));
	}

	public ObservableList<MyTableEntry> getTableList() {
		return tableList;
	}

	public Callback<CellDataFeatures<MyTableEntry, Integer>, ObservableValue<Integer>> getSpalte1CellValueFactory() {
		return spalte1CellValueFactory;
	}

	public Callback<CellDataFeatures<MyTableEntry, String>, ObservableValue<String>> getVortragCellValueFactory() {
		return vortragCellValueFactory;
	}

	public Callback<CellDataFeatures<MyTableEntry, Short>, ObservableValue<Short>> getWertungCellValueFactory() {
		return wertungCellValueFactory;
	}

	public Callback<CellDataFeatures<MyTableEntry, Object>, ObservableValue<Object>> getSpalte4CellValueFactory() {
		return spalte4CellValueFactory;
	}
}
