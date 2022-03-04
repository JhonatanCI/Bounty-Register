package control;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Register;
import model.Total;

public class ControllerShowInfo implements Initializable{
	
	@FXML
    private TextArea info;

    @FXML
    private Button deleteBUT;

    @FXML
    private Button closeBUT;
	
	public Register re;
	
	@FXML
    void close(ActionEvent event) {
		close();
    }

    @FXML
    void delete(ActionEvent event) {
    	for(int i= 0; i<Total.regis.size();i++) {
    		if(Total.regis.get(i)==re) {
    			Total.regis.remove(i);
    		}
    	}
    	close();
    }
	
	public ControllerShowInfo(Register re) {
		
		this.re = re;
		
	}
	
	public void close() {
		Stage stage = (Stage) deleteBUT.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		info.setText("El valor de la movida es "+re.getMoney()+"\n"+
		re.getDescription()+"\n"+
		"La fecha es "+re.getDate());
	}
	
	
	
}
