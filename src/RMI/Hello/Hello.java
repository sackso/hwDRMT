package RMI.Hello;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface Hello extends Remote{
    String sayHello() throws RemoteException;

    HashMap getObjectToMap(String key, String val) throws RemoteException;
}