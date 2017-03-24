import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A class to use as a static dealer. The dealer can perform operations for
 * Rental, Person, and Vehicle.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 *
 */
public class Dealer {

	public static final double CAR_DAILY_RENTAL_PRICE = 39.95;
	public static final double VAN_DAILY_RENTAL_PRICE = 49.95;
	public static final double TRUCK_DAILY_RENTAL_PRICE = 45.95;

	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Privileged> privilegedCustomers = new ArrayList<Privileged>();
	private static ArrayList<Basic> basicCustomers = new ArrayList<Basic>();

	private static ArrayList<String> allCompanyIDNumbers = new ArrayList<String>();
	private static ArrayList<String> allCustomerIDNumbers = new ArrayList<String>();

	private static double sales = 0.00;

	/**
	 * Constructor to create a new Dealer. The Dealer houses 6 array lists,
	 * vehicles, customers, privileged customers, basic customers, all company
	 * IDs in use, and all customer IDs in use.
	 */
	public Dealer() {
		sales = 0.00;
	}

	/**
	 * Get the vehicle list.
	 * 
	 * @return The vehicle list.
	 */
	public static ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * Get the customer list.
	 * 
	 * @return The customer list.
	 */
	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * Get the privileged customer list.
	 * 
	 * @return The privileged customer list.
	 */
	public static ArrayList<Privileged> getPrivilegedCustomers() {
		return privilegedCustomers;
	}

	/**
	 * Get the basic customer list.
	 * 
	 * @return The basic customer list.
	 */
	public static ArrayList<Basic> getBasicCustomers() {
		return basicCustomers;
	}

	/**
	 * Get the total sales of the dealer
	 * 
	 * @return
	 */
	public static String getSales() {
		return String.format("%.2f", sales);
	}

	//////////////////////////////////////////////

	/**
	 * Create a new car and add it to the array of vehicles.
	 * 
	 * **See car class for parameter descriptions. A company ID is generated and
	 * given to the car, and the price is given.
	 * 
	 * @param make
	 * @param model
	 * @param year
	 * @param color
	 * @param numberOfCylinders
	 * @param numberOfDoors
	 * @param vinNumber
	 * @param licensePlate
	 * @param currentMiles
	 * @param gasCapacity
	 */
	public static void createCar(String make, String model, String year, String color, String numberOfCylinders,
			String numberOfDoors, String vinNumber, String licensePlate, double currentMiles, double gasCapacity) {
		Car car = new Car(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate,
				generateCompanyIDNumber(), CAR_DAILY_RENTAL_PRICE, currentMiles, gasCapacity);

		vehicles.add(car);
	}

	/**
	 * Create a new van and add it to the array of vehicles.
	 * 
	 * **See car class for parameter descriptions. A company ID is generated and
	 * given to the van, and the price is given.
	 * 
	 * @param make
	 * @param model
	 * @param year
	 * @param color
	 * @param numberOfCylinders
	 * @param numberOfDoors
	 * @param vinNumber
	 * @param licensePlate
	 * @param currentMiles
	 * @param gasCapacity
	 */
	public static void createVan(String make, String model, String year, String color, String numberOfCylinders,
			String numberOfDoors, String vinNumber, String licensePlate, double currentMiles, double gasCapacity) {
		Van van = new Van(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate,
				generateCompanyIDNumber(), VAN_DAILY_RENTAL_PRICE, currentMiles, gasCapacity);

		vehicles.add(van);
	}

	/**
	 * Create a new truck and add it to the array of vehicles.
	 * 
	 * **See car class for parameter descriptions. A company ID is generated and
	 * given to the van, and the price is given.
	 * 
	 * @param make
	 * @param model
	 * @param year
	 * @param color
	 * @param numberOfCylinders
	 * @param numberOfDoors
	 * @param vinNumber
	 * @param licensePlate
	 * @param currentMiles
	 * @param gasCapacity
	 */
	public static void createTruck(String make, String model, String year, String color, String numberOfCylinders,
			String numberOfDoors, String vinNumber, String licensePlate, double currentMiles, double gasCapacity) {
		Truck truck = new Truck(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate,
				generateCompanyIDNumber(), TRUCK_DAILY_RENTAL_PRICE, currentMiles, gasCapacity);

		vehicles.add(truck);
	}

	// ******************************************* //

	/**
	 * Create a new basic customer.
	 * 
	 * See parameter description in customer class. Age is calculated based on
	 * the date of birth, and the customer is given a random ID.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param socialSecurityNumber
	 * @param gender
	 * @param address
	 * @return The new cutomer.
	 */
	public static Customer createBasicCustomer(String firstName, String lastName, String dateOfBirth,
			String socialSecurityNumber, String gender, String address) {
		Basic customer = new Basic(firstName, lastName, dateOfBirth, socialSecurityNumber, calculateAge(dateOfBirth),
				gender, address, generateCustomerIDNumber());

		customers.add(customer);
		basicCustomers.add(customer);

		return customer;

	}
	/////////////////////////////////////////////

	/**
	 * Add a sale to the total sales.
	 * 
	 * @param sale
	 *            The amount to add.
	 */
	public static void addSale(double sale) {
		sales += sale;
	}

	/**
	 * Calculate a sale. $200 fine for damage. $50 fine for more than 100 miles.
	 * $20 fine for not filling up the tank.
	 * 
	 * @param contract
	 *            The finished contract to calculate the days since rented.
	 * @return A string of the price formated "%.2f"
	 */
	public static String calculateSale(Rental contract) {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String inputString1 = contract.getStartDate();
		String inputString2 = contract.getEndDate();

		int days = 0;
		try {
			Date date1 = format.parse(inputString1);
			Date date2 = format.parse(inputString2);
			long diff = date2.getTime() - date1.getTime();
			days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.getMessage();
		}

		double cost = days * contract.getDailyPrice();

		if (contract.isDamageDone())
			cost += 200.00;
		if (contract.isMilesUpCharge())
			cost += 50.00;
		if (contract.isGasUpCharge())
			cost += 20.00;

		return String.format("%.2f", cost);

	}

	/**
	 * Change a basic customer to a privileged customer.
	 * 
	 * @param customer
	 *            The basic customer to change.
	 */
	public static Privileged changeToPriviledgedCustomer(Basic customer) {
		String[] data = customer.getData();
		Privileged newprivileged = new Privileged(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
				data[7]);

		customers.remove(customer);
		customers.add(newprivileged);

		basicCustomers.remove(customer);
		privilegedCustomers.add(newprivileged);

		newprivileged.setPrivileged(true);

		return newprivileged;
	}

	/**
	 * Change a privileged customer to a basic customer.
	 * 
	 * @param customer
	 *            The privileged customer to change.
	 */
	public static Basic changeToBasicCustomer(Privileged customer) {
		String[] data = customer.getData();
		Basic newBasic = new Basic(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);

		customers.remove(customer);
		customers.add(newBasic);

		privilegedCustomers.remove(customer);
		basicCustomers.add(newBasic);

		newBasic.setPrivileged(false);

		return newBasic;

	}

	/**
	 * This method generates a random raw company ID number. This also adds each
	 * number to a list of all account numbers. This method will check each
	 * generated number against the list, and if there is already an account
	 * number that exists that is the same as the generated one, the method will
	 * generate a new one and check it all the same.
	 * 
	 * @return The newly generated company ID number. (xxxx)
	 */
	private static String generateCompanyIDNumber() {

		boolean notNew = false;

		Random rand = new Random();
		int xxxx = 1000 + rand.nextInt(9000);
		String newNumber = Integer.toString(xxxx);

		for (int i = 0; i < allCompanyIDNumbers.size(); i++) {
			if (newNumber.equals(allCompanyIDNumbers.get(i))) {
				notNew = true;
			}
		}

		if (!notNew)
			allCompanyIDNumbers.add(newNumber);

		return (notNew) ? generateCompanyIDNumber() : newNumber;
	}

	/**
	 * This method generates a random customer ID number. This also adds each
	 * number to a list of all account numbers. This method will check each
	 * generated number against the list, and if there is already an account
	 * number that exists that is the same as the generated one, the method will
	 * generate a new one and check it all the same.
	 * 
	 * @return The newly generated customer ID number. (xxxxxxx)
	 */
	private static String generateCustomerIDNumber() {

		boolean notNew = false;

		Random rand = new Random();
		int xxxxxx = 1000000 + rand.nextInt(9000000);
		String newNumber = Integer.toString(xxxxxx);

		for (int i = 0; i < allCustomerIDNumbers.size(); i++) {
			if (newNumber.equals(allCustomerIDNumbers.get(i))) {
				notNew = true;
			}
		}

		if (!notNew)
			allCustomerIDNumbers.add(newNumber);

		return (notNew) ? generateCustomerIDNumber() : newNumber;
	}

	/**
	 * Get today's date
	 * 
	 * @return Today's date in "MM/dd/yyyy"
	 */
	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return format.format(date);
	}

	/**
	 * Calculate someone's age from their date of birth.
	 * 
	 * @param dob
	 *            Date of birth in "mm/dd/yyyy"
	 * @return The amount of years from that date to today.
	 */
	public static String calculateAge(String dob) {

		int year = Integer.parseInt(dob.substring(6));
		int month = Integer.parseInt(dob.substring(0, 2));
		int day = Integer.parseInt(dob.substring(3, 5));

		LocalDate birthday = LocalDate.of(year, Month.of(month), day);
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthday, today);

		return Integer.toString(p.getYears());

	}

	/**
	 * Method to return the car itself. This will add the miles traveled to the
	 * car, and set it to available.
	 * 
	 * @param contract
	 */
	public static void returnVehicle(Rental contract) {
		Vehicle v = contract.getVehicle();

		v.addMiles(contract.getMilesTraveled());
		v.setAvailable();
	}

	/**
	 * Get a generic customer from their ID.
	 * 
	 * @param customerID
	 *            The ID of the customer you are looking for.
	 * @return The found customer.
	 * @throws Exception
	 *             "No Customer Exists." If no such customer exists.
	 */
	public static Customer getCustomer(String customerID) throws Exception {
		for (Customer customer : customers) {
			if (customerID.equals(customer.getCustomerID())) {
				return customer;
			}
		}
		throw new Exception("No Customer Exists.");
	}

	/**
	 * Get a privileged customer from a generic customer.
	 * 
	 * @param customer
	 *            The privileged customer you are looking for.
	 * @return The found customer.
	 * @throws Exception
	 *             "No Customer Exists." If no such customer exists.
	 */
	public static Privileged getPrivilegedCustomer(Customer customer) throws Exception {
		for (Privileged privileged : privilegedCustomers) {
			if (customer.equals(privileged)) {
				return privileged;
			}
		}
		throw new Exception("No Customer Exists.");
	}

	/**
	 * Get a basic customer from a generic customer.
	 * 
	 * @param customer
	 *            The basic customer you are looking for.
	 * @return The found customer.
	 * @throws Exception
	 *             "No Customer Exists." If no such customer exists.
	 */
	public static Basic getBasicCustomer(Customer customer) throws Exception {
		for (Basic basic : basicCustomers) {
			if (customer.equals(basic)) {
				return basic;
			}
		}
		throw new Exception("No Customer Exists,");
	}
	
	public static void addRentalContracts (Rental rental) {
		try {
			rental.getCustomer().addRentalContract(rental);
			rental.getVehicle().addRentalContract(rental);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
