/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.student.model;

/**
 *
 * @author kalyani
 */
public class Address {

	public int d_no;
	private String street;
	private String city;
	private int pin;

	public Address(int d_no, String street, String city, int pin) {
		this.d_no = d_no;
		this.street = street;
		this.city = city;
		this.pin = pin;

	}

	public void getAddress() {
		System.out.println("DoorNo    Street      city       pin");
		System.out.println(" " + d_no + "      " + street + "      " + city + "      " + pin);
	}
}
