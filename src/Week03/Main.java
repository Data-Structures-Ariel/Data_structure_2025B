package Week03;

import Week02.BinNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

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
        int ans = getHeight(root);
        System.out.println("Height -> " + ans);

        levelOrder(root);

        boolean bool = areEqual(root);
        int L = 2;
        bool = isOddValueFromLevelL(root, L);

    }

    private static boolean isOddValueFromLevelL(BinNode<Integer> root, int l, int level) {

        if (root == null)
            return true;

        if (level >= l) {
            if (root.getValue() % 2 == 0)
                return false;
        }

        return isOddValueFromLevelL(root.getLeft(), l, level + 1) && isOddValueFromLevelL(root.getRight(), l, level + 1)

    }

    public static boolean isOddValueFromLevelL(BinNode<Integer> root, int l) {
        return isOddValueFromLevelL(root,l,0);
    }


    private static boolean areEqual(BinNode<Integer> root) {

        if (root == null)
            return true;

        if (root.hasLeft() && root.hasRight())
            if (!root.getLeft().getValue().equals(root.getRight().getValue()))
                return false;

        return areEqual(root.getLeft()) && areEqual(root.getRight());

    }

    private static void levelOrder(BinNode<Integer> root) {

        if (root == null)
            return;
        Queue<BinNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinNode<Integer> node = q.poll();
            if (node.hasLeft())
                q.add(node.getLeft());
            if (node.hasRight())
                q.add(node.getRight());
            System.out.print(node.getValue() + " ");
        }

    }

    private static int getHeight(BinNode<Integer> root) {

        if (root == null) return -1;

        int rightHeight = getHeight(root.getRight());
        int leftHeight = getHeight(root.getLeft());
        return Math.max(rightHeight, leftHeight) + 1;
    }
}
