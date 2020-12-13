package com.epam.rd.java.basic.practice6.part5;

import com.epam.rd.java.basic.practice6.Demo;

public class Tree<E extends Comparable<E>> {

	private Node<E> head;

	public boolean add(E element) {
		if (element == null) {
			return false;
		}
		if (this.head == null) {
			this.head = new Node<>(element);
			return true;
		}
		return add(element, this.head);
	}

	private boolean add(E element, Node<E> node) {
		if (element.compareTo(node.data) < 0) {
			if (node.left == null) {
				node.left = new Node<>(element);
				return true;
			} else {
				return add(element, node.left);
			}
		} else if (element.compareTo(node.data) > 0) {
			if (node.right == null) {
				node.right = new Node<>(element);
				return true;
			} else {
				return add(element, node.right);
			}
		} else {
			return false;
		}
	}

	public void add(E[] elements) {
		for (E element : elements) {
			add(element);
		}
	}

	public boolean remove(E data) {
		if (this.head == null)
			return false;
		if (data == null)
			return false;
		if(!contains(data)) {
			return false;
		}
		head = remove(head, data);
		return true;
	}

	private Node<E> remove(Node<E> root, E data) {
		if (root == null)
			return root;
		if (data.compareTo(root.data) < 0) {
			root.left = remove(root.left, data);
		} else if (data.compareTo(root.data) > 0) {
			root.right = remove(root.right, data);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.data = getInorderSuccessor(root.right);
			root.right = remove(root.right, root.data);
		}

		return root;
	}

	E getInorderSuccessor(Node<E> root) {
		E minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	public void print() {
		printNode("",this.head);
	}

	private void printNode(String indent, Node<E> node) {
		if (node.left != null)
			printNode(indent+"  ", node.left);
		Demo.println(indent+node.data);
		if (node.right != null)
			printNode(indent+"  ", node.right);
	}

	private boolean contains(E element) {
		return find(element, this.head);
	}
	
	private boolean find(E element, Node<E> node) {
		if(node.data!=null && node.data.compareTo(element)==0) {
			return true;
		}
		boolean result = false;
		if(node.left != null) {
			result = find(element, node.left);
		}
		if(node.right != null) {
			result = result || find(element, node.right);
		}
		return result;
	}
	
	private static final class Node<E> {
		E data;
		Node<E> left;
		Node<E> right;

		public Node(E element) {
			this.data = element;
		}
	}

}
