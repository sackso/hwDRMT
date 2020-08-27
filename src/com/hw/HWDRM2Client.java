package com.hw; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.HashMap;


public class HWDRM2Client { 
    
    private HWDRM2Client() { 

    } 

    public void helloTest() throws Exception{
        try { 
            
            String host =  null;
            System.out.println("host = "+host);
            Registry registry = LocateRegistry.getRegistry(host); 
            
            HWDRM2IF stub = (HWDRM2IF) registry.lookup("Hello"); 
            //call Hello.sayHello()
            //String response = stub.sayHello(); 
            //System.out.println("response: " + response); 

            HashMap map = stub.getObjectToMap("key","value");
            System.out.println("map: " + map); 
            
            

        } catch (Exception e) { 
            e.printStackTrace();           
        } 
    }
    
    public static void main(String[] args)  throws Exception{
        String host = (args.length < 1) ? null : args[0]; 
        
        HWDRM2Client cli = new HWDRM2Client();
        cli.helloTest();

    } 
}

