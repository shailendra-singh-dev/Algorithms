package data_structures.stack;

import data_structures.Node;

public class StackUsingLinkedList {

	private static final int MAX_SIZE = 1000;
	private Node mHead;
	private int mTop;
	private int mSize;

	public StackUsingLinkedList(int capacity) {
		mTop = -1;
		mSize = capacity <= MAX_SIZE ? capacity : MAX_SIZE;
	}

	public boolean isEmpty() {
		return (mTop == -1) && (null == mHead);
	}

	public void push(Node node) {
		if (mTop == mSize - 1) {
			throw new RuntimeException("Stack Overflow");
		} else {
			if (null == mHead) {
				mHead = node;
			} else {
				node.next = mHead;
				mHead = node;
			}
			mTop++;
		}
	}

	public Node pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		} else {
			Node top = mHead;
			mHead = mHead.next;
			mTop--;
			return top;
		}
	}

	public Node peek() {
		if (mTop == mSize - 1) {
			throw new RuntimeException("Stack Overflow");
		} else {
			return mHead;
		}
	}

	public void print() {
		Node current = mHead;
		while (null != current) {
			System.out.println(current);
			current = current.next;
		}

		// OR
		/*
		 * for (int i = 0; i < mSize; i++) { if (null != current) {
		 * System.out.println(current); current = current.next; } }
		 */
	}

	public static void test() {
		Node node1 = new Node(10);
		Node node2 = new Node(2);
		Node node3 = new Node(-1);
		Node node4 = new Node(8);

		StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList(5);
		stackUsingLinkedList.push(node1);
		stackUsingLinkedList.push(node2);
		stackUsingLinkedList.push(node3);
		stackUsingLinkedList.push(node4);

		stackUsingLinkedList.print();

		Node popedNode = stackUsingLinkedList.pop();
		System.out.println("popedNode:" + popedNode);
		
		stackUsingLinkedList.print();
		
		Node peekNode = stackUsingLinkedList.peek();
		System.out.println("peekNode:" + peekNode);
	}

}