package ian;

import lombok.AllArgsConstructor;

import java.util.LinkedList;

@AllArgsConstructor
public class TreeNode extends TestModel {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }


    public static TreeNode defaultTree() {
        return new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
    }

    protected static void printNode(TreeNode node) {
        if (node == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int size1 = 1;
        while (!queue.isEmpty()) {
            int size2 = 0;
            for (int i = 0; i < size1; i++) {
                TreeNode polled = queue.poll();
                System.out.print(polled.val + " ");

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
            System.out.println();
        }
    }
}
