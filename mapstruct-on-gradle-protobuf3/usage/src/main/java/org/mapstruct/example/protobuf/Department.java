package org.mapstruct.example.protobuf;

/**
 * @author Thomas Kratz
 */
public class Department {
	private String name;

	public Department() {}
	
	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
