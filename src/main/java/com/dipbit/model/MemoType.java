/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.model;


public enum MemoType implements org.apache.thrift.TEnum {
  DEFAULT(0),
  AUTO_GENERATE_SEQUENCE(1);

  private final int value;

  private MemoType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static MemoType findByValue(int value) { 
    switch (value) {
      case 0:
        return DEFAULT;
      case 1:
        return AUTO_GENERATE_SEQUENCE;
      default:
        return null;
    }
  }
}
