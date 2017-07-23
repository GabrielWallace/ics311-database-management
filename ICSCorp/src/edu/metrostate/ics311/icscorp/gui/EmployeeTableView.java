package edu.metrostate.ics311.icscorp.gui;

import java.util.ArrayList;
import java.util.List;

import edu.metrostate.ics311.icscorp.Record;
import edu.metrostate.ics311.icscorp.dbhelper.DbConnector;
import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeTableView extends Application {
	private DbConnector dataAccessor;

	public EmployeeTableView() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		dataAccessor = new DbConnector(); // provide driverName, dbURL, user, password...
		TableView<Record> employeesTable = new TableView<>();
		BorderPane root = new BorderPane();
		VBox viewPicker = new VBox();

		Object[] recInfo = dataAccessor.getTable("employee_info");

		@SuppressWarnings("unchecked")
		List<Record> recordList = (List<Record>) recInfo[0];
		String[][] tableInfo = (String[][]) recInfo[1];
		String[] colNames = tableInfo[0];
		String[] varNames = tableInfo[1];
		System.out.println(recordList.size());

		root.setCenter(employeesTable);
		root.setLeft(viewPicker);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		viewPicker.getChildren().addAll(new Button("Cut"), new Button("Copy"), new Button("Paste"));

		for (int i = 0; i < colNames.length; i++) {
			TableColumn<Record, String> column = new TableColumn<>(colNames[i]);
			column.setCellValueFactory(new PropertyValueFactory<>(varNames[i]));
			employeesTable.getColumns().add(column);
		}

		for (Record record : recordList)
			employeesTable.getItems().add(record);
	}

	@Override
	public void stop() throws Exception {
		if (dataAccessor != null) {
			dataAccessor.close();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}