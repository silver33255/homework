package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>> {
	private static Node head;

	public boolean add(E element) {
		if (head == null) {
			head = new Node<E>(element);
			return true;
		}
		Node<E> buffer = head;
		while (true) {
			switch (buffer.getElement().compareTo(element)) {
				case 0 :
					return false;
				case -1 :
					if (buffer.getRightNode() == null) {
						buffer.setRightNode(new Node<>(element));
						return true;
					}
				case 1 :
					if (buffer.getLeftNode() == null) {
						buffer.setLeftNode(new Node<>(element));
						return true;
					}
			}
		}
	}

	public void add(E[] elements) {

	}

	public boolean remove(E element) {
		return false;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(head.getElement());
		sb.append(head.getRightNode());
		System.out.println(sb.toString());
	}

	private static final class Node<E> {
		private E element;
		private Node<E> leftSide;
		private Node<E> rightSide;

		public Node(E element) {
			this.element = element;
			this.leftSide = null;
			this.rightSide = null;
		}

		public E getElement() {
			return this.element;
		}

		public Node<E> getLeftNode() {
			return this.leftSide;
		}

		public Node<E> getRightNode() {
			return this.rightSide;
		}
		
		public void setLeftNode(Node<E> leftSide) {
			this.leftSide = leftSide;
		}

		public void setRightNode(Node<E> rightSide) {
			this.rightSide = rightSide;
		}
	}

}
