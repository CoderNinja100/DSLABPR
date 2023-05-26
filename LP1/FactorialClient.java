
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class FactorialClient {
 public static void main(String[] args) {
 try {
 Factorial fact = (Factorial) Naming.lookup("rmi://localhost/FactorialService");
 System.out.println(fact.factorial(30));
 } catch (MalformedURLException e) {
 System.out.println("Malformed URL: " + e);
 } catch (RemoteException e) {
 System.out.println("Remote Exception: " + e);
 } catch (NotBoundException e) {
 System.out.println("Not Bound Exception: " + e);
 }catch (ArithmeticException ae){
 System.out.println("Arithmetic Exception: "+ae);
 }
 } }
