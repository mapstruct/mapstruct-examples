package com.example.mapstructtest.model;

public class CarDto {
	private String constructor;
	private int seatCount;
	private String type;

	public String getConstructor() {
		return constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CarDto{" +
				"'" + constructor + '\'' +
				", " + seatCount +
				", '" + type + '\'' +
				'}';
	}
}
