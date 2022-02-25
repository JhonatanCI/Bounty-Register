package model;

import java.util.Date;

public class Register {
	public int money;
	public String description;
	public Date date;
	
	public Register(int money, String description, Date date) {
		this.money = money;
		this.description = description;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
