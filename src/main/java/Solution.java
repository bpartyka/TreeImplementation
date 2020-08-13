import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        int check = 90;

        do {
            TreeNode grandParent = root;
            if (check == 2) {
                check = 0;
            }
            if (root.val % 2 == 0) {
                if (root.left != null || root.right != null) {
                    if (!returnChild(root.left).isEmpty()) {
                        sum += root.val;
                    } else if (!returnChild(root.right).isEmpty()) {
                        sum += root.val;

                    }
                }
            }
            if (check != 1) {
                if (root.left != null) {
                    root = root.left;

                }
                check = 1;

            } else if (check == 1) {
                if (grandParent.right != null) {
                    root = grandParent.right;
                }
                check = 2;
            }
        } while (check == 0);


        return sum;

    }

    public List<TreeNode> returnChild(TreeNode x) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (x.left != null) {
            result.add(x.left);
        }

        if (x.right != null) {
            result.add(x.right);

        }
        return result;
    }

    public boolean haveChild(TreeNode x) {
        if (x.left != null || x.right != null) {
            return true;
        }
        return false;
    }
}