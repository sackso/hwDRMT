package RMI.Hello;

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;



public class Server implements Hello{
    public Server(){}

    public String sayHello(){
        return "Hello, world!";
    }

    public HashMap getObjectToMap(String key, String val) {
        HashMap map = new HashMap();
        
        map.put(key,val);

        return map;
    }

    public static void main(String[] args) {
        Server obj = new Server();

        try {
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello",stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}