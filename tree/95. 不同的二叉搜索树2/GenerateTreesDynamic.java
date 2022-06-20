import java.util.List;
import java.util.ArrayList;

class GenerateTreesDynamic {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<TreeNode> generateTrees(int n) {
	    List<TreeNode> pre = new ArrayList<TreeNode>();
	    if (n == 0) return pre;
	    pre.add(null);
	    // 每次增加一个数字
	    for (int i = 1; i <= n; i++) {
	        List<TreeNode> cur = new ArrayList<TreeNode>();
	        // 遍历之前的所有解
	        for (TreeNode root : pre) {
	            // 插入到根节点
	            TreeNode insert = new TreeNode(i);
	            insert.left = root;
	            cur.add(insert);
	            // 插入到右孩子，右孩子的右孩子...最多找 n 次孩子
	            for (int j = 0; j <= n; j++) {
	                TreeNode root_copy = treeCopy(root); // 复制当前的树
	                TreeNode right = root_copy; // 找到要插入右孩子的位置
	                int k = 0;
	                // 遍历 j 次找右孩子
	                for (; k < j; k++) {
	                    if (right == null) break;
	                    right = right.right;
	                }
	                // 到达 null 提前结束
	                if (right == null)
	                    break;
	                // 保存当前右孩子的位置的子树作为插入节点的左孩子
	                TreeNode rightTree = right.right;
	                insert = new TreeNode(i);
	                right.right = insert; // 右孩子是插入的节点
	                insert.left = rightTree; // 插入节点的左孩子更新为插入位置之前的子树
	                // 加入结果中
	                cur.add(root_copy);
	            }
	        }
	        pre = cur;
	    }
	    return pre;
	}


	private TreeNode treeCopy(TreeNode root) {
	    if (root == null) {
	        return root;
	    }
	    TreeNode newRoot = new TreeNode(root.val);
	    newRoot.left = treeCopy(root.left);
	    newRoot.right = treeCopy(root.right);
	    return newRoot;
	}

	private static void printHelper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return;
		if (root.left != null) System.out.print(root.left.val + " ");
		else System.out.print("#" + " ");
		if (root.right != null) System.out.print(root.right.val + " ");
		else System.out.print("#" + " ");
		printHelper(root.left);
		printHelper(root.right);
	}

	public static void main(String[] args) {
		GenerateTreesDynamic gt = new GenerateTreesDynamic();
		List<TreeNode> result = gt.generateTrees(3);
		for (TreeNode root: result) {
			if (root != null) System.out.print(root.val + " ");
			printHelper(root);
			System.out.println();
		}
	}
}