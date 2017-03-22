import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

	public static void createCar(String make, String model, String year, String color, String numberOfCylinders,
			String numberOfDoors, String vinNumber, String licensePlate, double currentMiles, double gasCapacity) {
		Car car = new Car(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate,
				generateCompanyIDNumber(), CAR_DAILY_RENTAL_PRICE, currentMiles, gasCapacity);

		vehicles.add(car);
	}

	public static void createVan(String make, String model, String year, String color, String numberOfCylinders,
			String numberOfDoors, String vinNumber, String licensePlate, double currentMiles, double gasCapacity) {
		Van van = new Van(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate,
				generateCompanyIDNumber(), VAN_DAILY_RENTAL_PRICE, currentMiles, gasCapacity);

		vehicles.add(van);
	}

	public static void createTruck(String make, String model, String year, String color, String numberOfCylinders,
			String numberOfDoors, String vinNumber, String licensePlate, double currentMiles, double gasCapacity) {
		Truck truck = new Truck(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate,
				generateCompanyIDNumber(), TRUCK_DAILY_RENTAL_PRICE, currentMiles, gasCapacity);

		vehicles.add(truck);
	}

	// ******************************************* //

	public static void createBasicCustomer(String firstName, String lastName, String dateOfBirth,
			String socialSecurityNumber, String gender, String address) {
		Basic customer = new Basic(firstName, lastName, dateOfBirth, socialSecurityNumber, calculateAge(dateOfBirth),
				gender, address, generateCustomerIDNumber());

		customers.add(customer);
		basicCustomers.add(customer);

	}
	/////////////////////////////////////////////

	public static void addSale(double sale) {
		sales += sale;
	}

	public static String calculateSale(Rental contract) {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String inputString1 = contract.getDate();
		String inputString2 = getDate();

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

		return String.format("%.2f", cost);

	}

	public static void changeToPrivledgedCustomer(Basic customer) {
		String[] data = customer.getData();
		Privileged newprivileged = new Privileged(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
				data[7]);

		customers.remove(customer);
		customers.add(newprivileged);

		basicCustomers.remove(customer);
		privilegedCustomers.add(newprivileged);
	}

	public static void changeToBasicCustomer(Privileged customer) {
		String[] data = customer.getData();
		Basic newBasic = new Basic(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);

		customers.remove(customer);
		customers.add(newBasic);

		privilegedCustomers.remove(customer);
		basicCustomers.add(newBasic);
	}

	/**
	 * This method generates a random raw company ID number. This also adds each
	 * number to a list of all account numbers. This method will check ecah
	 * genrated number against the list, and if there is already an account
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
	 * number to a list of all account numbers. This method will check ecah
	 * genrated number against the list, and if there is already an account
	 * number that exists that is the same as the generated one, the method will
	 * generate a new one and check it all the same.
	 * 
	 * @return The newly generated customer ID number. (xxxxxx)
	 */
	private static String generateCustomerIDNumber() {

		boolean notNew = false;

		Random rand = new Random();
		int xxxxxx = 100000 + rand.nextInt(900000);
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

	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return format.format(date);
	}

	private static String calculateAge(String dob) {

		int year = Integer.parseInt(dob.substring(6));
		int month = Integer.parseInt(dob.substring(0, 2));
		int day = Integer.parseInt(dob.substring(3, 5));

		LocalDate birthday = LocalDate.of(year, Month.of(month), day);
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthday, today);

		return Integer.toString(p.getYears());

	}

}
