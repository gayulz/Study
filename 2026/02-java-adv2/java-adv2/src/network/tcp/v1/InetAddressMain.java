package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : InetAddressMain
 */
public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println("localhost = " + localhost);

        InetAddress byName = InetAddress.getByName("google.com");
        System.out.println("byName = " + byName);
    }
}
