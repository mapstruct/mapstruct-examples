/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.dto;

/**
 *
 * @author Adam Gurgul
 */
public class Target {


    private String ip;
    private String server;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "Target{" +
                "ip='" + ip + '\'' +
                ", server='" + server + '\'' +
                '}';
    }
}
