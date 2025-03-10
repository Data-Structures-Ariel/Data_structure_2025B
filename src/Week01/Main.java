package Week01;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Level-0
        binNode<Integer> root = new binNode<>(17);

        // Level-1
        root.setLeft(new binNode<>(36));
        root.setRight(new binNode<>(7));

        // Level-2
        root.getLeft().setLeft(new binNode<>(12));

        root.getRight().setLeft(new binNode<>(28));
        root.getRight().setRight(new binNode<>(0));

        // Level-3
        root.getLeft().getLeft().setLeft(new binNode<>(10));
        root.getLeft().getLeft().setRight(new binNode<>(42));

        root.getRight().getRight().setRight(new binNode<>(1));

        // Level-4
        root.getRight().getRight().getRight().setRight(new binNode<>(70));

        inOrder(root);
        count(root);

        preOrder(root);
    }
    private static void preOrder(binNode<Integer> root) {
        if(root==null)
            return;

        System.out.print(root.getValue()+" ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static void postOrder(binNode<Integer> root) {
        if(root==null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue()+" ");
    }

    //O(n)
    private static void inOrder(binNode<Integer> root) {
        if(root==null)
            return;

        inOrder(root.getLeft());
        System.out.print(root.getValue()+ " ");
        inOrder(root.getRight());

    }

    private static int count(binNode<Integer> root) {
        if(root==null)
            return 0;
        return count(root.getLeft())+1 +count(root.getRight()) ;
    }
}