package com.test.socket;

import java.net.InetAddress;

/**
 * Created by szh on 2017/9/10.
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("gw.buaa.edu.cn"); //("www.baidu.com");
        boolean result = address.isReachable(5000);

        System.out.println("是否能到达 : " + result);
        System.out.println(address.getHostAddress() + "  " +
                address.getHostName());

        //通过IP创建InetAddress
        InetAddress selfAddress = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("selfAddress 是否能到达 : " + selfAddress.isReachable(5000));

    }
}
