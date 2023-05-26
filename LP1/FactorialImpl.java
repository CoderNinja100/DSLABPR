
import java.math.BigInteger;
import java.rmi.RemoteException;

public class FactorialImpl extends java.rmi.server.UnicastRemoteObject implements Factorial{
 protected FactorialImpl() throws RemoteException {
 super();
 }
  @Override
  
  public BigInteger factorial(int n) throws RemoteException {
    BigInteger fact = BigInteger.ONE;
 for (int i = 1; i <= n; i++) {
 fact = fact.multiply(BigInteger.valueOf(i));
 }
 return fact;
    } 
}
