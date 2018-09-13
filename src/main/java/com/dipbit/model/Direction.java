/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.model;


/**
 * sending or receiving
 * 
 */
public enum Direction implements org.apache.thrift.TEnum {
  /**
   * for and address sending digital crypto currency OUT should be used
   */
  SEND(0),
  /**
   * for and address receiving digital crypto currency IN should be used
   */
  RECEIVE(1);

  private final int value;

  private Direction(int value) {
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
  public static Direction findByValue(int value) { 
    switch (value) {
      case 0:
        return SEND;
      case 1:
        return RECEIVE;
      default:
        return null;
    }
  }
}
