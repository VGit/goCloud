/*
 * Copyright (c) 2009
 * United States Postal Service
 * All Rights Reserved.
 *
 * This document contains proprietary and confidential
 * information, and shall not be reproduced, transferred,
 * or disclosed to others, without the prior written consent of
 * United States Postal Service.
 */

package com.crgt.innov2015.security.ldap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author B7WFH0
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class CustomSocketFactory extends SocketFactory {

    private static SocketFactory blindFactory = null;

    /**
     * Builds an all trusting "blind" ssl socket factory.
     */

    static {
        // create a trust manager that will purposefully fall down on the
        // job
        TrustManager[] blindTrustMan = new TrustManager[] {
            new X509TrustManager() {

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] c, String a) {
                }

                public void checkServerTrusted(X509Certificate[] c, String a) {
                }
            }};

        // create our "blind" ssl socket factory with our lazy trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, blindTrustMan, new java.security.SecureRandom());
            blindFactory = sc.getSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @see javax.net.SocketFactory#getDefault()
     */
    public static SocketFactory getDefault() {
        return new CustomSocketFactory();
    }

    /**
     *
     * @param arg0
     * @param arg1
     * @return
     * @throws IOException
     * @throws UnknownHostException
     */
    public Socket createSocket(String arg0, int arg1) throws IOException, UnknownHostException {
        return blindFactory.createSocket(arg0, arg1);
    }

    /**
     *
     * @param arg0
     * @param arg1
     * @return
     * @throws IOException
     */
    public Socket createSocket(InetAddress arg0, int arg1) throws IOException {
        return blindFactory.createSocket(arg0, arg1);
    }

    /**
     *
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     * @throws IOException
     * @throws UnknownHostException
     */
    public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3) throws IOException, UnknownHostException {
        return blindFactory.createSocket(arg0, arg1, arg2, arg3);
    }

    /**
     *
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     * @throws IOException
     */
    public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2, int arg3) throws IOException {
        return blindFactory.createSocket(arg0, arg1, arg2, arg3);
    }

}