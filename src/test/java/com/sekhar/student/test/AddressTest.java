package com.sekhar.student.test;

import com.sekhar.student.service.address.impl.AddressServiceImpl;
import com.sekhar.student.service.address.AddressService;
import java.util.Scanner;
import com.sekhar.student.model.Address;

public class AddressTest {
	private Scanner scanner = new Scanner(System.in);

	private AddressService AddressService = null;

	public static void main(String args[])

	{

		AddressTest AddressTest = new AddressTest();

		AddressTest.choosePersistence();
	}

	public void choosePersistence() {

		System.out.println("Enter Where To Store Data");

		String persistence = scanner.next();

		if (persistence.equalsIgnoreCase("IN_MEMORY")) {
			AddressService = new AddressServiceImpl(persistence);
			doOperations(persistence);

		} else if (persistence.equalsIgnoreCase("DB")) {
			AddressService = new AddressServiceImpl(persistence);
			doOperations(persistence);
		} else if (persistence.equalsIgnoreCase("FILE")) {

			AddressService = new AddressServiceImpl(persistence);
			doOperations(persistence);

		}

		else {
			System.out.println("Entered Invaild Persistence");

		}

	}

	public void doOperations(String persistence) {
		System.out.println("Enter Your Choice");
		int choice;
		do {
			System.out.println("Enter 1 To Add Address");
			System.out.println("Enter 2 To Remove Address");
			System.out.println("Enter 3 To Update Address");
			System.out.println("Enter 4 To Display Address");
			System.out.println("Enter 5 To Display Addresses");
			System.out.println("Enter 0 To Exit");
			choice = scanner.nextInt();

			switch (choice) {
			case 0:
				System.exit(1);

			case 1:
				Address address = new Address();
				System.out.println("Enter Dno");

				int doorNo = scanner.nextInt();
				address.setDno(doorNo);
				System.out.println("Enter Street Name");
				String street = scanner.next();
				address.setStreet(street);
				System.out.println("Enter City Name");
				String city = scanner.next();
				address.setCity(city);
				System.out.println("Enter Pincode");
				int pin = scanner.nextInt();
				address.setPin(pin);
				AddressService.addAddress(address);
				break;

			case 2:
				System.out.println("Enter DoorNo");
				doorNo = scanner.nextInt();
				AddressService.removeAddress(doorNo);
				break;
			case 3:
				if (persistence.equalsIgnoreCase("DB")) {
					address = new Address();
					System.out.println("Enter Dno");

					doorNo = scanner.nextInt();
					address.setDno(doorNo);
					System.out.println("Enter Street Name");
					street = scanner.next();
					address.setStreet(street);
					System.out.println("Enter City Name");
					city = scanner.next();
					address.setCity(city);
					System.out.println("Enter Pincode");
					pin = scanner.nextInt();
					address.setPin(pin);

				
				AddressService.updateAddress(address);
				} else {
					System.out.println("This Operations Not Supported");
				}
				break;

			case 4:
				System.out.println("Enter DoorNo");
				doorNo = scanner.nextInt();
				AddressService.getAddress(doorNo);
				break;
			case 5:
				AddressService.getAddresses();
				break;
			default:
				System.out.println("Entered Invaild OPtion");
			}

		} while (true);

	}

}
