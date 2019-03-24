package com.example.mapstructtest.model;

public class Car {
	private String constructor;
	private int numberOfSeats;
	private CarType type;

	public String getConstructor() {
		return constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car{" +
				"constructor='" + constructor + '\'' +
				", numberOfSeats=" + numberOfSeats +
				", type=" + type +
				'}';
	}
}