/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.dipbit.model;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * *
 * the request for launching a transaction
 * 
 */
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-09-11")
public class SendRequest implements org.apache.thrift.TBase<SendRequest, SendRequest._Fields>, java.io.Serializable, Cloneable, Comparable<SendRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SendRequest");

  private static final org.apache.thrift.protocol.TField CURRENCUY_FIELD_DESC = new org.apache.thrift.protocol.TField("currencuy", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TX_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("txId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FEE_FIELD_DESC = new org.apache.thrift.protocol.TField("fee", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField IO_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("ioList", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField PROPERTIES_FIELD_DESC = new org.apache.thrift.protocol.TField("properties", org.apache.thrift.protocol.TType.MAP, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SendRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SendRequestTupleSchemeFactory();

  /**
   * the currency name of coin, which will be BTC for Bitcoin and ETH for Ethereum
   */
  public java.lang.String currencuy; // required
  /**
   * transaction ID, for one-step transaction mode, this is optional
   */
  public java.lang.String txId; // optional
  /**
   * transaction fee, default is "0.0"
   */
  public java.lang.String fee; // required
  /**
   * transaction details
   */
  public java.util.List<TransactionIO> ioList; // required
  /**
   * extra parameters, reserved for further use, in most cases, this field will not be used
   */
  public java.util.Map<java.lang.String,java.lang.String> properties; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * the currency name of coin, which will be BTC for Bitcoin and ETH for Ethereum
     */
    CURRENCUY((short)1, "currencuy"),
    /**
     * transaction ID, for one-step transaction mode, this is optional
     */
    TX_ID((short)2, "txId"),
    /**
     * transaction fee, default is "0.0"
     */
    FEE((short)3, "fee"),
    /**
     * transaction details
     */
    IO_LIST((short)4, "ioList"),
    /**
     * extra parameters, reserved for further use, in most cases, this field will not be used
     */
    PROPERTIES((short)5, "properties");

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
        case 1: // CURRENCUY
          return CURRENCUY;
        case 2: // TX_ID
          return TX_ID;
        case 3: // FEE
          return FEE;
        case 4: // IO_LIST
          return IO_LIST;
        case 5: // PROPERTIES
          return PROPERTIES;
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
  private static final _Fields optionals[] = {_Fields.TX_ID,_Fields.PROPERTIES};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CURRENCUY, new org.apache.thrift.meta_data.FieldMetaData("currencuy", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TX_ID, new org.apache.thrift.meta_data.FieldMetaData("txId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FEE, new org.apache.thrift.meta_data.FieldMetaData("fee", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "BigDecimal")));
    tmpMap.put(_Fields.IO_LIST, new org.apache.thrift.meta_data.FieldMetaData("ioList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "TransactionIO"))));
    tmpMap.put(_Fields.PROPERTIES, new org.apache.thrift.meta_data.FieldMetaData("properties", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SendRequest.class, metaDataMap);
  }

  public SendRequest() {
  }

  public SendRequest(
    java.lang.String currencuy,
    java.lang.String fee,
    java.util.List<TransactionIO> ioList)
  {
    this();
    this.currencuy = currencuy;
    this.fee = fee;
    this.ioList = ioList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SendRequest(SendRequest other) {
    if (other.isSetCurrencuy()) {
      this.currencuy = other.currencuy;
    }
    if (other.isSetTxId()) {
      this.txId = other.txId;
    }
    if (other.isSetFee()) {
      this.fee = other.fee;
    }
    if (other.isSetIoList()) {
      java.util.List<TransactionIO> __this__ioList = new java.util.ArrayList<TransactionIO>(other.ioList.size());
      for (TransactionIO other_element : other.ioList) {
        __this__ioList.add(new TransactionIO(other_element));
      }
      this.ioList = __this__ioList;
    }
    if (other.isSetProperties()) {
      java.util.Map<java.lang.String,java.lang.String> __this__properties = new java.util.HashMap<java.lang.String,java.lang.String>(other.properties);
      this.properties = __this__properties;
    }
  }

  public SendRequest deepCopy() {
    return new SendRequest(this);
  }

  @Override
  public void clear() {
    this.currencuy = null;
    this.txId = null;
    this.fee = null;
    this.ioList = null;
    this.properties = null;
  }

  /**
   * the currency name of coin, which will be BTC for Bitcoin and ETH for Ethereum
   */
  public java.lang.String getCurrencuy() {
    return this.currencuy;
  }

  /**
   * the currency name of coin, which will be BTC for Bitcoin and ETH for Ethereum
   */
  public SendRequest setCurrencuy(java.lang.String currencuy) {
    this.currencuy = currencuy;
    return this;
  }

  public void unsetCurrencuy() {
    this.currencuy = null;
  }

  /** Returns true if field currencuy is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrencuy() {
    return this.currencuy != null;
  }

  public void setCurrencuyIsSet(boolean value) {
    if (!value) {
      this.currencuy = null;
    }
  }

  /**
   * transaction ID, for one-step transaction mode, this is optional
   */
  public java.lang.String getTxId() {
    return this.txId;
  }

  /**
   * transaction ID, for one-step transaction mode, this is optional
   */
  public SendRequest setTxId(java.lang.String txId) {
    this.txId = txId;
    return this;
  }

  public void unsetTxId() {
    this.txId = null;
  }

  /** Returns true if field txId is set (has been assigned a value) and false otherwise */
  public boolean isSetTxId() {
    return this.txId != null;
  }

  public void setTxIdIsSet(boolean value) {
    if (!value) {
      this.txId = null;
    }
  }

  /**
   * transaction fee, default is "0.0"
   */
  public java.lang.String getFee() {
    return this.fee;
  }

  /**
   * transaction fee, default is "0.0"
   */
  public SendRequest setFee(java.lang.String fee) {
    this.fee = fee;
    return this;
  }

  public void unsetFee() {
    this.fee = null;
  }

  /** Returns true if field fee is set (has been assigned a value) and false otherwise */
  public boolean isSetFee() {
    return this.fee != null;
  }

  public void setFeeIsSet(boolean value) {
    if (!value) {
      this.fee = null;
    }
  }

  public int getIoListSize() {
    return (this.ioList == null) ? 0 : this.ioList.size();
  }

  public java.util.Iterator<TransactionIO> getIoListIterator() {
    return (this.ioList == null) ? null : this.ioList.iterator();
  }

  public void addToIoList(TransactionIO elem) {
    if (this.ioList == null) {
      this.ioList = new java.util.ArrayList<TransactionIO>();
    }
    this.ioList.add(elem);
  }

  /**
   * transaction details
   */
  public java.util.List<TransactionIO> getIoList() {
    return this.ioList;
  }

  /**
   * transaction details
   */
  public SendRequest setIoList(java.util.List<TransactionIO> ioList) {
    this.ioList = ioList;
    return this;
  }

  public void unsetIoList() {
    this.ioList = null;
  }

  /** Returns true if field ioList is set (has been assigned a value) and false otherwise */
  public boolean isSetIoList() {
    return this.ioList != null;
  }

  public void setIoListIsSet(boolean value) {
    if (!value) {
      this.ioList = null;
    }
  }

  public int getPropertiesSize() {
    return (this.properties == null) ? 0 : this.properties.size();
  }

  public void putToProperties(java.lang.String key, java.lang.String val) {
    if (this.properties == null) {
      this.properties = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.properties.put(key, val);
  }

  /**
   * extra parameters, reserved for further use, in most cases, this field will not be used
   */
  public java.util.Map<java.lang.String,java.lang.String> getProperties() {
    return this.properties;
  }

  /**
   * extra parameters, reserved for further use, in most cases, this field will not be used
   */
  public SendRequest setProperties(java.util.Map<java.lang.String,java.lang.String> properties) {
    this.properties = properties;
    return this;
  }

  public void unsetProperties() {
    this.properties = null;
  }

  /** Returns true if field properties is set (has been assigned a value) and false otherwise */
  public boolean isSetProperties() {
    return this.properties != null;
  }

  public void setPropertiesIsSet(boolean value) {
    if (!value) {
      this.properties = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case CURRENCUY:
      if (value == null) {
        unsetCurrencuy();
      } else {
        setCurrencuy((java.lang.String)value);
      }
      break;

    case TX_ID:
      if (value == null) {
        unsetTxId();
      } else {
        setTxId((java.lang.String)value);
      }
      break;

    case FEE:
      if (value == null) {
        unsetFee();
      } else {
        setFee((java.lang.String)value);
      }
      break;

    case IO_LIST:
      if (value == null) {
        unsetIoList();
      } else {
        setIoList((java.util.List<TransactionIO>)value);
      }
      break;

    case PROPERTIES:
      if (value == null) {
        unsetProperties();
      } else {
        setProperties((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case CURRENCUY:
      return getCurrencuy();

    case TX_ID:
      return getTxId();

    case FEE:
      return getFee();

    case IO_LIST:
      return getIoList();

    case PROPERTIES:
      return getProperties();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case CURRENCUY:
      return isSetCurrencuy();
    case TX_ID:
      return isSetTxId();
    case FEE:
      return isSetFee();
    case IO_LIST:
      return isSetIoList();
    case PROPERTIES:
      return isSetProperties();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof SendRequest)
      return this.equals((SendRequest)that);
    return false;
  }

  public boolean equals(SendRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_currencuy = true && this.isSetCurrencuy();
    boolean that_present_currencuy = true && that.isSetCurrencuy();
    if (this_present_currencuy || that_present_currencuy) {
      if (!(this_present_currencuy && that_present_currencuy))
        return false;
      if (!this.currencuy.equals(that.currencuy))
        return false;
    }

    boolean this_present_txId = true && this.isSetTxId();
    boolean that_present_txId = true && that.isSetTxId();
    if (this_present_txId || that_present_txId) {
      if (!(this_present_txId && that_present_txId))
        return false;
      if (!this.txId.equals(that.txId))
        return false;
    }

    boolean this_present_fee = true && this.isSetFee();
    boolean that_present_fee = true && that.isSetFee();
    if (this_present_fee || that_present_fee) {
      if (!(this_present_fee && that_present_fee))
        return false;
      if (!this.fee.equals(that.fee))
        return false;
    }

    boolean this_present_ioList = true && this.isSetIoList();
    boolean that_present_ioList = true && that.isSetIoList();
    if (this_present_ioList || that_present_ioList) {
      if (!(this_present_ioList && that_present_ioList))
        return false;
      if (!this.ioList.equals(that.ioList))
        return false;
    }

    boolean this_present_properties = true && this.isSetProperties();
    boolean that_present_properties = true && that.isSetProperties();
    if (this_present_properties || that_present_properties) {
      if (!(this_present_properties && that_present_properties))
        return false;
      if (!this.properties.equals(that.properties))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetCurrencuy()) ? 131071 : 524287);
    if (isSetCurrencuy())
      hashCode = hashCode * 8191 + currencuy.hashCode();

    hashCode = hashCode * 8191 + ((isSetTxId()) ? 131071 : 524287);
    if (isSetTxId())
      hashCode = hashCode * 8191 + txId.hashCode();

    hashCode = hashCode * 8191 + ((isSetFee()) ? 131071 : 524287);
    if (isSetFee())
      hashCode = hashCode * 8191 + fee.hashCode();

    hashCode = hashCode * 8191 + ((isSetIoList()) ? 131071 : 524287);
    if (isSetIoList())
      hashCode = hashCode * 8191 + ioList.hashCode();

    hashCode = hashCode * 8191 + ((isSetProperties()) ? 131071 : 524287);
    if (isSetProperties())
      hashCode = hashCode * 8191 + properties.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(SendRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetCurrencuy()).compareTo(other.isSetCurrencuy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrencuy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.currencuy, other.currencuy);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTxId()).compareTo(other.isSetTxId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTxId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.txId, other.txId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFee()).compareTo(other.isSetFee());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFee()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fee, other.fee);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIoList()).compareTo(other.isSetIoList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIoList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ioList, other.ioList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProperties()).compareTo(other.isSetProperties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProperties()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.properties, other.properties);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SendRequest(");
    boolean first = true;

    sb.append("currencuy:");
    if (this.currencuy == null) {
      sb.append("null");
    } else {
      sb.append(this.currencuy);
    }
    first = false;
    if (isSetTxId()) {
      if (!first) sb.append(", ");
      sb.append("txId:");
      if (this.txId == null) {
        sb.append("null");
      } else {
        sb.append(this.txId);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("fee:");
    if (this.fee == null) {
      sb.append("null");
    } else {
      sb.append(this.fee);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ioList:");
    if (this.ioList == null) {
      sb.append("null");
    } else {
      sb.append(this.ioList);
    }
    first = false;
    if (isSetProperties()) {
      if (!first) sb.append(", ");
      sb.append("properties:");
      if (this.properties == null) {
        sb.append("null");
      } else {
        sb.append(this.properties);
      }
      first = false;
    }
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

  private static class SendRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SendRequestStandardScheme getScheme() {
      return new SendRequestStandardScheme();
    }
  }

  private static class SendRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<SendRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SendRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CURRENCUY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.currencuy = iprot.readString();
              struct.setCurrencuyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TX_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.txId = iprot.readString();
              struct.setTxIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FEE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fee = iprot.readString();
              struct.setFeeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IO_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.ioList = new java.util.ArrayList<TransactionIO>(_list0.size);
                TransactionIO _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new TransactionIO();
                  _elem1.read(iprot);
                  struct.ioList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setIoListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PROPERTIES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map3 = iprot.readMapBegin();
                struct.properties = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map3.size);
                java.lang.String _key4;
                java.lang.String _val5;
                for (int _i6 = 0; _i6 < _map3.size; ++_i6)
                {
                  _key4 = iprot.readString();
                  _val5 = iprot.readString();
                  struct.properties.put(_key4, _val5);
                }
                iprot.readMapEnd();
              }
              struct.setPropertiesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SendRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.currencuy != null) {
        oprot.writeFieldBegin(CURRENCUY_FIELD_DESC);
        oprot.writeString(struct.currencuy);
        oprot.writeFieldEnd();
      }
      if (struct.txId != null) {
        if (struct.isSetTxId()) {
          oprot.writeFieldBegin(TX_ID_FIELD_DESC);
          oprot.writeString(struct.txId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.fee != null) {
        oprot.writeFieldBegin(FEE_FIELD_DESC);
        oprot.writeString(struct.fee);
        oprot.writeFieldEnd();
      }
      if (struct.ioList != null) {
        oprot.writeFieldBegin(IO_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.ioList.size()));
          for (TransactionIO _iter7 : struct.ioList)
          {
            _iter7.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.properties != null) {
        if (struct.isSetProperties()) {
          oprot.writeFieldBegin(PROPERTIES_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.properties.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter8 : struct.properties.entrySet())
            {
              oprot.writeString(_iter8.getKey());
              oprot.writeString(_iter8.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SendRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SendRequestTupleScheme getScheme() {
      return new SendRequestTupleScheme();
    }
  }

  private static class SendRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<SendRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SendRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetCurrencuy()) {
        optionals.set(0);
      }
      if (struct.isSetTxId()) {
        optionals.set(1);
      }
      if (struct.isSetFee()) {
        optionals.set(2);
      }
      if (struct.isSetIoList()) {
        optionals.set(3);
      }
      if (struct.isSetProperties()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetCurrencuy()) {
        oprot.writeString(struct.currencuy);
      }
      if (struct.isSetTxId()) {
        oprot.writeString(struct.txId);
      }
      if (struct.isSetFee()) {
        oprot.writeString(struct.fee);
      }
      if (struct.isSetIoList()) {
        {
          oprot.writeI32(struct.ioList.size());
          for (TransactionIO _iter9 : struct.ioList)
          {
            _iter9.write(oprot);
          }
        }
      }
      if (struct.isSetProperties()) {
        {
          oprot.writeI32(struct.properties.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter10 : struct.properties.entrySet())
          {
            oprot.writeString(_iter10.getKey());
            oprot.writeString(_iter10.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SendRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.currencuy = iprot.readString();
        struct.setCurrencuyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.txId = iprot.readString();
        struct.setTxIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.fee = iprot.readString();
        struct.setFeeIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list11 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.ioList = new java.util.ArrayList<TransactionIO>(_list11.size);
          TransactionIO _elem12;
          for (int _i13 = 0; _i13 < _list11.size; ++_i13)
          {
            _elem12 = new TransactionIO();
            _elem12.read(iprot);
            struct.ioList.add(_elem12);
          }
        }
        struct.setIoListIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TMap _map14 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.properties = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map14.size);
          java.lang.String _key15;
          java.lang.String _val16;
          for (int _i17 = 0; _i17 < _map14.size; ++_i17)
          {
            _key15 = iprot.readString();
            _val16 = iprot.readString();
            struct.properties.put(_key15, _val16);
          }
        }
        struct.setPropertiesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

