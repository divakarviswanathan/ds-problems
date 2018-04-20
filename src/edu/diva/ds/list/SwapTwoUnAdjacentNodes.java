package edu.diva.ds.list;

public class SwapTwoUnAdjacentNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l5 = new ListNode();
		ListNode l4 = new ListNode();
		ListNode l3 = new ListNode();
		ListNode l2 = new ListNode();
		ListNode l1 = new ListNode();
		l1.data = 1;
		l1.next = l2;
		l2.data = 2;
		l2.next = l3;
		l3.data = 3;
		l3.next = l4;
		l4.data = 4;
		l4.next = l5;
		l5.data = 5;
		l5.next = null;
		
		ListNode head = l1;
		ListNode node = head, firstPrev = head, secondPrev = null, firstNode = null, secondNode = null;
		int key1 = 2, key2 = 4;
		while (node != null) {
			if (node.data == key1) {
				firstNode = node;
				break;
			}
			firstPrev = node;
			node = node.next;
		}
		while (node != null) {
			if (node.data == key2) {
				secondNode = node;
				break;
			}
			secondPrev = node;
			node = node.next;
		}
		ListNode temp = secondNode.next;
		firstPrev.next = secondNode;
		secondNode.next = firstNode.next;
		firstNode.next = temp;
		secondPrev.next = firstNode;
		 
	}

}

class ListNode {
	int data;
	ListNode next;
}