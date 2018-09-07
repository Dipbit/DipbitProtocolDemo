/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.model;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-09-07")
public class Address implements org.apache.thrift.TBase<Address, Address._Fields>, java.io.Serializable, Cloneable, Comparable<Address> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Address");

  private static final org.apache.thrift.protocol.TField ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("address", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MEMO_FIELD_DESC = new org.apache.thrift.protocol.TField("memo", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ACCOUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("account", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField MEMO_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("memoType", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AddressStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AddressTupleSchemeFactory();

  public java.lang.String address; // required
  public java.lang.String memo; // optional
  public java.lang.String account; // optional
  /**
   * 
   * @see MemoType
   */
  public MemoType memoType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ADDRESS((short)1, "address"),
    MEMO((short)2, "memo"),
    ACCOUNT((short)3, "account"),
    /**
     * 
     * @see MemoType
     */
    MEMO_TYPE((short)4, "memoType");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ADDRESS
          return ADDRESS;
        case 2: // MEMO
          return MEMO;
        case 3: // ACCOUNT
          return ACCOUNT;
        case 4: // MEMO_TYPE
          return MEMO_TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.MEMO,_Fields.ACCOUNT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("address", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MEMO, new org.apache.thrift.meta_data.FieldMetaData("memo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACCOUNT, new org.apache.thrift.meta_data.FieldMetaData("account", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MEMO_TYPE, new org.apache.thrift.meta_data.FieldMetaData("memoType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MemoType.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Address.class, metaDataMap);
  }

  public Address() {
    this.memoType = com.dipbit.model.MemoType.DEFAULT;

  }

  public Address(
    java.lang.String address,
    MemoType memoType)
  {
    this();
    this.address = address;
    this.memoType = memoType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Address(Address other) {
    if (other.isSetAddress()) {
      this.address = other.address;
    }
    if (other.isSetMemo()) {
      this.memo = other.memo;
    }
    if (other.isSetAccount()) {
      this.account = other.account;
    }
    if (other.isSetMemoType()) {
      this.memoType = other.memoType;
    }
  }

  public Address deepCopy() {
    return new Address(this);
  }

  @Override
  public void clear() {
    this.address = null;
    this.memo = null;
    this.account = null;
    this.memoType = com.dipbit.model.MemoType.DEFAULT;

  }

  public java.lang.String getAddress() {
    return this.address;
  }

  public Address setAddress(java.lang.String address) {
    this.address = address;
    return this;
  }

  public void unsetAddress() {
    this.address = null;
  }

  /** Returns true if field address is set (has been assigned a value) and false otherwise */
  public boolean isSetAddress() {
    return this.address != null;
  }

  public void setAddressIsSet(boolean value) {
    if (!value) {
      this.address = null;
    }
  }

  public java.lang.String getMemo() {
    return this.memo;
  }

  public Address setMemo(java.lang.String memo) {
    this.memo = memo;
    return this;
  }

  public void unsetMemo() {
    this.memo = null;
  }

  /** Returns true if field memo is set (has been assigned a value) and false otherwise */
  public boolean isSetMemo() {
    return this.memo != null;
  }

  public void setMemoIsSet(boolean value) {
    if (!value) {
      this.memo = null;
    }
  }

  public java.lang.String getAccount() {
    return this.account;
  }

  public Address setAccount(java.lang.String account) {
    this.account = account;
    return this;
  }

  public void unsetAccount() {
    this.account = null;
  }

  /** Returns true if field account is set (has been assigned a value) and false otherwise */
  public boolean isSetAccount() {
    return this.account != null;
  }

  public void setAccountIsSet(boolean value) {
    if (!value) {
      this.account = null;
    }
  }

  /**
   * 
   * @see MemoType
   */
  public MemoType getMemoType() {
    return this.memoType;
  }

  /**
   * 
   * @see MemoType
   */
  public Address setMemoType(MemoType memoType) {
    this.memoType = memoType;
    return this;
  }

  public void unsetMemoType() {
    this.memoType = null;
  }

  /** Returns true if field memoType is set (has been assigned a value) and false otherwise */
  public boolean isSetMemoType() {
    return this.memoType != null;
  }

  public void setMemoTypeIsSet(boolean value) {
    if (!value) {
      this.memoType = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ADDRESS:
      if (value == null) {
        unsetAddress();
      } else {
        setAddress((java.lang.String)value);
      }
      break;

    case MEMO:
      if (value == null) {
        unsetMemo();
      } else {
        setMemo((java.lang.String)value);
      }
      break;

    case ACCOUNT:
      if (value == null) {
        unsetAccount();
      } else {
        setAccount((java.lang.String)value);
      }
      break;

    case MEMO_TYPE:
      if (value == null) {
        unsetMemoType();
      } else {
        setMemoType((MemoType)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ADDRESS:
      return getAddress();

    case MEMO:
      return getMemo();

    case ACCOUNT:
      return getAccount();

    case MEMO_TYPE:
      return getMemoType();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ADDRESS:
      return isSetAddress();
    case MEMO:
      return isSetMemo();
    case ACCOUNT:
      return isSetAccount();
    case MEMO_TYPE:
      return isSetMemoType();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Address)
      return this.equals((Address)that);
    return false;
  }

  public boolean equals(Address that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_address = true && this.isSetAddress();
    boolean that_present_address = true && that.isSetAddress();
    if (this_present_address || that_present_address) {
      if (!(this_present_address && that_present_address))
        return false;
      if (!this.address.equals(that.address))
        return false;
    }

    boolean this_present_memo = true && this.isSetMemo();
    boolean that_present_memo = true && that.isSetMemo();
    if (this_present_memo || that_present_memo) {
      if (!(this_present_memo && that_present_memo))
        return false;
      if (!this.memo.equals(that.memo))
        return false;
    }

    boolean this_present_account = true && this.isSetAccount();
    boolean that_present_account = true && that.isSetAccount();
    if (this_present_account || that_present_account) {
      if (!(this_present_account && that_present_account))
        return false;
      if (!this.account.equals(that.account))
        return false;
    }

    boolean this_present_memoType = true && this.isSetMemoType();
    boolean that_present_memoType = true && that.isSetMemoType();
    if (this_present_memoType || that_present_memoType) {
      if (!(this_present_memoType && that_present_memoType))
        return false;
      if (!this.memoType.equals(that.memoType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetAddress()) ? 131071 : 524287);
    if (isSetAddress())
      hashCode = hashCode * 8191 + address.hashCode();

    hashCode = hashCode * 8191 + ((isSetMemo()) ? 131071 : 524287);
    if (isSetMemo())
      hashCode = hashCode * 8191 + memo.hashCode();

    hashCode = hashCode * 8191 + ((isSetAccount()) ? 131071 : 524287);
    if (isSetAccount())
      hashCode = hashCode * 8191 + account.hashCode();

    hashCode = hashCode * 8191 + ((isSetMemoType()) ? 131071 : 524287);
    if (isSetMemoType())
      hashCode = hashCode * 8191 + memoType.getValue();

    return hashCode;
  }

  @Override
  public int compareTo(Address other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetAddress()).compareTo(other.isSetAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.address, other.address);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMemo()).compareTo(other.isSetMemo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memo, other.memo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAccount()).compareTo(other.isSetAccount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.account, other.account);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMemoType()).compareTo(other.isSetMemoType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemoType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memoType, other.memoType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Address(");
    boolean first = true;

    sb.append("address:");
    if (this.address == null) {
      sb.append("null");
    } else {
      sb.append(this.address);
    }
    first = false;
    if (isSetMemo()) {
      if (!first) sb.append(", ");
      sb.append("memo:");
      if (this.memo == null) {
        sb.append("null");
      } else {
        sb.append(this.memo);
      }
      first = false;
    }
    if (isSetAccount()) {
      if (!first) sb.append(", ");
      sb.append("account:");
      if (this.account == null) {
        sb.append("null");
      } else {
        sb.append(this.account);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("memoType:");
    if (this.memoType == null) {
      sb.append("null");
    } else {
      sb.append(this.memoType);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AddressStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AddressStandardScheme getScheme() {
      return new AddressStandardScheme();
    }
  }

  private static class AddressStandardScheme extends org.apache.thrift.scheme.StandardScheme<Address> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Address struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.address = iprot.readString();
              struct.setAddressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MEMO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.memo = iprot.readString();
              struct.setMemoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ACCOUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.account = iprot.readString();
              struct.setAccountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MEMO_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.memoType = com.dipbit.model.MemoType.findByValue(iprot.readI32());
              struct.setMemoTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Address struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.address != null) {
        oprot.writeFieldBegin(ADDRESS_FIELD_DESC);
        oprot.writeString(struct.address);
        oprot.writeFieldEnd();
      }
      if (struct.memo != null) {
        if (struct.isSetMemo()) {
          oprot.writeFieldBegin(MEMO_FIELD_DESC);
          oprot.writeString(struct.memo);
          oprot.writeFieldEnd();
        }
      }
      if (struct.account != null) {
        if (struct.isSetAccount()) {
          oprot.writeFieldBegin(ACCOUNT_FIELD_DESC);
          oprot.writeString(struct.account);
          oprot.writeFieldEnd();
        }
      }
      if (struct.memoType != null) {
        oprot.writeFieldBegin(MEMO_TYPE_FIELD_DESC);
        oprot.writeI32(struct.memoType.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AddressTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AddressTupleScheme getScheme() {
      return new AddressTupleScheme();
    }
  }

  private static class AddressTupleScheme extends org.apache.thrift.scheme.TupleScheme<Address> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Address struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAddress()) {
        optionals.set(0);
      }
      if (struct.isSetMemo()) {
        optionals.set(1);
      }
      if (struct.isSetAccount()) {
        optionals.set(2);
      }
      if (struct.isSetMemoType()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAddress()) {
        oprot.writeString(struct.address);
      }
      if (struct.isSetMemo()) {
        oprot.writeString(struct.memo);
      }
      if (struct.isSetAccount()) {
        oprot.writeString(struct.account);
      }
      if (struct.isSetMemoType()) {
        oprot.writeI32(struct.memoType.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Address struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.address = iprot.readString();
        struct.setAddressIsSet(true);
      }
      if (incoming.get(1)) {
        struct.memo = iprot.readString();
        struct.setMemoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.account = iprot.readString();
        struct.setAccountIsSet(true);
      }
      if (incoming.get(3)) {
        struct.memoType = com.dipbit.model.MemoType.findByValue(iprot.readI32());
        struct.setMemoTypeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

