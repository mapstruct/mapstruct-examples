package org.mapstruct.example.mapper;

import com.google.protobuf.*;
import org.mapstruct.Mapper;

@Mapper
public interface ProtoMapper
{

  default BoolValue booleanToBoolValue(final Boolean bool) {
    return bool == null ? null : BoolValue.of(bool);
  }

  default Boolean boolValueToBoolean(final BoolValue boolValue) {
    return boolValue == null ? null : boolValue.getValue();
  }

  default Float floatValueToFloat(final FloatValue floatValue) {
    return floatValue == null ? null : floatValue.getValue();
  }

  default FloatValue floatToFloatValue(final Float floatValue) {
    return floatValue == null ? null : FloatValue.newBuilder().setValue(floatValue).build();
  }

  default Integer int32ValueToInteger(final Int32Value int32Value) {
    return int32Value == null ? null : int32Value.getValue();
  }

  default Int32Value integerToInt32Value(final Integer integer) {
    return integer == null ? null : Int32Value.newBuilder().setValue(integer).build();
  }

  default String stringValueToString(final StringValue stringValue) {
    return stringValue != null ? stringValue.getValue() : null;
  }

  default StringValue stringToStringValue(final String string) {
    return string != null ? StringValue.of(string) : null;
  }

  default Long int64ValueToLong(final Int64Value value) {
    return value != null ? value.getValue() : null;
  }

  default Int64Value longToInt64Value(final Long value) {
    return value != null ? Int64Value.of(value) : null;
  }

  default byte[] bytesValueToBytes(final BytesValue value) {
    return value != null ? value.getValue().toByteArray() : null;
  }

  default BytesValue bytesToBytesValue(final byte[] value) {
    return value != null ? BytesValue.of(ByteString.copyFrom(value)) : null;
  }

  default DoubleValue doubleToDoubleValue(final Double value) {
    return value != null ? DoubleValue.of(value) : null;
  }

  default Double doubleValueToDouble(final DoubleValue value) {
    return value != null ? value.getValue() : null;
  }
}
