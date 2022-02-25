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

public class ControllerRegisterMoney implements Initializable{

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

    }
    
    public int n;
    
    public ControllerRegisterMoney(int n) {
		this.n = n;
	}
	
	public void addMoney() {
		moneyLabel.setText("Write the money added");
	}
	
	public void removeMoney() {
		moneyLabel.setText("Write the money spended");
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