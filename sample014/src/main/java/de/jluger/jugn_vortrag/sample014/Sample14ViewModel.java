package de.jluger.jugn_vortrag.sample014;

import java.math.BigInteger;
import java.security.SecureRandom;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class Sample14ViewModel {
	private static SecureRandom random = new SecureRandom();
	private ObservableList<MyTableEntry> tableList = FXCollections.observableArrayList();
	private Callback<CellDataFeatures<MyTableEntry, Integer>, ObservableValue<Integer>> idCellValueFactory = (
			CellDataFeatures<MyTableEntry, Integer> c) -> c.getValue().getIdProperty().asObject();
	private Callback<CellDataFeatures<MyTableEntry, String>, ObservableValue<String>> textCellValueFactory = (
			CellDataFeatures<MyTableEntry, String> c) -> c.getValue().getTextProperty();

	public Sample14ViewModel() {
		for(int i=0;i<100;i++) {
			tableList.add(new MyTableEntry(i+1, new BigInteger(60, random).toString(32)));
		}
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
