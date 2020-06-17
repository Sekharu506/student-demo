/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

public class Address {

	private int doorNo;
	private String street;
	private String city;
	private int pin;

	public Address() {

	}

	public Address(int doorNo, String street, String city, int pin) {

		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.pin = pin;

	}

	public void setDno(int doorNo) {
		this.doorNo = doorNo;
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
		return doorNo;
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

	public boolean equals(Address address) {
		if (this.doorNo == address.getDno())
			return true;
		else
			return false;

	}

	public int hashCode() {
		return doorNo+street.hashCode()+city.hashCode()+pin;
	}

	public String toString() {
		return " " + doorNo + "         " + street + "          " + city + "         " + pin;
	}
}
