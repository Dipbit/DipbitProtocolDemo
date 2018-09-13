package com.dipbit.server.service.impl;

import com.azazar.bitcoin.jsonrpcclient.Bitcoin;
import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;
import com.dipbit.model.*;
import com.dipbit.service.TransactionSerivce;
import com.dipbit.service.WalletCommonException;
import com.dipbit.service.WalletException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.*;

/**
 * @author penuel
 * @project DipbitProtocolDemo
 * @create 2018/9/5
 * @description
 **/
public class BTCTransactionServiceImpl implements TransactionSerivce.Iface {

    static Logger logger = LoggerFactory.getLogger(BTCTransactionServiceImpl.class);

    static BitcoinJSONRPCClient getClient(CoinChannel channel) throws TException {
        String URL = channel.getRpcProtocol() + "://" + channel.getRpcUser() + ":" + channel.getRpcPassword() + "@" + channel.getRpcURL() + ":" + channel.getRpcPort() + "/";
        try {
            return new BitcoinJSONRPCClient(URL);
        } catch (MalformedURLException e) {
            logger.error("init bitcoin client fail", e);
            throw new TException(e);
        }

    }

    @Override
    public SendRequest create(CoinChannel channel, TransactionParam param) throws WalletException, TException {

        try {
            BigDecimal fee = BigDecimal.valueOf(0.0001);//inner calculate
            BigDecimal outAmount = BigDecimal.ZERO;

            List<String> unspentAddresses = new ArrayList<>();
            List<Bitcoin.TxOutput> outputList = new ArrayList<>();

            for (TransactionIO io : param.getIoList()) {
                if (io.getDirection().equals(Direction.SEND)) {
                    unspentAddresses.add(io.getAddress());
                } else {
                    outAmount = outAmount.add(new BigDecimal(io.getAmount()));
                    Bitcoin.TxOutput output = new Bitcoin.BasicTxOutput(io.getAddress(), new BigDecimal(io.getAmount()));
                    outputList.add(output);
                }
            }
            List<Bitcoin.Unspent> unspents = getClient(channel).listUnspent(6, Integer.MAX_VALUE, unspentAddresses.toArray(new String[unspentAddresses.size()]));

            List<Bitcoin.TxInput> inputList = new ArrayList<>();
            if (null == unspents || unspents.size() == 0) {
                throw new WalletException(WalletCommonException.CREATE_AND_SIGN_FAIL.getValue(), "unavailable unspent");
            }

            BigDecimal inAmount = BigDecimal.valueOf(0);
            for (Bitcoin.Unspent unspent : unspents) {
                inAmount = inAmount.add(unspent.amount());
                Bitcoin.TxInput input = new Bitcoin.BasicTxInput(unspent.txid(), unspent.vout());
                inputList.add(input);
                if (inAmount.compareTo(outAmount.add(fee)) != -1) {
                    break;
                }
            }

            if (inAmount.compareTo(outAmount.add(fee)) == -1) {
                throw new WalletException(WalletCommonException.CREATE_AND_SIGN_FAIL.getValue(), "insufficient balance");
            }

            //change
            BigDecimal changeAmount = inAmount.subtract(outAmount.add(fee));
            if (changeAmount.compareTo(BigDecimal.ZERO) == 1) {
                Bitcoin.TxOutput changeOutput = new Bitcoin.BasicTxOutput(param.changeAddress.address, changeAmount);
                outputList.add(changeOutput);

                TransactionIO changeIn = new TransactionIO();
                changeIn.setAddress(param.getChangeAddress().getAddress());
                changeIn.setAmount(changeAmount.toString());
                changeIn.setDirection(Direction.RECEIVE);

            }
            String rawHex = getClient(channel).createRawTransaction(inputList, outputList);
            String signHex = getClient(channel).signRawTransaction(rawHex);
            Bitcoin.RawTransaction rawTx = getClient(channel).decodeRawTransaction(signHex);

            Map<String, String> properties = new HashMap<>();
            properties.put("signHex", signHex);

            SendRequest sendRequest = new SendRequest();
            sendRequest.setTxId(rawTx.txId());
            sendRequest.setCurrencuy(currency());
            sendRequest.setFee(fee.toString());
            sendRequest.setIoList(param.getIoList());
            sendRequest.setProperties(properties);
            return sendRequest;
        } catch (Exception e) {
            logger.error("create transaction fail", e);
            throw new WalletException(WalletCommonException.CREATE_AND_SIGN_FAIL.getValue(), e.getMessage());
        }
    }

    @Override
    public ChainTransaction send(CoinChannel channel, SendRequest request) throws WalletException, TException {
        try {
            String txId = getClient(channel).sendRawTransaction(request.getProperties().get("signHex"));
            ChainTransaction chainTransaction = new ChainTransaction();
            chainTransaction.setTxId(txId);
            chainTransaction.setCurrency(currency());
            chainTransaction.setFee(request.getFee());
            chainTransaction.setIoList(request.getIoList());
            chainTransaction.setStatus(TransactionStatus.SENT);
            chainTransaction.setCategory(Category.CREATE_AND_SIGN);
            return chainTransaction;
        } catch (Exception e) {
            logger.error("send fail, channel:{}, request:{}", channel.id, request, e);
            throw new WalletException(WalletCommonException.SENT_UNKNOWN_RESULT.getValue(), e.getMessage());
        }
    }

    @Override
    public ChainTransaction queryTransaction(CoinChannel channel, String txId) throws WalletException, TException {
        try {
            return parseChainTransactionFromWallet(channel, txId);
        } catch (Exception e) {
            logger.error("query fail, channel:{}, txId:{}", channel.id, txId, e);
            throw new TException(e.getCause());
        }
    }

    @Override
    public List<ChainTransaction> queryTransactions(CoinChannel channel, QueryParam queryParam) throws WalletException, TException {
        List<ChainTransaction> ctList = new ArrayList<>();
        try {
            boolean queryEnd = false;
            long lastBlockTime = queryParam.getEndReceiveTime();
            Bitcoin.Block block = getClient(channel).getBlock(queryParam.startBlockHash);
            while (!queryEnd && block != null && block.time().getTime() >= queryParam.getStartReceiveTime() && lastBlockTime <= queryParam.getEndReceiveTime()){
                //TODO parse block.tx
            }
        } catch (BitcoinException e) {
            e.printStackTrace();
        }
        return ctList;
    }

    @Override
    public Map<Address, String> getBalance(CoinChannel channel, List<Address> accounts) throws WalletException, TException {
        try {
            Map<Address, String> map = new HashMap<>();
            if (null != accounts && accounts.size() > 0) {
                for (Address account : accounts) {
                    double balance = getClient(channel).getBalance(account.getAccount());
                    map.put(account, String.valueOf(balance));
                }
            }
            return map;
        } catch (BitcoinException e) {
            logger.error("query fail, channel:{}, accounts:{}", channel.id, accounts.size(), e);
            throw new TException(e.getCause());
        }
    }

    @Override
    public TransactionStatus confirmStatus(ChainTransaction chainTransaction, CoinChannel channel) throws WalletException, TException {
        if (chainTransaction.getConfirmations() >= 6) {
            return TransactionStatus.CONFIRMED;
        }
        if (chainTransaction.getReceiveTime() > DateUtils.addHours(new Date(), -24).getTime()) {
            return TransactionStatus.EXPIRED;
        }
        return TransactionStatus.UNKNOWN;
    }

    @Override
    public Address createAddress(CoinChannel channel, String account) throws WalletException, TException {

        String address;
        try {
            if (StringUtils.isNotBlank(account)) {
                address = getClient(channel).getNewAddress(account);
            } else {
                address = getClient(channel).getNewAddress();
            }
        } catch (Exception e) {
            logger.error("create address fail, channel:{}, account:{}", channel.id, account, e);
            WalletException e1 = new WalletException(WalletCommonException.CREATE_ADDRESS_FAIL.getValue(), e.getMessage());
            e1.setStackTrace(e.getStackTrace());
            throw e1;
        }
        Address addr = new Address(address, account, MemoType.DEFAULT);
        addr.setAccount(account);
        return addr;

    }

    @Override
    public Map<String, Address> batchCreateAddresses(CoinChannel channel, List<String> accounts) throws WalletException, TException {
        Map<String, Address> accountAddressMap = new HashMap<>();
        for (String account : accounts) {
            accountAddressMap.put(account, createAddress(channel, account));
        }
        return accountAddressMap;
    }

    @Override
    public boolean validateAddress(CoinChannel channel, Address address) throws WalletException, TException {
        try {
            Bitcoin.AddressValidationResult result = getClient(channel).validateAddress(address.getAddress());
            return result.isValid();
        } catch (BitcoinException e) {
            logger.error("validate address fail, channel:{}, account:{}", channel.id, address.address, e);
            throw new TException(e.getCause());
        }
    }

    @Override
    public String currency() throws TException {
        return "BTC";
    }

    public Category category() throws TException {
        return Category.CREATE_AND_SIGN;
    }

    @Override
    public ChainTransaction processTransaction(CoinChannel channel, Map<String, String> params) throws WalletException, TException {
        String txId = params.get("tx");
        return parseChainTransactionFromWallet(channel, txId);
    }


    private ChainTransaction parseChainTransactionFromWallet(CoinChannel channel, String txId) {
        ChainTransaction ct = new ChainTransaction();
        ct.setTxId(txId);
        Bitcoin.RawTransaction rawTx = null;
        try {
            rawTx = getClient(channel).getTransaction(ct.getTxId());
        } catch (Exception e) {
            logger.error("channel:{}, tx:{}", channel.id, txId, e);
        }
        if (null == rawTx) {//不是相关的tx
            return null;
        }
        ct.setConfirmations(rawTx.confirmations());
        ct.setBlockHash(rawTx.blockHash());
        ct.setBlockIndex(String.valueOf(rawTx.blockIndex()));
        ct.setBlockTime(rawTx.blockTime().getTime());
        ct.setReceiveTime(rawTx.timeReceived().getTime());
        ct.setStatus(TransactionStatus.SENT);

        //封装收发金额
        if (null != rawTx.fee()) {
            ct.setFee(rawTx.fee().abs().toString());
        }

        try {
            List<TransactionIO> ioList = new ArrayList<>();
            Bitcoin.RawTransaction decodeRawTx = getClient(channel).decodeRawTransaction(rawTx.hex());
            List<Map<Long, Bitcoin.RawTransaction>> inVoutAndTxMapList = new ArrayList<>();
            for (Bitcoin.RawTransaction.In i : decodeRawTx.vIn()) {
                try {
                    Bitcoin.RawTransaction iRawTx = getClient(channel).getTransaction(i.txid());
                    Map<Long, Bitcoin.RawTransaction> inVoutAndTxMap = new HashMap<>();
                    inVoutAndTxMap.put(Long.valueOf(i.vout()), iRawTx);
                    inVoutAndTxMapList.add(inVoutAndTxMap);
                } catch (Exception e) {
                }
            }
            for (Bitcoin.RawTransaction.Out out : decodeRawTx.vOut()) {
                TransactionIO output = new TransactionIO();
                String address = out.scriptPubKey().addresses().get(0);
                output.setAddress(address);
                output.setAmount(out.value().toString());
                output.setDirection(Direction.SEND);
                boolean isNeedAdd = isNewTransactionIO(ioList, output);
                if (isNeedAdd) {
                    ioList.add(output);
                }
            }

            //封装in
            if (inVoutAndTxMapList.size() > 0) {//本channel出的钱
                for (int i = 0; i < inVoutAndTxMapList.size(); i++) {
                    for (Map.Entry<Long, Bitcoin.RawTransaction> entry : inVoutAndTxMapList.get(i).entrySet()) {
                        Bitcoin.RawTransaction decodeInRaw = getClient(channel).decodeRawTransaction(entry.getValue().hex());
                        TransactionIO input = new TransactionIO();
                        for (Bitcoin.RawTransaction.Out out : decodeInRaw.vOut()) {
                            if (Long.valueOf(out.n()) == entry.getKey()) {
                                String address = out.scriptPubKey().addresses().get(0);
                                input.setAddress(address);
                                input.setAmount(out.value().abs().toString());
                                input.setDirection(Direction.RECEIVE);
                                boolean isNeedAdd = isNewTransactionIO(ioList, input);
                                if (isNeedAdd) {
                                    ioList.add(input);
                                }
                            }
                        }
                    }
                }
            }

            ct.setIoList(ioList);
        } catch (Exception e) {
            logger.error("process fail, txId:{}", txId, e);
        }
        return ct;
    }

    boolean isNewTransactionIO(List<TransactionIO> ioList, TransactionIO io) {
        if (null == ioList) {
            return true;
        }
        for (int i = 0; i < ioList.size(); i++) {
            if (ioList.get(i).getAddress().equals(io.getAddress()) &&
                    ioList.get(i).getDirection().equals(io.getDirection())) {
                ioList.get(i).amount = new BigDecimal(ioList.get(i).amount).add(new BigDecimal(io.amount)).toString();
                return false;
            }
        }
        return true;
    }
}
