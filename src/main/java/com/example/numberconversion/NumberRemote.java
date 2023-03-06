package com.example.numberconversion;

import java.rmi.*;
public interface NumberRemote  extends Remote{

    public String BinaryToDecimal(String binaryString)throws RemoteException;
    public String BinaryToOctal(int binary)throws RemoteException;
    public String BinaryToHexa(int Binary)throws RemoteException;
    public String DecimalToBinary(int decimal)throws RemoteException;
    public String DecimalToOctal(int decimal)throws RemoteException;
    public String DecimalToHexa(int decimal)throws RemoteException;
    public String OctalTobinary(int octal)throws RemoteException;
    public String OctalToDecimal(int octal)throws RemoteException;
    public String OctalToHexa(int octal)throws RemoteException;
    public String HexaToBinary(int Hexa)throws RemoteException;
    public String HexaToDecimal(int Hexa)throws RemoteException;
    public String HexaToOctal(int Hexa)throws RemoteException;



}
