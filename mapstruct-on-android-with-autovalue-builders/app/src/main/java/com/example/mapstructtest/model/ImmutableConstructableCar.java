package com.example.mapstructtest.model;

public class ImmutableConstructableCar {
    private final String constructor;
    private final int numberOfSeats;
    private final CarType type;

    // MapStruct 1.3 does not support this immutable style contstructor.
    public ImmutableConstructableCar(String constructor, int numberOfSeats, CarType type) {
        this.constructor = constructor;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public String getConstructor() {
        return constructor;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public CarType getType() {
        return type;
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