
public class Rental {

	private Vehicle vehicle;
	private Customer customer;

	private String date, contractNumber;
	private double dailyPrice, startMiles, startGasLevel, endMiles, endGasLevel;
	private boolean damageDone, contractExpired;
	public static int rentalContractNumber = 1;

	public Rental(Vehicle vehicle, Customer customer, String date, String contractNumber, double dailyPrice,
			double startMiles, double startGasLevel) {
		this.vehicle = vehicle;
		this.customer = customer;
		this.date = date;
		this.contractNumber = contractNumber;
		this.dailyPrice = dailyPrice;
		this.startMiles = startMiles;
		this.startGasLevel = startGasLevel;
		this.damageDone = false;
		this.contractExpired = false;
		rentalContractNumber++;
	}

	public Rental() {
		this(null, null, null, null, 0, 0, 0);
	}

	public boolean isDamageDone() {
		return damageDone;
	}

	public void setDamageDone(boolean damageDone) {
		this.damageDone = damageDone;
	}

	public boolean isContractExpired() {
		return contractExpired;
	}

	public void setContractExpired(boolean contractExpired) {
		this.contractExpired = contractExpired;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getDate() {
		return date;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public double getStartMiles() {
		return startMiles;
	}

	public double getStartGasLevel() {
		return startGasLevel;
	}

	public double getEndMiles() {
		return endMiles;
	}

	public void setEndMiles(double endMiles) {
		this.endMiles = endMiles;
	}

	public double getEndGasLevel() {
		return endGasLevel;
	}

	public void setEndGasLevel(double endGasLevel) {
		this.endGasLevel = endGasLevel;
	}

	public static String getRentalContractNumber() {
		return String.format("%06d", rentalContractNumber);
	}

	public String toString() {
		return getRentalContractNumber() + " : " + customer.toString();
	}
}
