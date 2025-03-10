package Week01;

public class binNode<E> {


    private E value;
    private binNode<E> left;
    private binNode<E> right;

    public binNode(E value) {
        this.value = value;
        this.left=null;
        this.right=null;
    }

    public binNode(E value, binNode<E> left, binNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public binNode<E> getLeft() {
        return left;
    }

    public void setLeft(binNode<E> left) {
        this.left = left;
    }

    public binNode<E> getRight() {
        return right;
    }

    public void setRight(binNode<E> right) {
        this.right = right;
    }


    public boolean hasLeft() {
        return left!=null;
    }

    public boolean hasRight() {
       return this.right !=null;
    }

    @Override
    public String toString() {
        return "binNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
