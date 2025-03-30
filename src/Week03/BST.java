package Week03;
import Week02.BinNode;

public class BST<E extends Comparable<E>> {

    private BinNode<E> root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public void insert(E value) {
        size++;
        if (root == null) {
            root = new BinNode<>(value);
            return;
        }
        insert(root, value);
    }

    private void insert(BinNode<E> r, E value) {

        if (r == null)
            return;

        if (root.getValue().compareTo(value) >= 0) {
            insert(root.getLeft(), value);
            root.setLeft(root.hasLeft() ? root.getLeft() : new BinNode<>(value));
        }else {
            insert(root.getRight(), value);
            root.setRight(root.hasRight() ? root.getRight() : new BinNode<>(value));
        }

    }

    public boolean isEmpty() {
        return root == null;
    }


}
