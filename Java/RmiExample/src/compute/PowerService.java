package compute;

import java.math.BigInteger;
import java.rmi.RemoteException;

public interface PowerService  extends java.rmi.Remote{

	// Calculate the square of a number
		public double square ( int number )
			throws RemoteException;

		// Calculate the power of a number
		public BigInteger power  ( int num1, int num2) 
			throws RemoteException;
}
