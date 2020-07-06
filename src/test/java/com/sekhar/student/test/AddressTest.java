package com.sekhar.student.test;

import com.sekhar.student.service.address.impl.AddressServiceImpl;
import com.sekhar.student.service.address.AddressService;
import java.util.Scanner;
import com.sekhar.student.model.Address;

public class AddressTest {
	Scanner sc = new Scanner(System.in);
	StudentTest studenttest = new StudentTest();
	AddressService service;

	public static void main(String a[])

	{

		StudentTest studenttest = new StudentTest();

		studenttest.persistenceChoose();
	}

	public void persistenceChoose() {

		System.out.println("Enter Where To Store Data");
		String persistence = sc.next();
		service = new AddressServiceImpl(persistence);

		if (persistence == "IN_MEMORY") {
			studenttest.InMemory();

		} else if (persistence == "DB") {

			studenttest.Db();
		} else if (persistence == "FILE") {
			studenttest.File();
		}

		else {
			System.out.println("Entered Invaild Persistence");

		}

	}

	public void Inmemory() {
		System.out.println("Enter Your Choice");
		int choice;
		do {
			System.out.println("Enter 1 To Add Address");
			System.out.println("Enter 2 To Remove Address");
			System.out.println("Enter 3 To Display Address");
			System.out.println("Enter 4 To Display Addresses");
			System.out.println("Enter 0 To Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.exit(1);

			case 1:
				Address address = new Address();
				System.out.println("Enter Dno");

				int doorNo = sc.nextInt();
				address.setDno(doorNo);
				System.out.println("Enter Street Name");
				String street = sc.next();
				address.setStreet(street);
				System.out.println("Enter City Name");
				String city = sc.next();
				address.setCity(city);
				System.out.println("Enter Pincode");
				int pin = sc.nextInt();
				address.setPin(pin);
				service.setAddress(address);
				break;

			case 2:
				System.out.println("Enter DoorNo");
				doorNo = sc.nextInt();
				service.removeAddress(doorNo);
				break;

			case 3:
				System.out.println("Enter DoorNo");
				doorNo = sc.nextInt();
				service.getAddress(doorNo);
				break;
			case 4:
				service.getAddresses();
				break;
			default:
				System.out.println("Entered Invaild OPtion");
			}

		} while (true);

	}

	public void Db() {
		System.out.println("Enter Your Choice");
		int choice;
		do {
			System.out.println("Enter 1 To Add Address");
			System.out.println("Enter 2 To Remove Address");
			System.out.println("Enter 3 To Update Address");
			System.out.println("Enter 4 To Display Address");
			System.out.println("Enter 5 To Display Addresses");
			System.out.println("Enter 0 To Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.exit(1);

			case 1:
				Address address = new Address();
				System.out.println("Enter Dno");

				int doorNo = sc.nextInt();
				address.setDno(doorNo);
				System.out.println("Enter Street Name");
				String street = sc.next();
				address.setStreet(street);
				System.out.println("Enter City Name");
				String city = sc.next();
				address.setCity(city);
				System.out.println("Enter Pincode");
				int pin = sc.nextInt();
				address.setPin(pin);
				service.setAddress(address);
				break;

			case 2:
				System.out.println("Enter DoorNo");
				doorNo = sc.nextInt();
				service.removeAddress(doorNo);
				break;
			case 3:
				address = new Address();
				System.out.println("Enter Dno");

				doorNo = sc.nextInt();
				address.setDno(doorNo);
				System.out.println("Enter Street Name");
				street = sc.next();
				address.setStreet(street);
				System.out.println("Enter City Name");
				city = sc.next();
				address.setCity(city);
				System.out.println("Enter Pincode");
				pin = sc.nextInt();
				address.setPin(pin);
				service.setAddress(address);
				break;

			case 4:
				System.out.println("Enter DoorNo");
				doorNo = sc.nextInt();
				service.getAddress(doorNo);
				break;
			case 5:
				service.getAddresses();
				break;
			default:
				System.out.println("Entered Invaild OPtion");
			}

		} while (true);

	}

	public void File() {
		System.out.println("Enter Your Choice");
		int choice;
		do {
			System.out.println("Enter 1 To Create File");
			System.out.println("Enter 1 To Add Address");
			System.out.println("Enter 2 To Remove Address");
			System.out.println("Enter 3 To Display Address");
			System.out.println("Enter 4 To Display Addresses");
			System.out.println("Enter 0 To Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.exit(1);
			case 1:
				System.out.println("Enter File Path");
				String path = sc.next();
				System.out.println("Enter File Name");
				String filename = sc.next();
				service.makeFile(path, filename);
				break;

			case 2:
				Address address = new Address();
				System.out.println("Enter Dno");

				int doorNo = sc.nextInt();
				address.setDno(doorNo);
				System.out.println("Enter Street Name");
				String street = sc.next();
				address.setStreet(street);
				System.out.println("Enter City Name");
				String city = sc.next();
				address.setCity(city);
				System.out.println("Enter Pincode");
				int pin = sc.nextInt();
				address.setPin(pin);
				service.setAddress(address);
				break;

			case 3:
				System.out.println("Enter DoorNo");
				doorNo = sc.nextInt();
				service.removeAddress(doorNo);
				break;

			case 4:
				System.out.println("Enter DoorNo");
				doorNo = sc.nextInt();
				service.getAddress(doorNo);
				break;
			case 5:
				service.getAddresses();
				break;
			default:
				System.out.println("Entered Invaild OPtion");
			}

		} while (true);

	}
}
