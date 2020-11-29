package com.lipisoft.toyshark.database;

public class PacketModel {

    private final String clientIp;
    private final String serverIp;
    private final String timestamp;
    private final int packageSize;
    private final String connectionType;
    private final String protocol;


    public PacketModel(String clientIp, String serverIp, String timestamp, int packageSize, String connectionType, String protocol) {
        this.clientIp = clientIp;
        this.serverIp = serverIp;
        this.timestamp = timestamp;
        this.packageSize = packageSize;
        this.connectionType = connectionType;
        this.protocol =protocol;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getPackageSize() {
        return packageSize;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public String getProtocol() {
        return protocol;
    }
}
