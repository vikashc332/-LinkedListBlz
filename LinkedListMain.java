
public class LinkedListMain {
    public static void main(String[] args) {
        System.out.println("----- Welcome to Data Structure: Linked List -----");
        MyNode<Integer> firstNode = new MyNode<Integer>(56);
        MyNode<Integer> secondNode = new MyNode<Integer>(30);
        MyNode<Integer> thirdNode = new MyNode<Integer>(70);
        MyNode<Integer> nodeToBeInserted = new MyNode<Integer>(40);
        int valueOfPreviousNode = 30;
        LinkList myLinkedList = new LinkList();
        myLinkedList.addNode(firstNode);
        myLinkedList.append(thirdNode);
        myLinkedList.insert(firstNode, secondNode);
        myLinkedList.insertWithKey(valueOfPreviousNode, nodeToBeInserted);
        INode deletedNode = myLinkedList.deleteNodeWithKey(40);
        System.out.println("The deleted key value is:"+deletedNode.getKey());
        myLinkedList.display();

    }
}
