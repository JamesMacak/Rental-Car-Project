/**
 * Generic abstract person class.
 * 
 * @author Matt Mackenzie & James Macak
 * @version 1.0
 */

@SuppressWarnings("rawtypes")
public abstract class Person implements Comparable {

	private String firstName, lastName, dateOfBirth, socialSecurityNumber, age, gender, address;
	private String addressSub1, addressSub2, addressSub3;

	/**
	 * Parameterized constructor, requires all aspects of a person.
	 * 
	 * @param firstName
	 *            First name of the person.
	 * @param lastName
	 *            Last Name of the person.
	 * @param dateOfBirth
	 *            Date of Birth of the person.
	 * @param socialSecurityNumber
	 *            Social Security Number of the person.
	 * @param age
	 *            Age of the person.
	 * @param gender
	 *            Gender of the person.
	 * @param address
	 *            Address of the person.
	 */
	public Person(String firstName, String lastName, String dateOfBirth, String socialSecurityNumber, String age,
			String gender, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.socialSecurityNumber = socialSecurityNumber;
		this.age = age;
		this.gender = gender;
		this.address = address;
		
		setSubAddress();
	}

	/**
	 * Default constructor that only requires socialSecurityNumber. Then sets
	 * all other IVs to null.
	 */
	public Person(String socialSecurityNumber) {
		this(null, null, null, socialSecurityNumber, null, null, null);
	}

	/**
	 * Get person's first name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set person's first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get person's last name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set person's last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get person's date of birth
	 * 
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Get person's social security number
	 * 
	 * @return socialSecurityNumber
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * Get person's age
	 * 
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Set person's age
	 * 
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Get person's gender
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set person's gender
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get person's address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set person's address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressSub1() {
		return addressSub1;
	}

	public String getAddressSub2() {
		return addressSub2;
	}

	public String getAddressSub3() {
		return addressSub3;
	}

	/**
	 * Check if two people are equal.
	 * 
	 * @param otherPerson
	 * @return true or false
	 */
	public boolean equals(Person otherPerson) {
		return (this.getSocialSecurityNumber().equals(otherPerson.getSocialSecurityNumber()));
	}

	/**
	 * Returns lastName, firstName
	 */
	public String toString() {
		return lastName + ", " + firstName;
	}
	
	private void setSubAddress() {
		String[] sub = address.split(";");
		
		this.addressSub1 = sub[0];
		this.addressSub2 = sub[1];
		this.addressSub3 = sub[2];
	} 
}
