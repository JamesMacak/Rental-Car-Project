import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) {

		createCompanyCars();
		createCompanyVans();
		createCompanyTrucks();

		for (int i = 0; i < Dealer.getVehicles().size(); i++) {
			System.out.println(Dealer.getVehicles().get(i));
		}

		System.out.println("");

		createSamplePeople();
		Dealer.createBasicCustomer("Matt", "Mackenzie", "01/16/1997", "115 86 1747", "MALE", "275 Violet Street");
		Dealer.createBasicCustomer("Roger", "Smith", "04/26/1962", "114 76 1448", "MALE", "4 Eve Drive");

		for (int i = 0; i < Dealer.getCustomers().size(); i++) {
			System.out.println(Dealer.getCustomers().get(i));
		}

		Scanner key = new Scanner(System.in);
		String id = key.nextLine();
		Customer c = null;

		System.out.println("\n" + Dealer.getCustomers().get(2).getCustomerID());
		System.out.println(id);
		try {
<<<<<<< HEAD
			 c = Dealer.getCustomer(id);
			 System.out.println(c.isPrivileged());
=======
			c = Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomer(Dealer.getCustomers().get(20)));
			Rental r1 = new Rental(car, c, "03/12/2017", Rental.getRentalContractNumber(),
					Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());
			Rental r2 = new Rental(car, c, "03/18/2017", Rental.getRentalContractNumber(),
					Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());
			Dealer.addRentalContracts(r1);
			c.returnContract(false, 1500, 12);
			Dealer.addSale(Double.parseDouble(Dealer.calculateSale(r1)));
			
			Dealer.addRentalContracts(r2);
			
>>>>>>> master
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(c.isPrivileged());
		
<<<<<<< HEAD
		// Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomer(c));
=======
		//System.out.println(c.getActiveRentalContract());
		
		Dealer.getCustomers().sort(null);
		//DealerGUI GUI = new DealerGUI();
		
		Vehicle v = Dealer.getVehicles().get(0);
		System.out.println(v.isAvailable());
		//System.out.println(v.getCompanyID().charAt(v.getCompanyID().length() - 1));
	
		//GUI.run();
>>>>>>> master

		key.close();
	}

	/////////////////////////////////////////////////////////

	public static void createSamplePeople() {
		String fileName = "/Users/Mattmacks/Desktop/customers.txt";
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			String[] data = line.split(",");

			Dealer.createBasicCustomer(data[0], data[1], data[2], data[3], data[4], data[5]);
		}
	}

	public static void createCompanyCars() {
		String fileName = "/Users/Mattmacks/Desktop/cars.txt";
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			String[] data = line.split(",");

			Dealer.createCar(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],
					Double.parseDouble(data[8]), Double.parseDouble(data[9]));
		}
	}

	public static void createCompanyVans() {
		String fileName = "/Users/Mattmacks/Desktop/vans.txt";
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			String[] data = line.split(",");

			Dealer.createVan(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],
					Double.parseDouble(data[8]), Double.parseDouble(data[9]));
		}
	}

	public static void createCompanyTrucks() {
		String fileName = "/Users/Mattmacks/Desktop/trucks.txt";
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			String[] data = line.split(",");

			Dealer.createTruck(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],
					Double.parseDouble(data[8]), Double.parseDouble(data[9]));
		}
	}

}
