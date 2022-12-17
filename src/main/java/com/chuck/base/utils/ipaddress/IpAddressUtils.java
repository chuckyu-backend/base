package com.chuck.base.utils.ipaddress;

import java.net.InetAddress;

public class IpAddressUtils {

  public static long ipToLongInt(InetAddress ipAddress) {
    long resultIP = 0;
    byte[] ipAddressOctets = ipAddress.getAddress();

    for (byte octet : ipAddressOctets) {
      resultIP <<= 8;
      resultIP |= octet & 0xFF;
    }
    return resultIP;
  }
}
