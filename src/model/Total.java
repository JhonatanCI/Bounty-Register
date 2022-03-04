package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Total {
	public static ObservableList<Register> regis = FXCollections.observableArrayList();
	
	public static int calculateTotal() {
		int sum = 0;
		for (Register i : regis) {
			sum+=i.getMoney();
		}
		return sum;
	}
}
