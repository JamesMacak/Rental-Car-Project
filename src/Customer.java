import java.util.ArrayList;

/**
 * Customer class includes a customer ID and extends the generic Person class.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 */
public class Customer extends Person {

	private String customerID;
	private ArrayList<Rental> rentalContracts = new ArrayList<Rental>();

	private boolean privileged, waiting;

	/**
	 * Parameterized constructor accepts all attributes of a customer.
	 * 
	 * @param firstName
	 *            The first name of the person.
	 * @param lastName
	 *            The last name of the person.
	 * @param dateOfBirth
	 *            The date of birth of the person.
	 * @param socialSecurityNumber
	 *            The social security number of the person.
	 * @param age
	 *            The age of the person.
	 * @param gender
	 *            The gender of the person.
	 * @param address
	 *            The street adress of the person.
	 * @param customerID
	 *            The customer ID number of the person.
	 */
	public Customer(String firstName, String lastName, String dateOfBirth, String socialSecurityNumber, String age,
			String gender, String address, String customerID) {
		super(firstName, lastName, dateOfBirth, socialSecurityNumber, age, gender, address);
		this.customerID = customerID;
		this.privileged = false;
		this.waiting = false;
	}

	/**
	 * Default constructor, that requires a Social Security Number
	 * 
	 * @param socialSecurityNumber
	 */
	public Customer(String socialSecurityNumber, String customerID) {
		super(socialSecurityNumber);
		this.customerID = customerID;
	}

	/**
	 * Gets the customerID
	 * 
	 * @return customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customerID
	 * 
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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

	public boolean isPrivileged() {
		return privileged;
	}

	public void setPrivileged(boolean privileged) {
		if (rentalContracts.size() >= 5) {
			privileged = true;
		}
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	/**
	 * //public Rental getRentalContract() { return rentalContract; } //public
	 * void setRentalContract(Rental rentalContract) { this.rentalContract =
	 * rentalContract(); }
	 * 
	 * /** Compare two customers if they are equal
	 * 
	 * @param otherCustomer
	 * @return true or false
	 */
	public boolean equals(Customer otherCustomer) {
		return this.customerID.equals(otherCustomer.customerID);
	}

	/**
	 * Return the customerID, lastName, firstName as a string
	 * 
	 * @return customerID : lastname, firstName
	 */
	public String toString() {
		return this.customerID + " : " + super.toString();
	}

	/**
	 * Compare two customers and return -1, 0, 1 if it is less than, equal to,
	 * greater than, respectively.
	 */
	@Override
	public int compareTo(Object o) {
		Customer otherCustomer = (Customer) o;
		return this.customerID.compareTo(otherCustomer.customerID);
	}

	/**
	 * Get the data of the customer, all instance variables.
	 * 
	 * @return The data.
	 */
	public String[] getData() {
		String[] data = { getFirstName(), getLastName(), getDateOfBirth(), getSocialSecurityNumber(), getAge(),
				getGender(), getAddress(), customerID };
		return data;
	}

	/////////////////////////////////////////

	/**
	 * Add a contract to the customer.
	 * 
	 * @param contract
	 *            The contract to add.
	 * @throws Exception
	 *             "Contract Expired" will throw if you try to add an already
	 *             expired contract.
	 */
	public void addRentalContract(Rental contract) throws Exception {
		if (contract.isContractExpired()) {
			throw new Exception("Contract Expired.");
		} else {
			rentalContracts.add(contract);
		}

	}

	/**
	 * Return the vehicle after using it, thus ending the contract. This will
	 * return the contract that you are turning in.
	 * 
	 * @param damaged
	 *            If the vehicle bacame damaged during use.
	 * @param endMiles
	 *            How many miles are now on the vehicle
	 * @param endGasLevel
	 *            The gas level of the vehicle after use.
	 * @return The contract to turn in.
	 * 
	 * @throws Exception
	 *             "No Active Contract." will throw if there is no active
	 *             contract to turn in.
	 */
	public Rental returnContract(boolean damaged, double endMiles, double endGasLevel) throws Exception {
		if (this.getActiveRentalContract() == null) {
			throw new Exception("No Active Contract.");
		} else {
			Rental currentContract = getActiveRentalContract();
			currentContract.setDamageDone(damaged);
			currentContract.setEndMiles(endMiles);
			currentContract.setEndGasLevel(endGasLevel);
			currentContract.setContractExpired(true);
<<<<<<< HEAD
=======

			Dealer.returnVehicle(currentContract);
>>>>>>> origin/master

			return currentContract;
		}
	}
}
