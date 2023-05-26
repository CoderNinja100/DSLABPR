
import java.rmi.Naming;
public class FactorialServer {
 public FactorialServer(){
 try {
 Factorial factorial = new FactorialImpl();
 Naming.rebind("rmi://localhost/FactorialService", factorial);
 }catch (Exception e){
 System.out.println("Exception: "+e);
 }
 }
 public static void main(String[] args) {
 new FactorialServer();
 } }
