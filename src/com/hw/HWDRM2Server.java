package com.hw;

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;



public class HWDRM2Server implements HWDRM2IF{
    public HWDRM2Server(){}

    public String sayHello(){
        return "Hello, world!";
    }

    public HashMap getObjectToMap(String key, String val) {
        HashMap map = new HashMap();
        
        map.put(key,val);

        return map;
    }

    public static void main(String[] args) {
        HWDRM2Server obj = new HWDRM2Server();

        try {
            HWDRM2IF stub = (HWDRM2IF) UnicastRemoteObject.exportObject(obj,0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello",stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}