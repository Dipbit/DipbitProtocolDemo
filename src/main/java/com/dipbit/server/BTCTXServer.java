package com.dipbit.server;

import com.dipbit.server.service.impl.BTCTransactionServiceImpl;
import com.dipbit.service.TransactionSerivce;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author penuel
 * @project DipbitProtocolDemo
 * @create 2018/9/5
 * @description
 **/
public class BTCTXServer {

    public static void main(String[] args) {
        try {
            TServerSocket serverTransport = new TServerSocket(9090);
            TransactionSerivce.Processor processor = new TransactionSerivce.Processor(new BTCTransactionServiceImpl());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting server on port 9090 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
