package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>>{
    private Node<E> head = null;

    public boolean add(E element) {
        if (head == null) {
            head = new Node<>(element);
            return true;
        }
        return add(head, element);
    }

    public void add(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    private boolean add(Node<E> node, E value) {
        if (value.compareTo(node.content) == 0) {
            return false;
        }
        if (value.compareTo(node.content) < 0) {
            if (node.leftSubtree == null) {
                node.leftSubtree = new Node<>(value);
                return true;
            } else {
                return add(node.leftSubtree, value);
            }
        } else {
            if (node.rightSubtree == null) {
                node.rightSubtree = new Node<>(value);
                return true;
            } else {
                return add(node.rightSubtree, value);
            }
        }
    }

    public boolean remove(E element) {
        if (contains(element)) {
            remove(head, element);
            return true;
        }
        return false;
    }

    private Node<E> remove(Node<E> node, E element) {
        if (node == null) return null;

        if (element.compareTo(node.content) < 0) {
            node.leftSubtree = remove(node.leftSubtree, element);
        } else if (element.compareTo(node.content) > 0) {
            node.rightSubtree = remove(node.rightSubtree, element);
        } else {
            // a desired element was found
            if (node.leftSubtree == null && node.rightSubtree == null) {
                // a node with no leaf nodes
                return null;
            } else if (node.leftSubtree == null) {
                // a node with one child node (no left node)
                return node.rightSubtree;
            } else if (node.rightSubtree == null) {
                // a node with one child node (no right node)
                return node.leftSubtree;
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                E minValue = getMinValue(node.rightSubtree);
                node.content = minValue;
                node.rightSubtree  = remove(node.rightSubtree, minValue);
            }
        }
        return node;
    }

    public boolean contains(E element) {
        Node<E> current = head;

        while (current != null) {
            int result = current.content.compareTo(element);

            if (result > 0) {
                current = current.leftSubtree;
            }
            else if (result < 0) {
                current = current.rightSubtree;
            } else {
                break;
            }
        }
        return current != null;
    }

    public E getMinValue(Node<E> node) {
        Node<E> leftSubtree = node;
        E minValue = null;

        while (leftSubtree != null) {
            minValue = leftSubtree.content;
            leftSubtree = leftSubtree.leftSubtree;
        }

        return minValue;
    }

    public void print() {
        print(head, "");
    }

    private void print(Node<E> node, String s) {
        if (node != null) {
            print(node.leftSubtree, s + "  ");
            System.out.println(s + node.content);
            print(node.rightSubtree, s + "  ");
        }
    }

    private static final class Node<E> {
        private Node<E> leftSubtree;
        private Node<E> rightSubtree;
        private E content;

        private Node(E content) {
            this.leftSubtree = null;
            this.rightSubtree = null;
            this.content = content;
        }
    }
}
