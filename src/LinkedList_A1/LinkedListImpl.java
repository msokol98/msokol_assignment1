/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {

	Node headCell; // this will be the entry point to your linked list (the head)
	Node lastCell; // this is the Node at the end of the list... the starting place
					// if you wanted to traverse the list backwards

	int numElts = 0;

	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		headCell = null; // Note that the root's data is not a true part of your data set!
		lastCell = null;
	}

	// implement all methods in interface, and include the getRoot method we made
	// for testing
	// purposes. Feel free to implement private helper methods!

	// add the fields you need to add to make it work... like a

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return headCell;
	}

	public Node getLast() { // leave this method as is, used by the grader to grab your linkedList easily.
		return lastCell;
	}

	@Override
	public boolean insert(double elt, int index) {
		// TODO Auto-generated method stub
		
		if(index < 0 || index > numElts) {
			return false;
		}
		
		//being here means given index is valid so create new node to insert
		Node newNode = new Node(elt);
		
		if(numElts == 0) { //adding first cell
			headCell = newNode;
			lastCell = newNode;
			return goodInsert();
		}
				
		if(index == 0) { //the new node is the head
			newNode.next = headCell;
			headCell.prev = newNode;
			headCell = newNode; 
			return goodInsert();
		}
		
		if(index == numElts)  { //the new node is the caboose
			lastCell.next = newNode;
			newNode.prev = lastCell;
			lastCell = newNode;
			return goodInsert();
		}
		
		Node currentNode = headCell;
		for(int i = 0; i < index-1; i++) {
			currentNode = currentNode.next;
		}
		
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		newNode.prev = currentNode;
		newNode.next.prev = newNode;
		
		return goodInsert();
	}

	@Override
	public boolean insort(double elt) {
		// TODO Auto-generated method stub
		
		Node newNode = new Node(elt);
		
		if(headCell == null || headCell.getData() > newNode.getData()) {
			newNode.next = headCell;
			headCell = newNode;
			return goodInsert();
		}
		
		
		Node currentNode = headCell;
		
		while(currentNode.next != null &&
				currentNode.next.getData() <= newNode.getData()) {
			currentNode = currentNode.next;
		}
		
		if(currentNode.next != null) { // if not last
			currentNode.next.prev = newNode;
			newNode.prev = currentNode;
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			return goodInsert();
		} else { // being here means it's last
			newNode.prev = currentNode;
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			lastCell = newNode;
			return goodInsert();
		}
		
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		
		if(index < 0 || index > numElts-1) {
			return false;
		}
		
		//being here means given index is valid so create new node to insert
		
		if(index == 0)  { // removing head
			headCell.next.prev = null;
			headCell = headCell.next;
			return goodDeletion();
		}
		
		if(index == numElts-1) { //removing last 
			lastCell.prev.next = null;
			lastCell = lastCell.prev;
			return goodDeletion();
		}
		
		Node currentNode = headCell;
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		currentNode.prev.next = currentNode.next;
		currentNode.next.prev = currentNode.prev;
		return goodDeletion();
	}

	@Override
	public double get(int index) {
		// TODO Auto-generated method stub
		Node currentNode = headCell;
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.getData();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElts;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numElts == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		numElts = 0;
		headCell = null;
		lastCell = null;
	}
	
	private boolean goodInsert() {
		numElts++;
		return true;
	}
	
	private boolean goodDeletion() {
		numElts--;
		return true;
	}
}