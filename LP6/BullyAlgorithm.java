
import java.util.ArrayList;
import java.util.List;
public class BullyAlgorithm {
 public static void main(String[] args) {
 // Create nodes
 List<Node> nodes = new ArrayList<>();
 for (int i = 1; i <= 5; i++) {
 nodes.add(new Node(i));
 }
 // Node 3 initiates the election
 nodes.get(2).sendElectionMessage(nodes);
 // Node 1 crashes
 nodes.get(0).crash();
 // Node 4 initiates the election
 nodes.get(3).sendElectionMessage(nodes);
 } }
