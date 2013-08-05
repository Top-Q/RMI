package server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.PowerService;
import compute.PowerServiceServer;

/**
 * Server RMI - run this class before the Client
 * 
 * @author liel_r
 *
 */
public class Server {

	
	public static void main(String args[]) throws Exception {

		System.setProperty("java.security.policy", "rmi.policy");
		System.out.println("RMI server started");

		// Create and install a security manager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Security manager installed.");
		} else {
			System.out.println("Security manager already exists.");
		}

		try { // special exception handler for registry creation
			LocateRegistry.createRegistry(1099);
			System.out.println("java RMI registry created.");
		} catch (RemoteException e) {
			// do nothing, error means registry already exists
			System.out.println("java RMI registry already exists.");
		}

		// Assign a security manager, in the event that dynamic
		// classes are loaded
		if (System.getSecurityManager() == null) {
			RMISecurityManager rmiSecurityManager = new RMISecurityManager();
			System.setSecurityManager(rmiSecurityManager);
		}

		// Create an instance of our power service server ...
		PowerService svr = new PowerServiceServer();

		// Bind this object instance to the name "RmiServer"
		UnicastRemoteObject.exportObject(svr, 0);


		// Bind the remote object's stub in the registry
		Registry registry = LocateRegistry.getRegistry();
		registry.bind("PowerService", svr);

		System.out.println("PowerService bound in registry");
	}
}
