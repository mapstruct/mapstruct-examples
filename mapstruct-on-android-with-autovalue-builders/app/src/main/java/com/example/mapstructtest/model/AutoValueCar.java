package com.example.mapstructtest.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AutoValueCar {
    public abstract String getConstructor();
    public abstract int getNumberOfSeats();
    public abstract int getNumberOfAirbags();
    public abstract CarType getType();

    public static Builder builder() {
        return new AutoValue_AutoValueCar.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setConstructor(String value);
        public abstract Builder setNumberOfSeats(int value);
        public abstract Builder setNumberOfAirbags(int value);
        public abstract Builder setType(CarType value);
        public abstract AutoValueCar build();
    }
}