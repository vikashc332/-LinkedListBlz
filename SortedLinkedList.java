
public class SortedLinkedList<K extends Comparable<K>>{

    INode<K> head;
    INode<K> tail;
    int positionOfLastNode;

    public SortedLinkedList() {
        head = null;
        tail = null;
        positionOfLastNode = -1;
    }


    public void add(INode<K> newNode) {
        K newNodeKey = newNode.getKey();
        if(head == null) {
            head = newNode;
            tail = head;
        }
        else if(head.getKey().compareTo(newNodeKey)>0) {
            newNode.setNext(head);
            head = newNode;
        }
        else if(tail.getKey().compareTo(newNodeKey)<0) {
            tail.setNext(newNode);
            tail = newNode;
        }
        else {
            INode<K> temporaryPrevious = head;
            INode<K> temporaryCurrent = head.getNext();

            while((temporaryCurrent != tail) && (temporaryCurrent.getKey().compareTo(newNodeKey)<0)) {
                temporaryPrevious = temporaryCurrent;
                temporaryCurrent = temporaryCurrent.getNext();
            }
            temporaryPrevious.setNext(newNode);
            newNode.setNext(temporaryCurrent);

        }
        positionOfLastNode++;
    }


    public void remove(K key) {
        INode<K> temporaryCurrent = head;
        INode<K> tempPrevious = null;
        while(!temporaryCurrent.getKey().equals(key)) {
            tempPrevious = temporaryCurrent;
            temporaryCurrent = temporaryCurrent.getNext();
        }
        if(temporaryCurrent == head) {
            head = head.getNext();
        }
        else {
            tempPrevious.setNext(temporaryCurrent.getNext());
        }

        if(temporaryCurrent == tail) {
            tail = tempPrevious;
        }
        positionOfLastNode--;
    }


    public int index(K key) {
        if(positionOfLastNode == -1) {
            return -1;
        }
        INode<K> temporaryNode = head;
        int temporaryPosition = 0;
        while(!temporaryNode.getKey().equals(key)) {
            if(temporaryNode == tail) {
                return -1;
            }
            temporaryNode = temporaryNode.getNext();
            temporaryPosition++;
        }
        return temporaryPosition;
    }


    public boolean search(K key) {
        return index(key) == -1?false:true;
    }


    public boolean isEmpty() {
        return positionOfLastNode==-1?true:false;
    }


    public int size() {
        return positionOfLastNode+1;
    }


    public K pop(int position) {
        INode<K> temporaryCurrent = head;
        INode<K> temporaryPrevious = null;
        int temporaryPosition = 0;
        positionOfLastNode--;

        while(temporaryPosition != position) {
            temporaryPrevious = temporaryCurrent;
            temporaryCurrent = temporaryCurrent.getNext();
            temporaryPosition++;
        }

        if(temporaryCurrent == head) {
            head = head.getNext();
            return temporaryCurrent.getKey();
        }
        else if(temporaryCurrent == tail) {
            tail = temporaryPrevious;
            temporaryPrevious.setNext(temporaryCurrent.getNext());
            return temporaryCurrent.getKey();
        }
        else {
            temporaryPrevious.setNext(temporaryCurrent.getNext());
            return temporaryCurrent.getKey();
        }
    }


    public K pop() {
        return pop(positionOfLastNode);
    }


    public void printSortedLinkedList() {
        System.out.println("My Nodes: " + head);
    }
}
