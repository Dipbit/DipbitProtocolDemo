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
namespace * com.dipbit.service
include 'models.thrift'


exception WalletException{
    1:i32 code,
    2:string msg
}

enum WalletCommonException{
    /** method create exception*/
    CREATE_AND_SIGN_FAIL=0,
    /** Clearly know that the transaction was not sent to the chain and an exception occurred */
    SENT_FAIL=1,
    /** The transaction has been or maybe sent to the chain, but an exception was thrown*/
    SENT_UNKNOWN_RESULT=2,
    /** invalid address or memo */
    INVALID_ADDRESS=3,
    /** create address fail */
    CREATE_ADDRESS_FAIL=4,
    /** */
    UNSUPPORTED_OPERATION=5,
}

service TransactionSerivce{
    /** create a transaction before sending*/
    models.SendRequest create(1:models.CoinChannel channel, 2:models.TransactionParam param) throws (1: WalletException e),
    /** send transaction to wallet*/
    models.ChainTransaction send(1:models.CoinChannel channel, 2:models.SendRequest ctSource) throws (1: WalletException e),

    /** query a transation*/
    models.ChainTransaction queryTransaction(1:models.CoinChannel channel, 2:string txId) throws (1: WalletException e),
    /** query transactions by parameter*/
    list<models.ChainTransaction> queryTransactions(1:models.CoinChannel channel, 2:models.QueryParam queryParam) throws (1: WalletException e),
    /** query the balance of accouts*/
    map<models.Address, models.BigDecimal> getBalance(1:models.CoinChannel channel, 2:list<models.Address> accounts) throws (1: WalletException e),
    /** query the confirm status of a transaction*/
    models.TransactionStatus confirmStatus(1:models.ChainTransaction chainTransaction, 2:models.CoinChannel channel) throws (1: WalletException e),

    /** create an address for the account*/
    models.Address createAddress(1:models.CoinChannel channel, 2:string account) throws (1: WalletException e),
    /** batch create address for accounts*/
    map<string, models.Address> batchCreateAddresses(1:models.CoinChannel channel, 2:list<string> accounts) throws (1: WalletException e),
    /** validate a address*/
    bool validateAddress(1:models.CoinChannel channel, 2:models.Address address) throws (1: WalletException e),

    /**currency name of the digital crypto currency*/
    string currency(),
    /** transaction mode of the wallet*/
    models.Category category(),

    /** convert the parameters from wallet notify to block chain transaction*/
    models.ChainTransaction processTransaction(1:models.CoinChannel channel, 2:map<string, string> params) throws (1: WalletException e),
}
