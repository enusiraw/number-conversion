package com.example.numberconversion;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NumberServer {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.createRegistry(3333);
            NumberConverterImp skeleton = new NumberConverterImp();
            registry.rebind("Binary To Decimal",skeleton);
            registry.rebind("Binary To Ocatal",skeleton);
            registry.rebind("BTH",skeleton);
            registry.rebind("DTB",skeleton);
            registry.rebind("DTO",skeleton);
            registry.rebind("DTH",skeleton);
            registry.rebind("OTB",skeleton);
            registry.rebind("OTD",skeleton);
            registry.rebind("OTH",skeleton);
            registry.rebind("HTB",skeleton);
            registry.rebind("HTD",skeleton);
            registry.rebind("HTO",skeleton);

            System.out.println("Server is running....");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
