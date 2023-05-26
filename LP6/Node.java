
package bully;
import java.util.List;
class Node {
 private int nodeId;
 private boolean isActive = true;
 Node(int nodeId) {
 this.nodeId = nodeId;
 }
 void sendElectionMessage(List<Node> nodes) {
 System.out.println("Node " + nodeId + " sends Election message.");
 for (Node node : nodes) {
 if (node.nodeId > this.nodeId) {
 node.receiveElectionMessage(this);
 }
 }
   
  // If no higher node responds, this node becomes the leader
   
   System.out.println("Node " + nodeId + " becomes the leader.");
 }
  
   void receiveElectionMessage(Node sender) {
 System.out.println("Node " + nodeId + " received Election message from Node " + sender.nodeId + ".");
 if (isActive) {
 // Node is active, respond with an OK message
 System.out.println("Node " + nodeId + " sends OK message to Node " + sender.nodeId + ".");
 sender.receiveOKMessage(this);
 }
 }
  
  void receiveOKMessage(Node sender) {
 System.out.println("Node " + nodeId + " received OK message from Node " + sender.nodeId + ".");
 // Ignore the OK message since this node is not initiating the election
 }
  
  void crash() {
 System.out.println("Node " + nodeId + " crashes.");
 isActive = false;
 } }

