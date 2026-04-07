class Node_SIT {
    int data;
    Node_SIT next;

    public Node_SIT(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SIT_202 {
    static void printList(Node_SIT head) {
        Node_SIT current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static boolean detectCycle(Node_SIT head) {
        Node_SIT slow = head;
        Node_SIT fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2

            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }

    public static void removeCycle(Node_SIT head) {
        if (head == null || head.next == null) {
            return;
        }

        Node_SIT slow = head;
        Node_SIT fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected, now find the start of the cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Find the last node in the cycle and remove the link
                Node_SIT temp = fast;
                while (temp.next != fast) {
                    temp = temp.next;
                }
                temp.next = null; // Remove the cycle
                return;
            }
        }
    }

    public static void main(String[] args) {
        Node_SIT head = new Node_SIT(10);

        head.next = new Node_SIT(20);
        head.next.next = new Node_SIT(30);
        head.next.next.next = new Node_SIT(40);
        head.next.next.next.next = new Node_SIT(50);
        head.next.next.next.next.next = head.next;

        System.out.print("Before removing cycle: ");
        System.out.println("Has cycle? " + detectCycle(head));

        removeCycle(head);

        System.out.print("After removing cycle: ");
        printList(head);
        System.out.println("Has cycle? " + detectCycle(head));
    }
}
