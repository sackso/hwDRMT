package RMI.Hello; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.HashMap;


public class Client { 
    
    private Client() { 

    } 

    public void helloTest() throws Exception{
        try { 
            
            String host =  null;
            System.out.println("host = "+host);
            Registry registry = LocateRegistry.getRegistry(host); 
            
            Hello stub = (Hello) registry.lookup("Hello"); 
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
        
        Client cli = new Client();
        cli.helloTest();

    } 
}

