import java.util.*;
import java.io.*;

class SinglyLinkedListItem {
    public int itemData;
    public SinglyLinkedListItem next;

    public SinglyLinkedListItem(int itemData) {
        this.itemData = itemData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListItem head;
    public SinglyLinkedListItem tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insert item at the end of the linked list
    public void insertItem(int itemData) {
        SinglyLinkedListItem item = new SinglyLinkedListItem(itemData);
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }
        this.tail = item;
    }
}

class DisplaySinglyLinkedList {
    public static void displayList(SinglyLinkedListItem item, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (item != null) {
            bufferedWriter.write(String.valueOf(item.itemData));
            item = item.next;
            if (item != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Outcome {
    public static int checkPalindrome(SinglyLinkedList list) {
        if (list.head == null || list.head.next == null) {
            return 1;
        }
        
        SinglyLinkedListItem slow = list.head;
        SinglyLinkedListItem fast = list.head;
       
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.itemData);  
            slow = slow.next;
            fast = fast.next.next;
        }
      
        if (fast != null) {
            slow = slow.next;
        }
      
        while (slow != null) {
            int top = stack.pop();
            if (top != slow.itemData) {
                return 0;
            }
            slow = slow.next;
        }

        return 1; 
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
        SinglyLinkedList list = new SinglyLinkedList();

        String[] tempItems = bufferedReader.readLine().replaceAll("\\s+", " ").split(" ");
        for (int i = 0; i < aCount; i++) {
            int item = Integer.parseInt(tempItems[i]);
            list.insertItem(item);
        }

        // Check if the list is a palindrome
        int outcome = Outcome.checkPalindrome(list);

        // Write the output
        bufferedWriter.write(outcome + "\n");
        bufferedWriter.close();
        bufferedReader.close();
    }
}
