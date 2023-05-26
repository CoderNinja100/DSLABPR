
import java.math.BigInteger;
public interface Factorial extends java.rmi.Remote{
 public BigInteger factorial(int n) throws java.rmi.RemoteException;
}
