/**
 * 
 */
package org.mapstruct.example.repo.domain;

/**
 * @author jucheme
 *
 */
public class Boss {

	private String name;
	private String title;
	private String address;
	private Long age;

	public Boss() {

	}

	/**
	 * Construct!
	 * 
	 * @param name
	 * @param address
	 * @param age
	 */
	public Boss(String name, String title, String address, Long age) {
		super();
		this.name = name;
		this.title = title;
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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
