package com.example.numberconversion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NumberConverterImp extends UnicastRemoteObject implements NumberRemote {
    protected NumberConverterImp() throws RemoteException {
        super();
    }

    @Override
    public String BinaryToDecimal(String binaryString) {
        int decimal = 0;
        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return String.valueOf(decimal);
    }

    @Override
    public String BinaryToOctal(int binary) throws RemoteException {
        StringBuilder octal = new StringBuilder();
        String binaryStr = Integer.toString(binary);
        int numDigits = binaryStr.length();
        int numPadding = numDigits % 3 == 0 ? 0 : 3 - numDigits % 3;
        binaryStr = "0".repeat(numPadding) + binaryStr;
        for (int i = 0; i < binaryStr.length(); i += 3) {
            String binaryGroup = binaryStr.substring(i, i + 3);
            int octalDigit = Integer.parseInt(binaryGroup, 2);
            octal.append(octalDigit);
        }
        return octal.toString();
    }


    @Override
    public String BinaryToHexa(int Binary) throws RemoteException {
        return Integer.toHexString(Binary);
    }

    @Override
    public String DecimalToBinary(int decimal) throws RemoteException {
        return Integer.toBinaryString(decimal);
    }

    @Override
    public String DecimalToOctal(int decimal) throws RemoteException {
        return Integer.toOctalString(decimal);
    }

    @Override
    public String DecimalToHexa(int decimal) throws RemoteException {
        return Integer.toHexString(decimal);
    }
    @Override
    public String OctalTobinary(int octal) throws RemoteException {
        StringBuilder binary = new StringBuilder();
        String octalStr = Integer.toString(octal);
        for (int i = 0; i < octalStr.length(); i++) {
            int digit = Character.getNumericValue(octalStr.charAt(i));
            String binaryStr = Integer.toBinaryString(digit);
            while (binaryStr.length() < 3) {
                binaryStr = "0" + binaryStr;
            }
            binary.append(binaryStr);
        }
        return binary.toString();
    }

    @Override
    public String OctalToDecimal(int octal) throws RemoteException {
        return Integer.toString(octal,2);
    }

    @Override
    public String OctalToHexa(int octal) throws RemoteException {
        return Integer.toHexString(octal);
    }

    @Override
    public String HexaToBinary(int Hexa) throws RemoteException {
        return Integer.toBinaryString(Hexa);
    }

    @Override
    public String HexaToDecimal(int hexa) throws RemoteException {
        return Integer.toString(hexa, 10);
    }

    @Override
    public String HexaToOctal(int Hexa) throws RemoteException {
        return Integer.toOctalString(Hexa);
    }
}
