package control;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Register;
import model.Total;

public class ControllerTable implements Initializable{

	@FXML
    private TableView<Register> moneyTable;

    @FXML
    private TableColumn<Register, Integer> moneyCOL;

    @FXML
    private TableColumn<Register, String> descColn;

    @FXML
    private TableColumn<Register, Date> dateColn;

    @FXML
    private Button returnBut;

    @FXML
    void Return(ActionEvent event) {
    	Stage stage = (Stage) returnBut.getScene().getWindow();
		stage.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		moneyCOL.setCellValueFactory(new PropertyValueFactory<>("money"));
		descColn.setCellValueFactory(new PropertyValueFactory<>("description"));
		dateColn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		moneyTable.setItems(Total.regis);
		
		moneyTable.setOnMouseClicked(event->{Register stClicked = moneyTable.getSelectionModel().getSelectedItem();
			showInfo(stClicked);
	});
		}
	
	public void showInfo(Register re) {
		
	}
}

