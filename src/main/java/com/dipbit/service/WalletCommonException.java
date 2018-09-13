/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.service;


public enum WalletCommonException implements org.apache.thrift.TEnum {
  /**
   * method create exception
   */
  CREATE_AND_SIGN_FAIL(0),
  /**
   * Clearly know that the transaction was not sent to the chain and an exception occurred
   */
  SENT_FAIL(1),
  /**
   * The transaction has been or maybe sent to the chain, but an exception was thrown
   */
  SENT_UNKNOWN_RESULT(2),
  /**
   * invalid address or memo
   */
  INVALID_ADDRESS(3),
  /**
   * create address fail
   */
  CREATE_ADDRESS_FAIL(4),
  UNSUPPORTED_OPERATION(5);

  private final int value;

  private WalletCommonException(int value) {
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
  public static WalletCommonException findByValue(int value) { 
    switch (value) {
      case 0:
        return CREATE_AND_SIGN_FAIL;
      case 1:
        return SENT_FAIL;
      case 2:
        return SENT_UNKNOWN_RESULT;
      case 3:
        return INVALID_ADDRESS;
      case 4:
        return CREATE_ADDRESS_FAIL;
      case 5:
        return UNSUPPORTED_OPERATION;
      default:
        return null;
    }
  }
}
