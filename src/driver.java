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
		Dealer.createBasicCustomer("Matt", "Mackenzie", "01/16/1997", "115 86 1747", "MALE",
				"275 Violet Street;Massapequa Park;NY 11762");
		Dealer.createBasicCustomer("Roger", "Smith", "04/26/1962", "114 76 1448", "MALE",
				"4 Eve Drive;Farmingdale;NY 11735");
		Dealer.createBasicCustomer("James", "Macak", "10/27/1999", "082 12 9229", "MALE",
				"2685 Patent Line Rd;Franklin;NY 13775");

		Vehicle car = Dealer.getVehicles().get(0);
		Vehicle truck = Dealer.getVehicles().get(Dealer.getVehicles().size() - 1);

		Dealer.getBasicCustomers().get(3).setWaiting(true);
		Dealer.getBasicCustomers().get(5).setWaiting(true);
		Dealer.getBasicCustomers().get(8).setWaiting(true);
		Dealer.getBasicCustomers().get(13).setWaiting(true);

		Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomers().get(2)).setWaiting(true);
		;
		Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomers().get(7));
		Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomers().get(20));

		Customer c = null;
		try {
			c = Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomer(Dealer.getCustomers().get(18)));
			Rental r1 = new Rental(car, c, "03/12/2017", Rental.getRentalContractNumber(),
					Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());
			Rental r2 = new Rental(truck, c, "03/18/2017", Rental.getRentalContractNumber(),
					Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());

			Rental r3 = new Rental(Dealer.getVehicles().get(4), Dealer.getBasicCustomers().get(7), "03/22/2017",
					Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
					Dealer.getVehicles().get(4).getCurrentMiles(), Dealer.getVehicles().get(4).getGasCapacity());
			Rental r4 = new Rental(Dealer.getVehicles().get(7), Dealer.getBasicCustomers().get(17), "02/12/2017",
					Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
					Dealer.getVehicles().get(7).getCurrentMiles(), Dealer.getVehicles().get(7).getGasCapacity());
			Rental r5 = new Rental(Dealer.getVehicles().get(11), Dealer.getBasicCustomers().get(16), "02/12/2017",
					Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
					Dealer.getVehicles().get(11).getCurrentMiles(), Dealer.getVehicles().get(11).getGasCapacity());
			Rental r6 = new Rental(Dealer.getVehicles().get(12), Dealer.getBasicCustomers().get(18), "02/12/2017",
					Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
					Dealer.getVehicles().get(12).getCurrentMiles(), Dealer.getVehicles().get(12).getGasCapacity());
			Rental r7 = new Rental(Dealer.getVehicles().get(6), Dealer.getBasicCustomers().get(9), "02/12/2017",
					Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
					Dealer.getVehicles().get(6).getCurrentMiles(), Dealer.getVehicles().get(6).getGasCapacity());

			Dealer.addRentalContracts(r1);
			c.returnContract(false, 101, 11);
			Dealer.addRentalContracts(r2);
			Dealer.addRentalContracts(r3);
			Dealer.addRentalContracts(r4);
			Dealer.getBasicCustomers().get(17).returnContract(true, 150, 10);
			Dealer.addRentalContracts(r5);
			Dealer.addRentalContracts(r6);
			Dealer.addRentalContracts(r7);
			

			Dealer.addSale(Double.parseDouble(Dealer.calculateSale(r1)[0]));
			Dealer.addSale(Double.parseDouble(Dealer.calculateSale(r4)[0]));

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Dealer.getCustomers().sort(null);
		DealerGUI GUI = new DealerGUI();
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