package com.mycompany.ex2;

/**
 *
 * @author szymon
 */
public class StackImpl<T> implements Stack<T> {

    private Node<T> fullStack;
    private int size;

    public StackImpl() {
        this.fullStack = new Node<>();
        this.size = 0;
    }

    @Override
    public void push(T o) {
        if (size == 0) {
            fullStack.setNodeVal(o);
        } else {
            Node<T> nodeOnTop = getLastNode(fullStack);
            nodeOnTop.setNode(new Node<>(o));
        }
        size++;
    }

    @Override
    public T pop() {
        T removedElement = getLastNode(fullStack).getNodeVal();
        switch (size) {
            case 0:
                throw new IllegalStateException("The stack is already empty");
            case 1:
                fullStack.setNodeVal(null);
                break;
            default:
                Node<T> penultimateNode = getPenultimateNode(fullStack);
                penultimateNode.setNode(null);
        }
        size--;
        return removedElement;
    }

    @Override
    public T peek() {
        if (fullStack.getNodeVal() == null) {
            throw new IllegalStateException("The stack is epmpty");
        }
        return getLastNode(fullStack).getNodeVal();
    }

    private Node<T> getLastNode(Node<T> n) {
        while (n.getNode() != null) {
            n = getLastNode(n.getNode());
        }
        return n;
    }

    private Node<T> getPenultimateNode(Node<T> n) {
        while (n.getNode() != null && n.getNode().getNode() != null) {
            n = getPenultimateNode(n.getNode());
        }
        return n;
    }
}
