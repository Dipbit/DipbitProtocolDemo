package com.dipbit.client;

import com.dipbit.model.*;
import com.dipbit.service.TransactionSerivce;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author penuel
 * @project DipbitProtocolDemo
 * @create 2018/9/5
 * @description
 **/
public class BTCTXClient {

    CoinChannel channel;
    TransactionSerivce.Client client;
    TTransport transport;

    @Before
    public void init() {
        channel = new CoinChannel("1", "BTC_A", "BTC", "172.30.30.18", "http", 18332);
        channel.setRpcPassword("HbFwHVrFJHDCx4qxAoQjFysbrJJk99Lwt68EGHYsPQT3");
        channel.setRpcUser("lfcoinrpc");

        transport = new TSocket("localhost", 9090);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        TProtocol protocol = new TBinaryProtocol(transport);
        client = new TransactionSerivce.Client(protocol);

    }

    @After
    public void destory() {
        transport.close();
    }

    @Test
    public void createAddress() {
        Address addr = null;
        try {
            addr = client.createAddress(channel, "thrift");
            System.out.println(addr.address);//2MvJ8DbS8QhnaBzosGpX1Wap6XR4ysWVEvm
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getBalance() {
        try {
            Address addr = new Address("2N96APmEcawpAyMBvj9CRxgbReQV1AkgiYM", "penuel", MemoType.DEFAULT);
            Map<Address, String> map = client.getBalance(channel, Arrays.asList(addr));
            System.out.println(map.get(addr));
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateAddress() {
        try {
            Address addr = new Address("2N96APmEcawpAyMBvj9CRxgbReQV1AkgiYM", "penuel", MemoType.DEFAULT);
            boolean b = client.validateAddress(channel, addr);
            System.out.println(b);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryTransaction() {
        try {
            ChainTransaction ct = client.queryTransaction(channel, "b506f7ec9eb1b9469273616ba986ed2014a5f9509946818a08bd74a048b74a9d");
            System.out.println(ct);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createAndSend() {
        try {
            TransactionParam param = new TransactionParam();
            param.setChangeAddress(new Address("2N96APmEcawpAyMBvj9CRxgbReQV1AkgiYM", "penuel", MemoType.DEFAULT));
            param.setChannelId(channel.getId());
            //send
            TransactionIO send = new TransactionIO("2N3C68fRb8HXwoy1A7nGzBHESn6wpxynsNM", "0.5", Direction.SEND);//a6e2fab44cba456e926a7c03bc338a66
            TransactionIO receive = new TransactionIO("2MvJ8DbS8QhnaBzosGpX1Wap6XR4ysWVEvm", "0.5", Direction.RECEIVE);

            param.setIoList(Arrays.asList(send, receive));

            SendRequest request = client.create(channel, param);
            ChainTransaction ct = client.send(channel, request);

            System.out.println(ct);
        } catch (TException e) {
            e.printStackTrace();
        }
    }


}
