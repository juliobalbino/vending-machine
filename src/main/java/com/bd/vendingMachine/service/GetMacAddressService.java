package com.bd.vendingMachine.service;

import org.springframework.stereotype.Service;
import java.net.InetAddress;
import java.net.NetworkInterface;


@Service
public class GetMacAddressService {

    public  String getMacAddress() {

        String macAddress = null;

        try {
            InetAddress ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            if (network == null) {
                macAddress = "00";
                return macAddress;
            }

            byte[] mac = network.getHardwareAddress();

            if (mac == null) {
                macAddress = "00";
                return macAddress;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            macAddress = sb.toString();
            return macAddress;
        } catch (Exception e) {
            macAddress = "00";
            return macAddress;
        }
    }
}

