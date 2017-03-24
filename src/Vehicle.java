import java.util.ArrayList;

/**
 * Abstract vehicle class.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 */
public abstract class Vehicle implements Comparable<Vehicle> {

	private String make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate, companyID;
	private double dailyRentalPrice, currentMiles, gasCapacity;

	private boolean available;

	private ArrayList<Rental> rentalContracts = new ArrayList<Rental>();

	/**
	 * Parameterized constructor for a vehicle. Must include the vinNumber and
	 * licensePlate because no setters exist.
	 * 
	 * @param make
	 *            The make of the vehicle.
	 * @param model
	 *            The model of the vehicle.
	 * @param year
	 *            The year of the vehicle.
	 * @param color
	 *            The color of the vehicle.
	 * @param numberOfCylinders
	 *            The number of cylinders in the vehicle's engine.
	 * @param numberOfDoors
	 *            The number of doors on the vehicle.
	 * @param vinNumber
	 *            The VIN number of the vehicle.
	 * @param licensePlate
	 *            The license plate number of the vehicle.
	 */
	public Vehicle(String make, String model, String year, String color, String numberOfCylinders, String numberOfDoors,
			String vinNumber, String licensePlate, String companyID, double dailyRentalPrice, double currentMiles,
			double gasCapacity) {
		this.make = make.toUpperCase();
		this.model = model.toUpperCase();
		this.year = year;
		this.color = color.toUpperCase();
		this.numberOfCylinders = numberOfCylinders;
		this.numberOfDoors = numberOfDoors;
		this.vinNumber = vinNumber;
		this.licensePlate = licensePlate.toUpperCase();
		this.companyID = companyID;

		this.dailyRentalPrice = dailyRentalPrice;
		this.currentMiles = currentMiles;
		this.gasCapacity = gasCapacity;

		this.available = true;
	}

	/**
	 * Null constructor for a vehicle. However, must include the vinNumber and
	 * licensePlate and rental price because no setters exist.
	 * 
	 * @param vinNumber
	 *            The VIN number of the vehicle.
	 * @param licensePlate
	 *            The license plate number of the vehicle.
	 */
	public Vehicle(String vinNumber, String licensePlate, String companyID, double dailyRentalPrice) {
		this(null, null, null, null, null, null, vinNumber, licensePlate, companyID, dailyRentalPrice, 1200.00, 12);
	}

	/**
	 * Get vehicle's make.
	 * 
	 * @return The vehicle's make.
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Set vehicle's make.
	 * 
	 * @param make
	 *            The vehicle's make.
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Get vehicle's model.
	 * 
	 * @return The vehicle's model.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Set vehicle's model.
	 * 
	 * @param model
	 *            The vehicle's model.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Get vehicle's year.
	 * 
	 * @return The vehicle's year.
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Set vehicle's year.
	 * 
	 * @param year
	 *            The vehicle's year.
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Get vehicle's color.
	 * 
	 * @return The vehicle's color.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set vehicle's color.
	 * 
	 * @param color
	 *            The vehicle's color.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Get vehicle's number of cylinders.
	 * 
	 * @return The vehicle's number of cylinders.
	 */
	public String getNumberOfCylinders() {
		return numberOfCylinders;
	}

	/**
	 * Set vehicle's number of cylinders.
	 * 
	 * @param numberOfCylinders
	 *            The vehicle's number of cylinders.
	 */
	public void setNumberOfCylinders(String numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}

	/**
	 * Get vehicle's number of doors.
	 * 
	 * @return The vehicle's number of doors.
	 */
	public String getNumberOfDoors() {
		return numberOfDoors;
	}

	/**
	 * Set vehicle's number of doors.
	 * 
	 * @param numberOfDoors
	 *            The vehicle's number of doors.
	 */
	public void setNumberOfDoors(String numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	/**
	 * Get vehicle's vin number.
	 * 
	 * @return The vehicle's vin number.
	 */
	public String getVinNumber() {
		return vinNumber;
	}

	/**
	 * Get vehicle's license plate number.
	 * 
	 * @return The vehicle's license plate number.
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Get vehicle's license plate number.
	 * 
	 * @return The vehicle's license plate number.
	 */
	public String getCompanyID() {
		return companyID;
	}

	/**
	 * Get vehicle's daily rental price.
	 * 
	 * @return The vehicle's daily rental price.
	 */
	public double getDailyRentalPrice() {
		return dailyRentalPrice;
	}

	/**
	 * Get vehicle's license plate number.
	 * 
	 * @return The vehicle's license plate number.
	 */
	public void setDailyRentalPrice(double dailyRentalPrice) {
		this.dailyRentalPrice = dailyRentalPrice;
	}

	/**
	 * Get vehicle's total miles.
	 * 
	 * @return The vehicle's total miles.
	 */
	public double getCurrentMiles() {
		return currentMiles;
	}

	/**
	 * Get vehicle's gas tank capacity.
	 * 
	 * @return The vehicle's gas tank capacity.
	 */
	public double getGasCapacity() {
		return gasCapacity;
	}

	/**
	 * Get active rental contract.
	 * 
	 * @return the active rental contract.
	 */
	public Rental getActiveRentalContract() {
		for (Rental contract : rentalContracts) {
			if (!contract.isContractExpired()) {
				return contract;
			}
		}
		return null;
	}

	/**
	 * Get the entire list of rental contracts.
	 * 
	 * @return The list of rental contracts.
	 */
	public ArrayList<Rental> getRentalContracts() {
		return rentalContracts;
	}

	/**
	 * Print the basic details of the vehicle: XXXX : YEAR MAKE MODEL
	 * 
	 * ex. "1234 : 2004 MAZDA 6"
	 */
	public String toString() {
		return companyID + " : " + year + " " + make + " " + model;
	}

	/**
	 * Check the equality of two vehicles based on their ID number.
	 * 
	 * @param otherVehicle
	 *            the object being compared
	 */
	public boolean equals(Vehicle otherVehicle) {
		return this.companyID.equals(otherVehicle.companyID);
	}

	/**
	 * Compare two vehicles based on their company ID.
	 */
	@Override
	public int compareTo(Vehicle o) {
		return this.companyID.compareTo(o.companyID);
	}

	//////////////////////////////////////////////////////////////////////////

	/**
	 * This will add the specified amount of miles to the total miles counter on
	 * the car.
	 * 
	 * @param currentTrip
	 *            The number of miles driven on the last trip.
	 */
	public void addMiles(double currentTrip) {
		currentMiles += currentTrip;
	}

	/**
	 * Add a rental contract to the vehicle.
	 * 
	 * @param contract
	 *            The contract to add.
	 */
	public void addRentalContract(Rental contract) {
		rentalContracts.add(contract);
		this.setAvailable();
	}

	/**
	 * Check availability of vehicle.
	 * 
	 * @return boolean.
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Set the availability of the car. If an active contract exists, then the
	 * car is not available.
	 */
	public void setAvailable() {
		if (getActiveRentalContract() != null) {
			available = false;
		} else {
			available = true;
		}
	}
}
