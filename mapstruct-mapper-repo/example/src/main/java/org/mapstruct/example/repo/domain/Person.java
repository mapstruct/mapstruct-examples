/**
 * 
 */
package org.mapstruct.example.repo.domain;

/**
 * @author jucheme
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private String address;
	private Long age;

	public Person() {
	}

	/**
	 * Construct!
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param age
	 */
	public Person(String firstName, String lastName, String address, Long age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public Long getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Long age) {
		this.age = age;
	}

}
