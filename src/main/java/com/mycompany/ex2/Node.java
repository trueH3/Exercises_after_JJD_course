package com.mycompany.ex2;

/**
 *
 * @author szymon
 * @param <T>
 */
public class Node<T> {

    private T nodeVal;
    private Node<T> node;

    public Node(T nodeVal, Node node) {
        this.nodeVal = nodeVal;
        this.node = node;
    }

    public Node(T nodeVal) {
        this.nodeVal = nodeVal;
    }

    public Node() {
        
    }

    public T getNodeVal() {
        return nodeVal;
    }

    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public void setNodeVal(T nodeVal) {
        this.nodeVal = nodeVal;
    }
}