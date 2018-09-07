/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.model;


/**
 * status of transaction
 * 
 */
public enum TransactionStatus implements org.apache.thrift.TEnum {
  /**
   * init status
   */
  CREATED(0),
  /**
   * the transaction has been sent to public chain
   */
  SENT(1),
  /**
   * the transaction has been confirmed on public chain, this is the success status
   */
  CONFIRMED(2),
  /**
   * failed status
   */
  FAILED(3),
  /**
   * failed status on Dipbit platform
   */
  EXPIRED(4),
  /**
   * unknown or unconfirm status
   */
  UNKNOWN(5);

  private final int value;

  private TransactionStatus(int value) {
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
  public static TransactionStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return CREATED;
      case 1:
        return SENT;
      case 2:
        return CONFIRMED;
      case 3:
        return FAILED;
      case 4:
        return EXPIRED;
      case 5:
        return UNKNOWN;
      default:
        return null;
    }
  }
}