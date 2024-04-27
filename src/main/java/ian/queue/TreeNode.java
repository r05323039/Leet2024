package ian.queue;

import ian.TestModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TreeNode extends TestModel {
    int val;
    TreeNode left;
    TreeNode right;

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
}
