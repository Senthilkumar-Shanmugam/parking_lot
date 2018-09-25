package com.assigment.GOJEK;

public class Car {
	private String RegNum;
	private Color color;
	

	public Car() {
	}


	public Car(String regNum, Color color) {
		this.RegNum = regNum;
		this.color = color;
	}


	public String getRegNum() {
		return RegNum;
	}


	public void setRegNum(String regNum) {
		RegNum = regNum;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	

}
