/**
 * A class to create objects of type Rental. These objects are contracts that
 * unite a vehicle and a customer.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 *
 */
public class Rental {

	private Vehicle vehicle;
	private Customer customer;

	private String startDate, contractNumber, endDate;
	private double dailyPrice, startMiles, startGasLevel, endMiles, endGasLevel;
	private boolean damageDone, milesUpCharge, gasUpCharge, contractExpired;
	public static int rentalContractNumber = 1;

	/**
	 * A constructor for creating a new rental contract.
	 * 
	 * @param vehicle
	 *            The vehicle to be rented.
	 * @param customer
	 *            The customer that is renting.
	 * @param startDate
	 *            The date the contract was made.
	 * @param contractNumber
	 *            The contract number "XXXXXX"
	 * @param dailyPrice
	 *            The daily price of rental.
	 * @param startMiles
	 *            The miles on the vehicle at the start of the contract.
	 * @param startGasLevel
	 *            The gas level of the vehicle at the start of the contract.
	 *            Should be vehicles max capacity.
	 */
	public Rental(Vehicle vehicle, Customer customer, String startDate, String contractNumber, double dailyPrice,
			double startMiles, double startGasLevel) {
		this.vehicle = vehicle;
		this.customer = customer;
		this.startDate = startDate;
		this.contractNumber = contractNumber;
		this.dailyPrice = dailyPrice;
		this.startMiles = startMiles;
		this.startGasLevel = startGasLevel;
		this.damageDone = false;
		this.milesUpCharge = false;
		this.gasUpCharge = false;
		this.contractExpired = false;
		rentalContractNumber++;
	}

	/**
	 * See if the vehicle has become damaged.
	 * 
	 * @return The truth value.
	 */
	public boolean isDamageDone() {
		return damageDone;
	}

	/**
	 * Set if damage is done.
	 * 
	 * @param damageDone
	 *            boolean.
	 */
	public void setDamageDone(boolean damageDone) {
		this.damageDone = damageDone;
	}

	/**
	 * See if the customer receives mile up charge.
	 * 
	 * @return boolean.
	 */
	public boolean isMilesUpCharge() {
		return milesUpCharge;
	}

	/**
	 * See if the customer receives gas up charge.
	 * 
	 * @return boolean.
	 */
	public boolean isGasUpCharge() {
		return gasUpCharge;
	}

	/**
	 * See if contract is expired.
	 * 
	 * @return boolean.
	 */
	public boolean isContractExpired() {
		return contractExpired;
	}

	/**
	 * Set if contract is expired.
	 * 
	 * @param contractExpired
	 *            boolean.
	 */
	public void setContractExpired(boolean contractExpired) {
		this.contractExpired = contractExpired;
	}

	/**
	 * Get the vehicle associated with the contract.
	 * 
	 * @return The vehicle.
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Get the customer associated with the contract.
	 * 
	 * @return The customer.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Get the start date of the contract.
	 * 
	 * @return The start date.
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Get the contract number of the contract.
	 * 
	 * @return The contract number
	 */
	public String getContractNumber() {
		return contractNumber;
	}

	/**
	 * Get the start date of the contract.
	 * 
	 * @return The start date.
	 */
	public double getDailyPrice() {
		return dailyPrice;
	}

	/**
	 * Set the daily price. Used if the customer is offered a better price.
	 * 
	 * @param dailyPrice
	 *            The new daily price.
	 */
	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	/**
	 * Get the start miles of the vehicle.
	 * 
	 * @return The start miles.
	 */
	public double getStartMiles() {
		return startMiles;
	}

	/**
	 * Get the start gas level of the vehicle. Should be the vehicles max gas
	 * capacity.
	 * 
	 * @return The start date.
	 */
	public double getStartGasLevel() {
		return startGasLevel;
	}

	/**
	 * Get the end miles of the vehicle.
	 * 
	 * @return The end miles.
	 */
	public double getEndMiles() {
		return endMiles;
	}

	/**
	 * Set the end miles of the vehicle.
	 * 
	 * @param endMiles
	 *            The ending miles after the rental.
	 */
	public void setEndMiles(double endMiles) {
		this.endMiles = endMiles;
	}

	/**
	 * Get the end gas level of the vehicle.
	 * 
	 * @return The end gas level.
	 */
	public double getEndGasLevel() {
		return endGasLevel;
	}

	/**
	 * Set the end gas level of the vehicle.
	 * 
	 * @param endGasLevel
	 *            The ending gas level after the rental.
	 */
	public void setEndGasLevel(double endGasLevel) {
		this.endGasLevel = endGasLevel;
	}

	/**
	 * Get the rental contract's number.
	 * 
	 * @return The contract number.
	 */
	public static String getRentalContractNumber() {
		return String.format("%06d", rentalContractNumber);
	}

	/**
	 * Get the end date of the contract. The return date.
	 * 
	 * @return The return date.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Set the end date of the vehicle.
	 * 
	 * @param endDate
	 *            The ending date after the rental.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * A to string method for a Rental object.
	 */
	public String toString() {
		return getRentalContractNumber() + " : " + customer.toString();
	}

	//////////////////////////////////////////////////////

	/**
	 * Check if the miles traveled in the current rental was more than 100. If
	 * yes, milesUpCharge = true.
	 */
	public void checkMiles() {
		if (endMiles - startMiles > 100) {
			milesUpCharge = true;
		}
	}

	/**
	 * Check if the gas tank was refilled, if not, gasUpCharge = true.
	 */
	public void checkGas() {
		if (endGasLevel != startGasLevel) {
			gasUpCharge = true;
		}
	}
	
	public double getMilesTraveled() {
		return endMiles - startMiles;
	}
}
