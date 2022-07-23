public class MyNode <K> implements INode<K> {

    K key;
    INode next;

    public MyNode(K key) {
        this.key = key;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        key = key;
    }

    public INode getNext() {
        return next;
    }

    public void setNext(INode next) {
        this.next = next;
    }
}
