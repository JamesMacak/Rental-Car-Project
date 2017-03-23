public class driver {

	public static void main(String[] args) {

		System.out.println("OHMIGOD ITS WORKNG!!!");

		/** TEST COMMENT */

		// public Vehicle(String make, String model, String year, String color,
		// String numberOfCylinders, String numberOfDoors,
		// String vinNumber, String licensePlate, String companyID, double
		// dailyRentalPrice)

		Dealer.createCar("MAZDA", "6", "2004", "GREY", "6", "4", "1G4PP5SKXD4109257", "GIH 2596", 12454.3, 12);
		Dealer.createVan("Honda", "Oddesy", "2006", "blue", "6", "4", "1GC1CVEG1FF165298", "GIY 5816", 500.4, 18);
		Dealer.createTruck("Ford", "S1", "2012", "black", "6", "4", "5NPDH4AE9FH572174", "FWJ 6551", 123345.55, 22);

		Dealer.createBasicCustomer("Matt", "Mackenzie", "01/16/1997", "115 86 1747", "MALE", "275 Violet Street");
		Dealer.createBasicCustomer("Roger", "Smith", "04/26/1962", "114 76 1448", "MALE", "4 Eve Drive");

		Dealer.changeToPriviledgedCustomer(Dealer.getBasicCustomers().get(0));

		Customer matt = Dealer.getPrivilegedCustomers().get(0);
		Vehicle car = Dealer.getVehicles().get(0);

		Rental rental1 = new Rental(car, matt, "03/12/2017", Rental.getRentalContractNumber(),
				Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());
		Rental rental2 = new Rental(car, matt, "03/18/2017", Rental.getRentalContractNumber(),
				Dealer.CAR_DAILY_RENTAL_PRICE, car.getCurrentMiles(), car.getGasCapacity());

		System.out.println(rental2.getContractNumber());
		
		
		try {
			matt.addRentalContract(rental1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		car.addRentalContract(rental1);

		
		String s = "$ ";
		try {
			Dealer.addSale(Double.parseDouble(Dealer.calculateSale(matt.returnContract(false, 12, 12))));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
	
		System.out.println(s + Dealer.getSales());
	}
}
