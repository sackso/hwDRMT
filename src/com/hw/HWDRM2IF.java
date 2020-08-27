package com.hw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface HWDRM2IF extends Remote{
    String sayHello() throws RemoteException;

    HashMap getObjectToMap(String key, String val) throws RemoteException;
}