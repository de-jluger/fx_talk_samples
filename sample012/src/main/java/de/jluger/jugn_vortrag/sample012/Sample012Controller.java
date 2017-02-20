package de.jluger.jugn_vortrag.sample012;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class Sample012Controller {
    @FXML
    private TableView<MyTableEntry> beispielTableView;
    @FXML
    private TableColumn<MyTableEntry, Integer> idTableColumn;
    @FXML
    private TableColumn<MyTableEntry, String> textTableColumn;
    private Sample12ViewModel viewModel;
    
	public Sample012Controller(Sample12ViewModel viewModel) {
		this.viewModel = viewModel;
	}


	@FXML
	public void initialize() {
		beispielTableView.setItems(viewModel.getTableList());
		idTableColumn.setCellValueFactory(viewModel.getIdCellValueFactory());
		idTableColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		textTableColumn.setCellValueFactory(viewModel.getTextCellValueFactory());
		textTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
}
