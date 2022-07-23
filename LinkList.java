
public class LinkList {
    public MyNode head;
    MyNode tail;
    int size;

    public void addNode(MyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void display() {
        INode current = head;
        if (head == null)
            System.out.println("Linked List is empty");
        System.out.println("Nodes Are");
        while (current != null) {
            if (current.getNext() != null) {
                System.out.print(current.getKey() + " -> ");
            } else {
                System.out.println(current.getKey());
            }
            current = current.getNext();
        }
    }

    public void append(MyNode newNode) {
        if (head == null) {
            head = newNode;
        }
        if (tail == null) {
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public MyNode deleteFirst() {
        MyNode temporaryNode = this.head;
        this.head = (MyNode) this.head.getNext();
        return temporaryNode;

    }

    public INode deleteLastNode() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = (MyNode) tempNode;
        return tail;
    }

    public void insertWithKey(int key, INode newNode) {

        INode nodeWithKeyValue = search(key);
        if(nodeWithKeyValue.getKey().equals(key)) {
            INode temporaryNode = nodeWithKeyValue.getNext();
            nodeWithKeyValue.setNext(newNode);
            newNode.setNext(temporaryNode);
        }
        else {
            System.out.println("Key Node Found");
        }

    }

    public MyNode search(int key) {
        INode temporaryNode = head;
        boolean isFound = false;
        while (temporaryNode != null  && isFound == false) {
            if(temporaryNode.getKey().equals(key)) {
                isFound = true;
            }
            else {

                temporaryNode = temporaryNode.getNext();
            }
        }
        if(isFound)
            return (MyNode) temporaryNode;
        else {
            return head;
        }
    }

    public INode deleteNodeWithKey(int key) {

        INode nodeWithKeyValue = search(key);

        if(nodeWithKeyValue != null) {

            INode temporaryNode = head;
            while (temporaryNode!=null && temporaryNode.getNext() != nodeWithKeyValue) {
                temporaryNode = temporaryNode.getNext();
            }
            temporaryNode.setNext(nodeWithKeyValue.getNext());
            return nodeWithKeyValue;

        }
        else {
            System.out.println("Key Node Found");
            return null;
        }
    }

    public int size() {
        int numberOfNode = 0;
        INode temporaryNode = this.head;
        while(temporaryNode!=null ) {

            temporaryNode = temporaryNode.getNext();
            numberOfNode++;
        }
        return numberOfNode;
    }

}
