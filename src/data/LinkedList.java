package data;
/**
 * An implementation of a doubly linked list.
 * 
 * @author Alzer Casiño
 * 
 * @since February 11, 2017
 *
 * @param <E> The type of object to be added into the list.
 */
public class LinkedList<E> implements java.io.Serializable {
	
	//-----------------------Nested Node class--------------------
	/**
	 * A nested class that represents a node.
	 * 
	 * @author Alzer Casiño
	 *
	 * @param <E> The type of object inside the node.
	 */
	private static class Node<E> implements java.io.Serializable {
		private E element;       //reference to the element stored in this node.
		private Node<E> prev;    //reference to the previous node in the list.
		private Node<E> next;    //reference to the subsequent node in the list.
		
		/**
		 * Constructs a new node.
		 * 
		 * @param e Reference to the element in the node.
		 * 
		 * @param p Reference to the previous node.
		 * 
		 * @param n Reference to the subsequent node.
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		/**
		 * Returns the element of the node.
		 * 
		 * @return Returns the element of the node.
		 */
		public E getElement() {
			return element;
		}
                
                /**
                 * Sets the element of the node.
                 * 
                 * @param item  The item to be set.
                 */
                public void setElement(E item) {
                    element = item;
                }
		
		/**
		 * Returns the previous node which this node is pointing to.
		 * 
		 * @return Returns the previous node which this node is pointing to.
		 */
		public Node<E> getPrev() {
			return prev;
		}
		
		/**
		 * Returns the next node which this node is pointing to.
		 * 
		 * @return Returns the next node which this node is pointing to.
		 */
		public Node<E> getNext() {
			return next;
		}
		
		/**
		 * Sets a node to be its predecessor.
		 * 
		 * @param p The node to assigned.
		 */
		public void setPrev(Node<E> p) {
			prev = p;
		}
		
		/**
		 * Sets a node to be its successor.
		 * 
		 * @param n The node to be assigned.
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	//----------------------End of nested Node class---------------------
	
	//Instance declaration for the LinkedList class.
	private final Node<E> header;    //reference to the header guard node.
	private final Node<E> trailer;   //reference to the trailer guard node.
	private int size = 0;            //number of elements in the list.
	
	/**
	 * Constructs a new empty list.
	 */
	public LinkedList() {
		header = new Node<>(null, null, null);        //create header.
		trailer = new Node<>(null, header, null);     //trailer is preceded by header.
		header.setNext(trailer);                      //header is followed by trailer.
	}
	
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return Returns the number of elements in the list.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Tests whether the list is empty of not.
	 * 
	 * @return <tt>true</tt> if empty. Otherwise, <tt>false</tt>.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns the first element in the list without deleting it.
	 * 
	 * @return The first element in the list. <tt>null</tt> if empty.
	 */
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return header.getNext().getElement();
	}
	
	/**
	 * Returns the last element in the list without deleting it.
	 * 
	 * @return The last element in the list. <tt>null</tt> if empty.
	 */
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return trailer.getPrev().getElement();
	}
	
	/**
	 * Adds a new item in the front of the list.
	 * 
	 * @param item The item to be added.
	 */
	public void addFirst(E item) {
		addBetween(item, header, header.getNext());
	}
	
	/**
	 * Adds a new item at the end of the list.
	 * 
	 * @param item The item to be added.
	 */
	public void addLast(E item) {
		addBetween(item, trailer.getPrev(), trailer);
	}
	
	/**
	 * Adds a new item into the list.
	 * 
	 * @param index The index where the item will be added.
	 * 
	 * @param item The item to be added.
	 * 
	 * @throws IndexOutOfBoundsException  if <b>index</b> exceeds the size of the list.
	 */
	public void add(int index, E item) {
		Node<E> node = header;
		if(index > size) {
			throw new IndexOutOfBoundsException("Index exceeds: " + (index - size));
		}
		if(index < 0) {
			throw new IndexOutOfBoundsException("Invalid index: " + (index));
		}
		for(int i = 0; i < index; i++) {
			node = node.getNext();
		}
		addBetween(item, node, node.getNext());
	}
	
	/**
	 * Removes the first element in the list.
	 * 
	 * @return The deleted item.
	 */
	public E deleteFirst() {
		if(isEmpty()) {
			return null;
		}
		return remove(header.getNext());
	}
	
	/**
	 * Removes the last element in the list.
	 * 
	 * @return The deleted item.
	 */
	public E deleteLast() {
		if(isEmpty()) {
			return null;
		}
		return remove(trailer.getPrev());
	}
	
	/**
	 * Removes an element in the list with a specific location.
	 * 
	 * @param index The index of the location of the element.
	 * 
	 * @return The deleted item.
	 */
	public E delete(int index) {
		Node<E> node = header;
		if(isEmpty()) {
			return null;
		}
		for(int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return remove(node.getNext());
	}
	
	/**
	 * Returns the element in a specific location in the list.
	 * 
	 * @param index The index of the item.
	 * 
	 * @return Returns the element in a specific location in the list.
	 * 
	 * @throws IndexOutOfBoundsException  if <b>index</b> exceeds the size of the list.
	 * 
	 * @throws NoSuchElementException  if list is empty.
	 */
	public E search(int index) {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		if(index >= size) 
			throw new IndexOutOfBoundsException("Index exceeds: " + (index - size - 1));
		if(index < 0) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}
		Node<E> node = header;
		for(int i = 0; i <= index; i++) {
			node = node.getNext();
		}
		return node.getElement();
	}
	
	/**
	 * Returns all elements of the list.
	 * 
	 * @return Returns all elements of the list.
	 */
	public E[] showAllElements() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		E[] elem = (E[]) new Object[size];
		Node<E> node = header.getNext();
		for(int i = 0; i < size; i++) {
			elem[i] = node.getElement();
			node = node.getNext();
		}
		return elem;
	}
	
	//-------------------------Private update methods----------------------------
	/**
	 * Adds an element into the linked list in between the given nodes.
	 */
	private void addBetween(E item, Node<E> predecessor, Node<E> successor) {
		//Create and link a new node.
		Node<E> newest = new Node<>(item, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	/**
	 * Removes the given node and returns its element.
	 * 
	 * @param node The node to be deleted.
	 * 
	 * @return The element of the deleted node.
	 */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
}
