package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register {
	public int money;
	public String description;
	public Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public Register(int money, String description, String date) {
		this.money = money;
		this.description = description;
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		String todayS = sdf.format(date);
		return todayS;
	}
	
	public Date getDateOb() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
