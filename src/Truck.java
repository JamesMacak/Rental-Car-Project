
public class Truck extends Vehicle {

	/**
	 * Parameterized constructor for a truck. Must include the vinNumber,
	 * licensePlate, raw company ID, and retail price because no setters exist.
	 * The specific Company ID for the truck. The truck's ID modifier = 03
	 * 
	 * @param make
	 *            The make of the truck.
	 * @param model
	 *            The model of the truck.
	 * @param year
	 *            The year of the truck.
	 * @param color
	 *            The color of the truck.
	 * @param numberOfCylinders
	 *            The number of cylinders in the truck's engine.
	 * @param numberOfDoors
	 *            The number of doors on the truck.
	 * @param vinNumber
	 *            The VIN number of the truck.
	 * @param licensePlate
	 *            The license plate number of the truck.
	 * @param companyID
	 *            The raw company ID for the vehicle.
	 * @param dailyRentalPrice
	 *            The daily rental price of the vehicle.
	 */
	public Truck(String make, String model, String year, String color, String numberOfCylinders, String numberOfDoors,
			String vinNumber, String licensePlate, String companyID, double dailyRentalPrice, double currentMiles, double gasCapacity) {
		super(make, model, year, color, numberOfCylinders, numberOfDoors, vinNumber, licensePlate, companyID + "-03",
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
	public Truck(String vinNumber, String licensePlate, String companyID, double dailyRentalPrice) {
		this(null, null, null, null, null, null, vinNumber, licensePlate, companyID + "-03", dailyRentalPrice, 1200.00, 12);
	}

	//////////////////////////////////////////////////////////////////////////

}
