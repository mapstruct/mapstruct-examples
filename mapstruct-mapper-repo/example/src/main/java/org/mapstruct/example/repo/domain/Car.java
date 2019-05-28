/**
 * 
 */
package org.mapstruct.example.repo.domain;

/**
 * @author jucheme
 *
 */
public class Car {

	private String make;
	private int numberOfSeats;
	private CarType type;

	/**
	 * Construct!
	 *
	 */
	public Car() {

	}

	/**
	 * Construct!
	 * 
	 * @param make
	 * @param numberOfSeats
	 * @param type
	 */
	public Car(String make, int numberOfSeats, CarType type) {
		super();
		this.make = make;
		this.numberOfSeats = numberOfSeats;
		this.type = type;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make
	 *            the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	/**
	 * @param numberOfSeats
	 *            the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	/**
	 * @return the type
	 */
	public CarType getType() {
		return type;
	}
	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CarType type) {
		this.type = type;
	}

}
