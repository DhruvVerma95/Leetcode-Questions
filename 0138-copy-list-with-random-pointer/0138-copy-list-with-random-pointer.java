/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert new nodes between original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val); // Create a new node with the same value
            newNode.next = curr.next;          // Insert the new node after the original node
            curr.next = newNode;
            curr = newNode.next;               // Move to the next original node
        }

        // Step 2: Set up the random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next; // Copy random pointer
            }
            curr = curr.next.next; // Move to the next original node
        }

        // Step 3: Separate the original and the copied lists
        curr = head;
        Node copiedHead = head.next;
        Node copy = copiedHead;

        while (curr != null) {
            curr.next = curr.next.next;      // Restore original list
            if (copy.next != null) {
                copy.next = copy.next.next;  // Set next for the copied list
            }
            curr = curr.next;
            copy = copy.next;
        }

        return copiedHead; // Return the head of the copied list
    }
}