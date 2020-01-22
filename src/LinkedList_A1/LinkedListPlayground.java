package LinkedList_A1;

import java.util.Random;

public class LinkedListPlayground {
	public static void main(String[] args) {
		
		LinkedListImpl myList = new LinkedListImpl();
		
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			int myInt = r.nextInt(20);
			System.out.println(myInt);
			myList.insert(myInt, 0);
		}
		
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
