package compute;

import java.io.Serializable;
import java.math.BigInteger;
import java.rmi.RemoteException;

public class PowerServiceServer implements PowerService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public double square(int number) throws RemoteException {

        String numrep = String.valueOf(number);
        BigInteger bi = new BigInteger (numrep);
        
         double sqrt = Math.sqrt(number);
        // Square the number

        return (sqrt);
	}

	@Override
	public BigInteger power(int num1, int num2) throws RemoteException {
		 String numrep = String.valueOf(num1);
	        BigInteger bi = new BigInteger (numrep);

		bi = bi.pow(num2);
		return bi;
	}

}
