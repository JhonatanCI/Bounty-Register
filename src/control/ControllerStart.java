package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import main.Main;

public class ControllerStart {

    @FXML
    private Button tableBut;

    @FXML
    private Button balanceBut;

    @FXML
    private MenuItem addBut;

    @FXML
    private MenuItem buyBut;

    @FXML
    void addMoney(ActionEvent event) throws IOException {
    	callRegister(0);
    }

    @FXML
    void removeMoney(ActionEvent event) throws IOException {
    	callRegister(1);
    }

    @FXML
    void showBalance(ActionEvent event) {

    }

    @FXML
    void showTable(ActionEvent event) {

    }
    
    public void callRegister(int n) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterMoneyWindow.fxml"));
		loader.setController(new ControllerRegisterMoney(n));
		Parent parent = (Parent) loader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

}

