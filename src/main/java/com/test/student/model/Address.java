/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

public class Address {

	private int d_no;
	private String street;
	private String city;
	private int pin;

	public void setDno(int d_no) {
		this.d_no = d_no;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;

	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getDno() {
		return d_no;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;

	}

	public int getPin() {
		return pin;
	}
}
