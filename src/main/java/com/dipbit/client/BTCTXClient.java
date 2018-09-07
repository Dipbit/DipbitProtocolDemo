package com.dipbit.client;

import com.dipbit.model.Address;
import com.dipbit.model.CoinChannel;
import com.dipbit.service.TransactionSerivce;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author penuel
 * @project DipbitProtocolDemo
 * @create 2018/9/5
 * @description
 **/
public class BTCTXClient {
    public static void main(String[] args) {
        try {
            CoinChannel channel = new CoinChannel("1","BTC","BTC",1,"http","172.30.30.18","18333");

            TTransport transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            TransactionSerivce.Client client = new TransactionSerivce.Client(protocol);

            Address addr = client.createAddress(channel, "thrift");
            System.out.println(addr.address);
            transport.close();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
