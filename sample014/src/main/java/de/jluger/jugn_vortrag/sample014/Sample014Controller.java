package de.jluger.jugn_vortrag.sample014;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Sample014Controller {
    @FXML
    private TableView<MyTableEntry> beispielTableView;
    @FXML
    private TableColumn<MyTableEntry, Integer> idTableColumn;
    @FXML
    private TableColumn<MyTableEntry, String> textTableColumn;
    @FXML
    private Button printButton;
    private Sample14ViewModel viewModel;
    
	public Sample014Controller(Sample14ViewModel viewModel) {
		this.viewModel = viewModel;
	}


	@FXML
	public void initialize() {
		beispielTableView.setItems(viewModel.getTableList());
		idTableColumn.setCellValueFactory(viewModel.getIdCellValueFactory());
		textTableColumn.setCellValueFactory(viewModel.getTextCellValueFactory());
		printButton.setOnAction((ActionEvent e)-> {
			PrinterJob job = PrinterJob.createPrinterJob();
			boolean doPrint = job.showPrintDialog(printButton.getScene().getWindow());
			if (doPrint) {
				job.printPage(beispielTableView);
			}
			job.endJob();
		});
	}
}
