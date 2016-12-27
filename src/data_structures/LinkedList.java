package data_structures;

public class LinkedList {
	// reference to the head node.
	private Node head;
	private int listCount;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		listCount = 0;
	}

	public void add(Node node) {
		// post: appends the specified element to the end of this list.
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while (current.next != null) {
			current = current.next;
		}
		// the last node's "next" reference set to our new node
		current.next = node;
		listCount++;// increment the number of elements variable
	}

	public void add(int index, Node node) {
		// post: inserts the specified element at the specified position in this
		// list.
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 0; i < index; i++) {
			if (current.next != null) {
				current = current.next;
			}
		}
		// set the new node's next-node reference to this node's next-node
		// reference
		// now set this node's next-node reference to the new node
		current.next = node;
		listCount++;// increment the number of elements variable
	}

	public Node get(int index) {
		// post: returns the element at the specified position in this list.
		// index must be 0 or higher
		if (index < 0)
			return null;

		Node current = head.next;
		for (int i = 0; i < index; i++) {
			if (null != current.next) {
				current = current.next;
			}
		}
		return current;
	}

	public boolean remove(int index) {
		// post: removes the element at the specified position in this list.
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.next = current.next.next;
		listCount--; // decrement the number of elements variable
		return true;
	}

	public int size() {
		// post: returns the number of elements in this list.
		return listCount;
	}

	public String toString() {
		Node current = head;
		String output = "[";
		while (current != null) {
			output += "[" + current.data.toString() + "],";
			current = current.next;
		}
		output = output.substring(0, output.length() - 1);
		output += "]";
		return output;
	}

	public void addAtFront(final Node node) {
		if (null == head) {
			head = node;
		}
		node.next = head;
		head = node;
	}

	public void insertAfter(final Node existingNode, Node newNode) {
		if (null == existingNode || null == newNode) {
			System.out.print("Error in insertAfter(");
			return;
		}
		newNode.next = existingNode.next;
		existingNode.next = newNode;
	}

	public void insertAtEnd(Node node) {
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
	}

	public void deleteNode(final Node node) {
		if (head == null) {
			System.out.println("Error ,List is empty");
		}
		Node previousNode = null;
		Node current = head;
		while (current.next != null && current.data != node.data) {
			previousNode = current;
			current = current.next;
		}
		previousNode.next = node.next;
	}

	public void test() {
		Node headNode = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		head = headNode;

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		System.out.println("" + this);
		//
		// Node addAtFrontNode = new Node(-1);
		// addAtFront(addAtFrontNode);
		// System.out.println("" + this);
		//
		// Node insertAfterNode = new Node(2.5);
		// insertAfter(node2, insertAfterNode);
		// System.out.println("" + this);
		//
		// Node insertAtEndNode = new Node(4);
		// insertAtEnd(insertAtEndNode);
		// System.out.println("" + this);
		//
		// deleteNode(node2);
		// System.out.println("" + this);

		// int count = getListCount();
		// int count = getListCountRecursive(head);
		// System.out.println("count:" + count);
		// head = deleteFirst(head);
		// System.out.println("" + this);
		// swapNodes(node2, node3);
		// head = reverseList();
		// head = reverseUsingRecursion(head);
		head = reverseUsingTailRecursion(null, head);
		System.out.println("" + this);
	}

	private void deleteFirst() {
		if (null == head) {
			System.out.print("List is empty");
		}
		Node node = head.next;
		head = node;
	}

	private Node deleteFirst(Node head) {
		if (null == head) {
			System.out.print("List is empty");
		}
		Node node = head.next;
		return node;
	}

	public int getListCount() {
		if (null == head) {
			return 0;
		}
		int count = 0;
		Node node = head;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	public int getListCountRecursive(Node node) {
		if (null == head) {
			return 0;
		}
		if (null != node) {
			return 1 + getListCountRecursive(node.next);
		}
		return 0;
	}

	private void swapNodes(final Node nodeX, Node nodeY) {
		if (nodeX == nodeY)
			return; // Nothing to swap as keys are same

		Node current = head;
		Node prevX = null;
		Node prevY = null;
		Node currentX = null;
		Node currentY = null;

		if (head.data == nodeX.data) {
			currentX = head;
		} else if (head.data == nodeY.data) {
			currentY = head;
		}

		while (current != null) {
			Node prev = current;
			current = current.next;

			if (null == current) {
				break;
			}
			if (current.data == nodeX.data) {
				prevX = prev;
				currentX = current;
			}

			if (current.data == nodeY.data) {
				prevY = prev;
				currentY = current;
			}
		}
		// If either x or y is not present, nothing to do
		if (currentX == null || currentY == null)
			return;

		/* Swap the next pointer and current pointers */
		System.out.println("prevX:" + prevX + ",currentX:" + currentX
				+ ",prevY:" + prevY + ",currentY:" + currentY);

		if (prevX != null) {
			prevX.next = currentY;
		} else {
			head = currentY;
		}
		if (prevY != null) {
			prevY.next = currentX;
		} else {
			head = currentX;
		}

		// Swap next pointers
		Node temp = currentY.next;
		currentY.next = currentX.next;
		currentX.next = temp;
	}

	private Node reverseList() {
		Node previus = null;
		Node next = null;
		Node current = head;
		while (current != null) {
			next = current.next;

			current.next = previus;
			previus = current;
			current = next;
		}
		return previus;
	}

	public Node reverseUsingRecursion(Node node) {
		if (node == null)// Empty List
			return null;
		if (node.next == null) // Only one element.
			return node;

		Node next = node.next;
		Node reverseRest = reverseUsingRecursion(next);
		// then we join the two lists
		next.next = node;
		// point last node to nil, (get rid of cycles)
		node.next = null;
		return reverseRest;
	}

	// A Simpler and Tail Recursive Method
	private Node reverseUsingTailRecursion(Node previous, Node current) {
		Node next = current.next;
		current.next = previous;
		System.out.println("previous:" + previous + ",current:" + current);

		return next == null ? current
				: reverseUsingTailRecursion(current, next);
	}

}
