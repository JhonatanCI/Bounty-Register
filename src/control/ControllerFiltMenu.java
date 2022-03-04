package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;

public class ControllerFiltMenu {

    @FXML
    private TextField dayTF;

    @FXML
    private TextField monthTF;

    @FXML
    private TextField yearTF;

    @FXML
    private TextField dayTF1;

    @FXML
    private TextField monthTF1;

    @FXML
    private TextField yearTF1;

    @FXML
    private Button enterBUt;

    @FXML
    private Button returnBUt;

    @FXML
    void Filt(ActionEvent event) throws IOException {
    	
    	if(verifyNull()) {
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/Filt.fxml"));
    		loader.setController(new ControllerFilt(dayTF.getText(),monthTF.getText(),yearTF.getText(),dayTF1.getText(),monthTF1.getText(),yearTF1.getText()));
    		Parent parent = (Parent) loader.load();
    		Scene scene = new Scene(parent);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.show();
    		close();
    	}
    	
		
    }

    @FXML
    void close(ActionEvent event) {
    	close();
    }
    
    public boolean verifyNull() {
    	boolean out = false;
    	if(!dayTF.getText().equals("")) {
    		if(!monthTF.getText().equals("")) {
    			if(!yearTF.getText().equals("")) {
    				if(!dayTF.getText().equals("")) {
    					if(!dayTF1.getText().equals("")) {
    			    		if(!monthTF1.getText().equals("")) {
    			    			if(!yearTF1.getText().equals("")) {
    			    				if(!dayTF1.getText().equals("")) {
    			    		    		out=true;
    			    		    	}
    			    	    	}
    			        	}
    			    	}
    		    	}
    	    	}
        	}
    	}
    	return out;
    }
    
    public void close() {
		Stage stage = (Stage) dayTF.getScene().getWindow();
		stage.close();
	}
}
