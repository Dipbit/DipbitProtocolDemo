/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.model;


/**
 * transaction mode
 * 
 */
public enum Category implements org.apache.thrift.TEnum {
  /**
   * two-step transaction mode
   */
  CREATE_AND_SIGN(1),
  /**
   * one-step transaction mode
   */
  DIRECT_SEND(2);

  private final int value;

  private Category(int value) {
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
  public static Category findByValue(int value) { 
    switch (value) {
      case 1:
        return CREATE_AND_SIGN;
      case 2:
        return DIRECT_SEND;
      default:
        return null;
    }
  }
}
