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
//        if(wholeQueue.getNodeVal() == null){
//            wholeQueue = new Node<>(o);
//        }

        //else{
        Node<T> finalNode = getLastNode(wholeQueue);
        finalNode.setNode(new Node<>(o));
        this.sizeOfQueue++;
        //}

    }

    @Override
    public T dequeue() {
        if (wholeQueue.getNode() != null) {
            wholeQueue = wholeQueue.getNode();
            this.sizeOfQueue--;
            return wholeQueue.getNodeVal();
        }
        return null;
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
