package Week03;

import Week02.BinNode;

import java.util.Random;

public class BTree<E> {

    private BinNode<E> root;
    private int size;

    public BTree() {
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

        boolean coin = new Random().nextBoolean();

        if (coin) {
            if (r.hasRight())
                insert(r.getRight(), value);
            else
                r.setRight(new BinNode<>(value));
        } else {
            if (root.hasLeft())
                insert(root.getLeft(), value);
            else
                root.setLeft(new BinNode<>(value));
        }

    }

    public boolean isEmpty() {
        return root == null;
    }

}
