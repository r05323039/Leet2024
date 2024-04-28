package ian.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeLevelOrderTraversal102 extends TreeNode {
    public BinaryTreeLevelOrderTraversal102(int val, TreeNode left, TreeNode right) {
        super(val, left, right);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> container = new ArrayList<>();
        addByLevel(root, 0, container);
        return container;
    }

    private static void addByLevel(TreeNode node, int level, List<List<Integer>> container) {
        if (container.size() == level) {
            List<Integer> subContainer = new ArrayList<>();
            subContainer.add(node.val);
            container.add(subContainer);
        } else {
            container.get(level).add(node.val);
        }
        level++;
        if (node.left != null) {
            addByLevel(node.left, level, container);
        }
        if (node.right != null) {
            addByLevel(node.right, level, container);
        }
    }

    private static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size1 = 1;

        while (size1 != 0) {
            List<Integer> subContainer = new ArrayList<>();
            container.add(subContainer);

            int size2 = 0;
            for (int i = 0; i < size1; i++) {
                TreeNode polled = queue.poll();
                subContainer.add(polled.val);

                if (polled.left != null) {
                    queue.offer(polled.left);
                    size2++;
                }

                if (polled.right != null) {
                    queue.offer(polled.right);
                    size2++;
                }
            }
            size1 = size2;
        }
        return container;
    }

    public static void main(String[] args) {
        TreeNode root = defaultTree();
        printNode(root);
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(2, 3),
                List.of(4, 5, 6, 7)
        );


        assertEquals(expected, levelOrder(root));
        assertEquals(expected, levelOrder2(root));
    }
}
