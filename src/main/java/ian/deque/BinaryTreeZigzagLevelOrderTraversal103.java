package ian.deque;

import ian.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ian.TreeNode.defaultTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeZigzagLevelOrderTraversal103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        zigzag(root, 0, container);
        return container;
    }

    private void zigzag(TreeNode root, int row, List<List<Integer>> container) {
        if (root == null) {
            return;
        }
        if (row == container.size()) {
            List<Integer> subContainer = new ArrayList<>();
            container.add(subContainer);
        }
        List<Integer> subContainer = container.get(row);
        if (row % 2 == 0) {
            subContainer.add(root.val);
        } else {
            subContainer.add(0, root.val);
        }

        if (root.left != null) {
            zigzag(root.left, row + 1, container);
        }

        if (root.right != null) {
            zigzag(root.right, row + 1, container);
        }
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> container = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size1 = 1;
        boolean odd = true;
        while (size1 != 0) {
            LinkedList<Integer> subContainer = new LinkedList<>();
            container.add(subContainer);

            int size2 = 0;
            for (int i = 0; i < size1; i++) {
                TreeNode polled = queue.poll();

                if (odd) {
                    subContainer.offer(polled.val);
                } else {
                    subContainer.offerFirst(polled.val);
                }

                if (polled.left != null) {
                    queue.offer(polled.left);
                    size2++;
                }

                if (polled.right != null) {
                    queue.offer(polled.right);
                    size2++;
                }
            }
            odd = !odd;
            size1 = size2;
        }
        return container;
    }

    public static void main(String[] args) {
        TreeNode root = defaultTree();
        BinaryTreeZigzagLevelOrderTraversal103 instance = new BinaryTreeZigzagLevelOrderTraversal103();
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(3, 2),
                List.of(4, 5, 6, 7));
        assertEquals(expected, instance.zigzagLevelOrder(root));
        assertEquals(expected, instance.zigzagLevelOrder2(root));
    }
}
