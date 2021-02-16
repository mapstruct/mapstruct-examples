package com.example.mapstructtest.model;

public class CarFluentSetter {
	private String constructor;
	private int numberOfSeats;
	private CarType type;

	public String getConstructor() {
		return constructor;
	}

	public CarFluentSetter constructor(String constructor) {
		this.constructor = constructor;
		return this;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public CarFluentSetter numberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
		return this;
	}

	public CarType getType() {
		return type;
	}

	public CarFluentSetter type(CarType type) {
		this.type = type;
		return this;
	}

	@Override
	public String toString() {
		return "CarFluentSetter{" +
				"'" + constructor + '\'' +
				", " + numberOfSeats +
				", " + type +
				'}';
	}
}