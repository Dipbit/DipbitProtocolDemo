/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
namespace * com.dipbit.model
/**
*  transaction mode
**/
enum Category{
    /** two-step transaction mode*/
    CREATE_AND_SIGN=1,
    /** one-step transaction mode*/
    DIRECT_SEND=2
}

/**
* status of transaction
**/
enum TransactionStatus{
    /** init status*/
    CREATED=0,
    /** the transaction has been sent to public chain */
    SENT=1,
    /** the transaction has been confirmed on public chain, this is the success status*/
    CONFIRMED=2,
    /** failed status */
    FAILED=3,
    /** failed status on Dipbit platform */
    EXPIRED=4,
    /** unknown or unconfirm status */
    UNKNOWN=5
}

/**
*  sending or receiving
**/
enum Direction{
    /** for and address sending digital crypto currency OUT should be used*/
    SEND=0,
    /** for and address receiving digital crypto currency IN should be used*/
    RECEIVE=1,
}

enum MemoType{
    DEFAULT=0,
    AUTO_GENERATE_SEQUENCE=1,
}

/***
* the request for launching a transaction
**/
struct SendRequest{
    /** the currency name of coin, which will be BTC for Bitcoin and ETH for Ethereum */
    1:string currencuy,
    /** transaction ID, for one-step transaction mode, this is optional */
    2:optional string txId,
    /** transaction fee, default is "0.0" */
    3:BigDecimal fee,
    /** transaction details  */
    4:list<TransactionIO> ioList,
    /** extra parameters, reserved for further use, in most cases, this field will not be used*/
    5:optional map<string,string> properties,
}

/***
* some wallet configuration
**/
struct CoinChannel{
    /** unique ID for the wallet deployment*/
    1:string id,
    /** the alias name of the unique ID*/
    2:string name,
    /** the code of crypto currency, like ETH, BTC*/
    3:string currency,
    /** the rpc URL of the wallet*/
    4:string rpcURL,
    /** the rpc protocol of the wallet*/
    5:string rpcProtocol,
    /** the rpc port of the wallet*/
    6:i32 rpcPort,
    /** the rpc password of the wallet*/
    7:optional string rpcPassword,
    /** the rpc usser of the wallet */
    8:optional string rpcUser,
    /** other configuration of the walet, this will be a json string*/
    9:optional string config,
    /*** reserved extra configuration, normally this should not be used */
    10:optional string extra
}

/***
*  parameters when create a transaction
**/
struct TransactionParam{
    /** transaction items*/
    1:list<TransactionIO> ioList,
    /** ID of CoinChannel*/
    2:string channelId,
    /** when building the transaction, if you need to change to address */
    3:optional Address changeAddress,
    /** extra properties, normally this will be empty for reserved usage*/
    4:optional map<string,string> properties
}

/**
* the transaction item of an address sending or receiving digital crypto currency
**/
struct TransactionIO{
    /** the address sending or receiving digital crypto currency*/
    1:string address,
    /** the transaction memo*/
    2:optional string memo,
    /** the amount need to be transfered*/
    3:BigDecimal amount,
    /** sending or receiving*/
    4:Direction direction,
}

/***
* the raw information returned by wallet after sending a transaction.
**/
struct ChainTransaction{
    /** transaction mode */
    1:Category category,
    /** transaction id */
    2:string txId,
    /** currency name, for example ETC,BTH*/
    3:string currency,
    /** transaction status*/
    4:TransactionStatus status,
    /** transaction fee*/
    5:BigDecimal fee,
    /** confirmation number*/
    6:i32 confirmations,
    /** block hash of the block containing this transaction */
    7:string blockHash,
    /** block index of the block containing this transaction */
    8:optional string blockIndex,
    /** block time of the block generated*/
    9:i64 blockTime,
    /** the time when the wallet receiving the block*/
    10:i64 receiveTime,
    /** the raw block chain information*/
    11:optional string txResult,
    /** transaction sending or receiving items */
    12:list<TransactionIO> ioList,
    /** reserved for furthur usage, other propeties */
    13:optional map<string,string> properties,
}

/**
*  the public address
**/
struct Address{
    /** the public address on the block chain*/
    1:string address,
    /** memo of the address*/
    2:optional string memo,
    /** account name of the address*/
    3:string account,
    /** memo type, some wallet only use one address and use generated increment id for different account or user*/
    4:MemoType memoType = MemoType.DEFAULT
}

/** big decimal is a alias of string the format should be 'xx.xxx' */
typedef string BigDecimal

/***
* parameters of the query operation
**/
struct QueryParam{
    /** the stat time of block received*/
    1:i64 startReceiveTime,
    /** the end time of block received*/
    2:i64 endReceiveTime,
    /** the start block hash*/
    3:optional string startBlockHash,
    /** the start block index*/
    4:optional string startBlockIndex
}