package de.jluger.jugn_vortrag.sample010;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Sample010Controller {
    @FXML
    private TableView<MyTableEntry> beispielTableView;
    @FXML
    private TableColumn<MyTableEntry, Integer> spalte1TableColumn;
    @FXML
    private TableColumn<MyTableEntry, String> vortragTableColumn;
    @FXML
    private TableColumn<MyTableEntry, Short> wertungTableColumn;
    @FXML
    private TableColumn<MyTableEntry, Object> vierteSpalteTableColumn;
    private Sample10ViewModel viewModel;
    
	public Sample010Controller(Sample10ViewModel viewModel) {
		this.viewModel = viewModel;
	}


	@FXML
	public void initialize() {
		beispielTableView.setItems(viewModel.getTableList());
		spalte1TableColumn.setCellValueFactory(viewModel.getSpalte1CellValueFactory());
		vortragTableColumn.setCellFactory(MY_CELL_FACTORY);
		vortragTableColumn.setCellValueFactory(viewModel.getVortragCellValueFactory());
		wertungTableColumn.setCellValueFactory(new PropertyValueFactory<MyTableEntry, Short>("wertung"));
		vierteSpalteTableColumn.setCellValueFactory(viewModel.getSpalte4CellValueFactory());
	}

    /**
     * Siehe auch {@link TableColumn#DEFAULT_CELL_FACTORY}
     */
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
                    	System.out.println(getIndex());
                        System.out.println(item);
                        System.out.println(getTableRow().getItem());
                        MyTableEntry entry = (MyTableEntry)getTableRow().getItem();
                        short wertung = entry.getWertungProperty().getValue();
                        if (wertung>10) {
                        	setStyle("-fx-text-fill:green");
                        } else if (wertung<-10) {
                        	setStyle("-fx-text-fill:red");
                        } else {
                        	setStyle(null);
                        }
                        super.setText(item.toString());
                        super.setGraphic(null);
                    }
                }
            };
        }
    };
}
