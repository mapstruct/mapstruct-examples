package com.example.mapstructtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mapstructtest.model.AutoValueCar;
import com.example.mapstructtest.model.AutoValueCarDto;
import com.example.mapstructtest.model.AutoValueFluentCar;
import com.example.mapstructtest.model.Car;
import com.example.mapstructtest.model.CarDto;
import com.example.mapstructtest.model.CarType;
import com.example.mapstructtest.model.ImmutableConstructableCar;
import com.example.mapstructtest.model.ImmutableConstructibleCarDto;
import com.example.mapstructtest.model.mapping.AutoValueMapper;
import com.example.mapstructtest.model.mapping.CarMapper;
import com.example.mapstructtest.model.mapping.ImmutableConstructableCarMapper;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv_text);
	}

	@Override
	protected void onResume() {
		super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(manualMapping());
		sb.append(withAutoValue());
//		sb.append(withAutoValueFluent());
//		sb.append(withImmutable()); // Not yet for MapStruct 1.3
        tv.setText(sb.toString());
	}

	String withImmutable() {
		// Currently maps to nulls
		ImmutableConstructableCar immutableConstructableCar = new ImmutableConstructableCar("Immutable Audi", 6, CarType.LARGE);
		ImmutableConstructibleCarDto immutableCarDto = ImmutableConstructableCarMapper.INSTANCE.carToCarDto(immutableConstructableCar);
		return getString(immutableConstructableCar, immutableCarDto, "Immutable: ");
	}

	String manualMapping() {
		Car car = new Car();
		car.setConstructor("Audi");
		car.setNumberOfSeats(5);
		car.setType(CarType.LUXURY);
		CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
		return getString(car, carDto, "Manual mapping");
	}

	String withAutoValue() {
		AutoValueCar.Builder builder = AutoValueCar.builder();
		builder.setConstructor("Audi");
		builder.setNumberOfSeats(5);
		builder.setNumberOfAirbags(3);
		builder.setType(CarType.LUXURY);
		AutoValueCar car = builder.build();

		AutoValueCarDto carDto = AutoValueMapper.INSTANCE.toDto(car);
		AutoValueCar carAgain = AutoValueMapper.INSTANCE.toModel(carDto);
		return getString(car, carDto, carAgain, "mapstruct mapping AutoValue");
	}

	String withAutoValueFluent() {
		AutoValueFluentCar.Builder builder = AutoValueFluentCar.builder();
		builder.setConstructor("Audi");
		builder.setNumberOfSeats(5);
		builder.setType(CarType.LUXURY);
		AutoValueFluentCar car = builder.build();
		// MapStruct 1.3 does NOT work with fluent accessor style like shown here
//		AutoValueFluentCarDto carDto = AutoValueFluentMapper.INSTANCE.toDto(car);
//		return getString(car, carDto, "mapstruct mapping fluent AutoValue");
		return "";
	}

	private String getString(Object input, Object output, String info) {
		return getString(input, output, null, info);
	}
	private String getString(Object input, Object output, Object output2, String info) {
		StringBuilder strb = new StringBuilder();
		strb.append(info);
		strb.append('\n');
		strb.append(input.toString());
		strb.append('\n');
		strb.append(output.toString());
		if (output2 != null ){
			strb.append('\n');
			strb.append(output2.toString());
		}
		strb.append('\n');
		strb.append('\n');
		return strb.toString();
	}
}
