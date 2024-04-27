package ian.queue;

import java.util.List;

public class BinaryTreeLevelOrderTraversal102 extends TreeNode {
    public BinaryTreeLevelOrderTraversal102(int val, TreeNode left, TreeNode right) {
        super(val, left, right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(root.val);

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = defaultTree();
        LinkedListQueue<TreeNode> qeueu = new LinkedListQueue<>(10);
        qeueu.offer(root);

        while (!qeueu.isEmpty()) {
            TreeNode polled = qeueu.poll();

            System.out.println(polled.val);

            if (polled.left != null)
                qeueu.offer(polled.left);
            if (polled.right != null)
                qeueu.offer(polled.right);
        }
    }
}
