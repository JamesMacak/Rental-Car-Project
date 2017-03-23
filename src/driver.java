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
		Dealer.createBasicCustomer("Matt", "Mackenzie", "01/16/1997", "115 86 1747", "MALE", "275 Violet Street");
		Dealer.createBasicCustomer("Roger", "Smith", "04/26/1962", "114 76 1448", "MALE", "4 Eve Drive");

		// for (int i = 0; i < Dealer.getCustomers().size(); i++) {
		// System.out.println(Dealer.getCustomers().get(i));
		// }

		Customer matt = Dealer.getCustomers().get(20);
		Vehicle car = Dealer.getVehicles().get(0);
		System.out.println(matt);

		Rental r1 = new Rental(car, matt, "01/16/2017", Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
				car.getCurrentMiles(), car.getGasCapacity());
		Rental r2 = new Rental(car, matt, "02/14/2017", Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
				car.getCurrentMiles(), car.getGasCapacity());
		Rental r3 = new Rental(car, matt, "02/16/2017", Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
				car.getCurrentMiles(), car.getGasCapacity());
		Rental r4 = new Rental(car, matt, "03/16/2017", Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
				car.getCurrentMiles(), car.getGasCapacity());
		Rental r5 = new Rental(car, matt, "03/20/2017", Rental.getRentalContractNumber(), Dealer.CAR_DAILY_RENTAL_PRICE,
				car.getCurrentMiles(), car.getGasCapacity());
		
		System.out.println(matt.isPrivileged());
		try {
			matt.addRentalContract(r1);
			matt.returnContract(false, 12454.3 + 10, 12);
			
			matt.addRentalContract(r2);
			matt.returnContract(false, 12454.3 + 20, 12);
			
			matt.addRentalContract(r3);
			matt.returnContract(false, 12454.3 + 30, 12);
			
			matt.addRentalContract(r4);
			matt.returnContract(false, 12454.3 + 40, 12);
			
			matt.addRentalContract(r5);
			matt.returnContract(false, 12454.3 + 50, 12);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(matt.getRentalContracts().size());
		try {
			System.out.println(Dealer.getPrivilegedCustomer(matt).isPrivileged());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
