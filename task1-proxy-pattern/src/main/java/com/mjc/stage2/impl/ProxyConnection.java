package com.mjc.stage2.impl;
import com.mjc.stage2.Connection;

import java.sql.DriverManager;


public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        this.realConnection.close();
    }

    @Override
    public void close() {
        ConnectionPool.getInstance().releaseConnection(this.realConnection);
    }

    @Override
    public boolean isClosed() {
        return false;
    }
}
