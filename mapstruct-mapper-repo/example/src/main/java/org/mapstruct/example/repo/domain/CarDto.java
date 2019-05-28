/**
 * 
 */
package org.mapstruct.example.repo.domain;

/**
 * @author jucheme
 *
 */
public class CarDto {

	private String make;
	private int seatCount;
	private String type;

	/**
	 * Construct!
	 *
	 */
	public CarDto() {

	}

	/**
	 * Construct!
	 * 
	 * @param make
	 * @param seatCount
	 * @param type
	 */
	public CarDto(String make, int seatCount, String type) {
		super();
		this.make = make;
		this.seatCount = seatCount;
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
	 * @return the seatCount
	 */
	public int getSeatCount() {
		return seatCount;
	}
	/**
	 * @param seatCount
	 *            the seatCount to set
	 */
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
