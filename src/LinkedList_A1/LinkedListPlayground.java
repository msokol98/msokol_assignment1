package LinkedList_A1;

import java.util.Random;

public class LinkedListPlayground {
	public static void main(String[] args) {
		
		LinkedListImpl myList = new LinkedListImpl();
		
		for(int i = 0; i < 1000; i++) {
			myList.insort(new Random().nextInt(1000));
		}
		
		Node cn = myList.lastCell;
		for(int i = 0; i < 1000; i++) {
			System.out.println(cn.data);
			cn = cn.prev;
		}
		
		

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
