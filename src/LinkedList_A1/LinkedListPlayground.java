package LinkedList_A1;

import java.util.Scanner;

public class LinkedListPlayground {
	public static void main(String[] args) {
		
		LinkedListImpl myList = new LinkedListImpl();
		
		Scanner sn = new Scanner(System.in);
		
		double input = sn.nextDouble();
		int index = sn.nextInt();
		
		while(input != -1 && index != -1) {
			myList.insert(input, index);
			printList(myList);
			
			input = sn.nextDouble();
			index = sn.nextInt();
		}
		
		index = sn.nextInt();
		
		while(index != -1) {
			myList.remove(index);
			printList(myList);
			
			index = sn.nextInt();
		}
		
		
		
		
		
		sn.close();
		

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
