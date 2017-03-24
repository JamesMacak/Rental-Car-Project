/**
 * A Van of type Vehicle. Class was created so we have a Van data type. Does not add any new instance variables.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 */
public class Van extends Vehicle {

	/**
	 * Parameterized constructor for a van. Must include the vinNumber,
	 * licensePlate, raw company ID, and retail price because no setters exist.
	 * The specific Company ID for the van. The van's ID modifier = 02
	 * 
	 * @param make
	 *            The make of the van.
	 * @param model
	 *            The model of the van.
	 * @param year
	 *            The year of the van.
	 * @param color
	 *            The color of the van.
	 * @param numberOfCylinders
	 *            The number of cylinders in the van's engine.
	 * @param numberOfDoors
	 *            The number of doors on the van.
	 * @param vinNumber
	 *            The VIN number of the van.
	 * @param licensePlate
	 *            The license plate number of the van.
	 * @param companyID
	 *            The raw company ID for the vehicle.
	 * @param dailyRentalPrice
	 *            The daily rental price of the vehicle.
	 */
	public Van(String make, String model, String year, String color, String numberOfCylinders, String numberOfDoors,
			String vinNumber, String licensePlate, String companyID, double dailyRentalPrice, double currentMiles, double gasCapacity) {
		super(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate, companyID + "-02",
				dailyRentalPrice, currentMiles, gasCapacity);
	}

	/**
	 * Null constructor for a vehicle. However, must include the vinNumber,
	 * licensePlate, raw company ID, and rental price because no setters exist.
	 * 
	 * @param vinNumber
	 *            The VIN number of the vehicle.
	 * @param licensePlate
	 *            The license plate number of the vehicle.
	 * @param companyID
	 *            The raw company ID for the vehicle.
	 * @param dailyRentalPrice
	 *            The daily rental price of the vehicle.
	 */
	public Van(String vinNumber, String licensePlate, String companyID, double dailyRentalPrice) {
		this(null, null, null, null, null, null, vinNumber, licensePlate, companyID + "-02", dailyRentalPrice, 1200.00, 12);
	}

	//////////////////////////////////////////////////////////////////////////

}
