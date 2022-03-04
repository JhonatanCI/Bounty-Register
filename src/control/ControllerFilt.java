package control;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Register;
import model.Total;

public class ControllerFilt implements Initializable{

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
    
    public static ObservableList<Register> filtred = FXCollections.observableArrayList();
    
    public Date initDate;
    
    public Date endDate;
    
    public String day1;

    
    public String month1;

    
    public String year1;

    
    public String day2;

    public String month2;

    
    public String year2;

    @FXML
    void Return(ActionEvent event) {
    	filtred.clear();
    	close();
    }
    
    
    public ControllerFilt(String day, String month, String year,String day1,String month1, String year1) {
    	this.day1=day;
    	this.month1=month;
    	this.year1=year;
    	this.day2=day1;
    	this.month2=month1;
    	this.year2=year1;
    }
    public void close() {
		Stage stage = (Stage) returnBut.getScene().getWindow();
		stage.close();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		moneyCOL.setCellValueFactory(new PropertyValueFactory<>("money"));
		descColn.setCellValueFactory(new PropertyValueFactory<>("description"));
		dateColn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			initDate = sdf.parse(day1+"-"+month1+"-"+year1);
			endDate = sdf.parse(day2+"-"+month2+"-"+year2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Register r : Total.regis) {
			if(r.getDateOb().getTime()>=initDate.getTime()&&r.getDateOb().getTime()<=endDate.getTime()) {
				filtred.add(r);
			}
		}
		moneyTable.setItems(filtred);
		totalLab.setText("Total: "+calculateTotal());
	}
	
	public static int calculateTotal() {
		int sum = 0;
		for (Register i : filtred) {
			sum+=i.getMoney();
		}
		return sum;
	}
}

