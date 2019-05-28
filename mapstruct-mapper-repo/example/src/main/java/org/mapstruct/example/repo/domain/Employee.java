/**
 * 
 */
package org.mapstruct.example.repo.domain;

/**
 * @author jucheme
 *
 */
public class Employee {

	private String name;
	private String address;
	private Long age;

	public Employee() {

	}

	/**
	 * Construct!
	 * 
	 * @param name
	 * @param address
	 * @param age
	 */
	public Employee(String name, String address, Long age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
