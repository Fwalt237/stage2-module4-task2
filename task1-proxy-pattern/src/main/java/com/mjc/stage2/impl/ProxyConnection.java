package com.mjc.stage2.impl;
import com.mjc.stage2.Connection;

import java.sql.DriverManager;


public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        // Write your code here!
        Connection proxyConnection=realConnection;
        realConnection=null;
        proxyConnection.close();
    }

    @Override
    public void close() {
        this.realConnection.close();
    }

    @Override
    public boolean isClosed() {
        return this.realConnection.isClosed();
    }
    // Implement methods here!
}
