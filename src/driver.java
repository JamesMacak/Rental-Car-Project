import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) {

		createCompanyCars();
		createCompanyVans();
		createCompanyTrucks();

		// for (int i = 0; i < Dealer.getVehicles().size(); i++) {
		// System.out.println(Dealer.getVehicles().get(i));
		// }

		createSamplePeople();
		Dealer.createBasicCustomer("Matt", "Mackenzie", "01/16/1997", "115 86 1747", "MALE", "275 Violet Street;Massapequa Park;NY 11762");
		Dealer.createBasicCustomer("Roger", "Smith", "04/26/1962", "114 76 1448", "MALE", "4 Eve Drive;Farmingdale;NY 11735");
		Dealer.createBasicCustomer("James", "Macak", "10/27/1999", "082 12 9229", "MALE", "2685 Patent Line Rd;Franklin;NY 13775");

		Vehicle car = Dealer.getVehicles().get(0);
	Customer c = null;
		try {
			c = Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomer(Dealer.getCustomers().get(20)));
			Rental r1 = new Rental(car, c, "03/12/2017", Rental.getRentalContractNumber(),
					Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());
			Rental r2 = new Rental(car, c, "03/18/2017", Rental.getRentalContractNumber(),
					Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());
			Dealer.addRentalContracts(r1);
			c.returnContract(false, 1500, 12);
			Dealer.addSale(Double.parseDouble(Dealer.calculateSale(r1)));
			
			Dealer.addRentalContracts(r2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(c.getActiveRentalContract());
		
		Dealer.getCustomers().sort(null);
		DealerGUI GUI = new DealerGUI();
		
		Vehicle v = Dealer.getVehicles().get(0);
		System.out.println(v.isAvailable());
		//System.out.println(v.getCompanyID().charAt(v.getCompanyID().length() - 1));
	
		GUI.run();

	}

	/////////////////////////////////////////////////////////

	public static void createSamplePeople() {
		String fileName = "res/customers.txt";
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
		String fileName = "res/cars.txt";
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
		String fileName = "res/vans.txt";
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
		String fileName = "res/trucks.txt";
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