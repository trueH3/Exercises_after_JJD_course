package com.mycompany.ex1;

/**
 *
 * @author szymon
 * @param <T>
 */
public class QueueImpl<T> implements Queue<T> {

    private Node<T> wholeQueue;
    private int sizeOfQueue;

    public QueueImpl() {
        this.wholeQueue = new Node<>();
        this.sizeOfQueue = 0;
    }

    @Override
    public void enqueue(T o) {
        if (sizeOfQueue == 0) {
            wholeQueue.setNodeVal(o);
        } else {
            Node<T> finalNode = getLastNode(wholeQueue);
            finalNode.setNode(new Node<>(o));
        }
        this.sizeOfQueue++;
    }

    @Override
    public T dequeue() {
        T removedElement = wholeQueue.getNodeVal();
        switch (sizeOfQueue) {
            case 0:
                throw new IllegalStateException("Queue is already empty");
            case 1:
                wholeQueue.setNodeVal(null);
                break;
            default:
                wholeQueue = wholeQueue.getNode();
        }
        this.sizeOfQueue--;
        return removedElement;
    }

    @Override
    public int size() {
        return this.sizeOfQueue;
    }

    private Node<T> getLastNode(Node<T> n) {
        while (n.getNode() != null) {
            n = getLastNode(n.getNode());
        }
        return n;
    }
}