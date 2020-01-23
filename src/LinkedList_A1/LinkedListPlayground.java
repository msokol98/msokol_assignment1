package LinkedList_A1;

import java.util.Random;

public class LinkedListPlayground {
	public static void main(String[] args) {
		
		LinkedListImpl myList = new LinkedListImpl();
		
		myList.insert(2, 0);
		myList.insert(5, 1);
		myList.insert(8, 0);
		myList.insert(92, 1);
		myList.insert(20, 4);
		
		// 8, 92, 2, 5
		
		myList.remove(2);
		printList(myList);

	}

	public static void printList(LinkedListImpl L){ 
		    //note that this is a good example of how to iterate through your linked list
		    // since we know how many elements are in the list we can use a for loop
		    Node curr=L.headCell; // the first data node in the list... might be null
		    System.out.print("List: ");
		    for(int i=0; i<L.size(); i++) { 
		      System.out.print(" --> " + curr.data);
		      curr=curr.next;
		    }
		    System.out.println();
	}

}
