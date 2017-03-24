/**
 * This class defines a basic customer, which receives priority treatment and
 * perks.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 */
public class Basic extends Customer {

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
	 *            The street address of the person.
	 * @param customerID
	 *            The customer ID number of the person.
	 */
	public Basic(String firstName, String lastName, String dateOfBirth, String socialSecurityNumber, String age,
			String gender, String address, String customerID) {
		super(firstName, lastName, dateOfBirth, socialSecurityNumber, age, gender, address, customerID);
	}

	/**
	 * Default constructor.
	 * 
	 * @param dateOfBirth
	 *            The date of birth of the person.
	 * @param socialSecurityNumber
	 *            The social security number of the person.
	 * @param customerIDThe
	 *            customer ID number of the person.
	 */
	public Basic(String socialSecurityNumber, String customerID) {
		super(socialSecurityNumber, customerID);
	}

	/**
	 * Return the customerID, lastName, firstName as a string
	 * 
	 * @return customerID : lastName, firstName
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * Overrides the equals method in customer, and calls upon it.
	 * 
	 * @param otherCustomer
	 * @return true or false
	 */
	public boolean equals(Customer otherCustomer) {
		return super.equals(otherCustomer);
	}
}
