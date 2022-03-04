package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Register;
import model.Total;

public class ControllerRegisterMoney implements Initializable{
	public int n;
	
	public ControllerRegisterMoney(int n) {
		this.n = n;
	}

    @FXML
    private TextField moneyTF;

    @FXML
    private TextArea description;

    @FXML
    private TextField dayTF;

    @FXML
    private Button enterBut;

    @FXML
    private Label moneyLabel;

    @FXML
    private TextField monthTF;

    @FXML
    private TextField yearTF;

    @FXML
    void sendMoney(ActionEvent event) {
    	int money = Integer.parseInt(moneyTF.getText());
    	if(n>0) {
    		money *= -1;
    	}
		Total.regis.add(new Register(money,description.getText(),dayTF.getText()+"-"+monthTF.getText()+"-"+yearTF.getText()));
		close();
    }
	
	public void addMoney() {
		moneyLabel.setText("Write the money added");
	}
	
	public void removeMoney() {
		moneyLabel.setText("Write the money spended");
	}
	
	public void close() {
		Stage stage = (Stage) enterBut.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		switch(n) {
		case 0:
			addMoney();
		break;
		case 1:
			removeMoney();
		break;
		}
		
	}

}