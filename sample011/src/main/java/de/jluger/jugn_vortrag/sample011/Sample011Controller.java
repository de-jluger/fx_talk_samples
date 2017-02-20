package de.jluger.jugn_vortrag.sample011;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Sample011Controller {
    @FXML
    private TableView<MyTableEntry> beispielTableView;
    @FXML
    private TableColumn<MyTableEntry, Integer> idTableColumn;
    @FXML
    private TableColumn<MyTableEntry, String> textTableColumn;
    private Sample11ViewModel viewModel;
    
	public Sample011Controller(Sample11ViewModel viewModel) {
		this.viewModel = viewModel;
	}


	@FXML
	public void initialize() {
		beispielTableView.setItems(viewModel.getTableList());
		idTableColumn.setCellValueFactory(viewModel.getIdCellValueFactory());
		textTableColumn.setCellFactory(MY_CELL_FACTORY);
		textTableColumn.setCellValueFactory(viewModel.getTextCellValueFactory());
	}

	public static final Callback<TableColumn<MyTableEntry,String>, TableCell<MyTableEntry,String>> MY_CELL_FACTORY =
            new Callback<TableColumn<MyTableEntry,String>, TableCell<MyTableEntry,String>>() {

        @Override public TableCell<MyTableEntry,String> call(TableColumn<MyTableEntry,String> param) {
            return new TableCell<MyTableEntry,String>() {
                @Override protected void updateItem(String item, boolean empty) {
                    if (item == getItem()) return;

                    super.updateItem(item, empty);

                    if (item == null) {
                        super.setText(null);
                        super.setGraphic(null);
                        setStyle(null);
                    } else {
                        super.setText(null);
                    	Label l = new Label(item);
                    	l.setWrapText(true);
                    	VBox box = new VBox(l);
                    	l.heightProperty().addListener((observable,oldValue,newValue)-> {
                        	box.setPrefHeight(newValue.doubleValue()+7);
                        });
                    	super.setGraphic(box);
                    }
                }
            };
        }
    };
}
