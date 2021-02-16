package com.example.mapstructtest.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AutoValueCarDto {
    public abstract String getConstructor();
    public abstract int getSeatCount();
    public abstract int getAirbagCount();
    public abstract CarType getType();

    public static Builder builder() {
        return new AutoValue_AutoValueCarDto.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setConstructor(String value);
        public abstract Builder setSeatCount(int value);
        public abstract Builder setAirbagCount(int value);
        public abstract Builder setType(CarType value);
        public abstract AutoValueCarDto build();
    }
}