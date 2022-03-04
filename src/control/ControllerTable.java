package control;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
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
    private Label totalLab;
    
    @FXML
    private Button filtBut;

    @FXML
    void Filt(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/FiltMenu.fxml"));
		loader.setController(new ControllerFiltMenu());
		Parent parent = (Parent) loader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

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
		
		totalLab.setText("Total: "+Total.calculateTotal());
		
		moneyTable.setOnMouseClicked(event->{Register stClicked = moneyTable.getSelectionModel().getSelectedItem();
			try {
				showInfo(stClicked);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	});
		}
	
	public void showInfo(Register re) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ShowInfo.fxml"));
		loader.setController(new ControllerShowInfo(re));
		Parent parent = (Parent) loader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
}

