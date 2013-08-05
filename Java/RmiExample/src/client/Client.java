package client;

import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.PowerService;

public class Client {
	private static int  firstNumber = 9;
	private static int  scondNumber = 2;
	private static int  powerNumber = 3;
	
	static PowerService service = null;

	public static void calc() {
		try {
			service = (PowerService) Naming.lookup("rmi://localhost/PowerService");
			
			double square = service.square(firstNumber);
			BigInteger power = service.power(scondNumber, powerNumber);
			System.out.print("Square of "+firstNumber);
			System.out.println(" is ="+square);
			
			System.out.print(scondNumber +" power "+powerNumber+" =");			
			System.out.println(power);
		} catch (Exception e) {
			System.err.println("RmiClient exception: " + e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MalformedURLException,
			RemoteException, NotBoundException {
		System.setProperty("java.security.policy", "rmi.policy");

		Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		service = (PowerService) registry.lookup("PowerService");
		// Create and install a security manager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		calc();

	}

}
