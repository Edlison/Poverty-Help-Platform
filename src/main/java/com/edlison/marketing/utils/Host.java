package com.edlison.marketing.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP
 *
 * @Author Edlison
 * @Date 8/15/20 00:56
 */
public class Host {

    public static String addr() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        return host.getHostAddress();
    }
}
