package Week02;

import Week01.binNode;

import java.util.Arrays;
import java.util.Random;

public class Main {

    static Random rd = new Random();

    public static void main(String[] args) {
        BinNode<Integer>
                root = new BinNode<>(70);
        root.setLeft(new BinNode<>(10));
        root.setRight(new BinNode<>(51));

        root.getLeft().setLeft(new BinNode<>(1));
        root.getLeft().setRight(new BinNode<>(7));


        root.getRight().setRight(new BinNode<>(212));

        root.getRight().getRight().setLeft(new BinNode<>(22));
        root.getRight().getRight().setRight(new BinNode<>(17));

        inOrder(root);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            add(root, rd.nextInt(10, 66));
            inOrder(root);
            System.out.println();
        }

        BinNode<Integer> rootBuild = null;


        for (int i = 0; i < 10; i++) {
            rootBuild = build(rootBuild);
            inOrder(rootBuild);
            System.out.println();
        }

        BinNode<Integer> rootBuildBinarySearch = null;

        for (int i = 0; i < 10; i++) {
            rootBuildBinarySearch = buildBinarySearch(rootBuildBinarySearch, rd.nextInt(10, 60));
            inOrder(rootBuildBinarySearch);
            System.out.println();
        }


        System.out.println("InOrder");
        inOrder(rootBuild);
        System.out.println("\nPreOrder");
        preOrder(rootBuild);


        int[] in = {60, 58, 2, 91, 34, 29, 22, 0, 10, 66};
        int[] pre = {29, 58, 60, 91, 2, 34, 0, 22, 10, 66};

        BinNode<Integer> tree = build(in, pre);

        System.out.println("\ntree");
        inOrder(tree);


    }

    // in = {60, 58, 2, 91, 34, 29, 22, 0, 10, 66};
    // pre = {29, 58, 60, 91, 2, 34, 0, 22, 10, 66};
    private static BinNode<Integer> build(int[] in, int[] pre) {

        if (in == null || pre == null || in.length != pre.length || in.length == 0)
            return null;

        int parent = pre[0];

        if (pre.length == 1)
            return new BinNode<>(pre[0]);

        BinNode<Integer> root = new BinNode<>(pre[0]);


        int i;
        for (i = 0; i < in.length; i++) {
            if (parent == in[i])
                break;
        }

        int[] in_left = Arrays.copyOfRange(in, 0, i);
        int[] in_right = Arrays.copyOfRange(in, i + 1, in.length);

        int[] pre_left = Arrays.copyOfRange(pre, 1, i + 1);
        int[] pre_right = Arrays.copyOfRange(pre, i + 1, pre.length);

        root.setLeft(build(in_left, pre_left));
        root.setRight(build(in_right, pre_right));


        return root;
    }

    private static BinNode<Integer> build(BinNode<Integer> root) {

        if (root == null)
            return new BinNode<>(rd.nextInt(100));
        boolean coin = rd.nextBoolean();
        if (coin)
            root.setRight(build(root.getRight()));
        else
            root.setLeft(build(root.getLeft()));

        return root;
    }

    private static BinNode<Integer> buildBinarySearch(BinNode<Integer> root, int value) {

        if (root == null)
            return new BinNode<>(value);

        if (value >= root.getValue())
            root.setRight(buildBinarySearch(root.getRight(), value));
        else
            root.setLeft(buildBinarySearch(root.getLeft(), value));

        return root;
    }

    private static void add(BinNode<Integer> root, int value) {

        if (root == null)
            return;

        boolean coin = rd.nextBoolean();

        if (coin) {
            if (root.hasRight())
                add(root.getRight(), value);
            else
                root.setRight(new BinNode<>(value));
        } else {
            if (root.hasLeft())
                add(root.getLeft(), value);
            else
                root.setLeft(new BinNode<>(value));
        }


    }

    private static void inOrder(BinNode<Integer> root) {
        if (root == null)
            return;

        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());

    }

    private static void preOrder(BinNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
}
