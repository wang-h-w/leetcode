class Construct {
	static class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;
		
		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}
		
		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}
		
		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}
	
	private int[][] grid;
	
	public Node construct(int[][] grid) {
		this.grid = grid;
		return constructNode(0, grid.length - 1, 0, grid.length - 1);
	}
	
	private Node constructNode(int i1, int i2, int j1, int j2) {
		for (int i = i1; i <= i2; i++) {
			for (int j = j1; j <= j2; j++) {
				if (grid[i][j] != grid[i1][j1]) {
					Node root = new Node();
					root.topLeft = constructNode(i1, i1 + (i2 - i1) / 2, j1, j1 + (j2 - j1) / 2);
					root.topRight = constructNode(i1, i1 + (i2 - i1) / 2, j1 + (j2 - j1) / 2 + 1, j2);
					root.bottomLeft = constructNode(i1 + (i2 - i1) / 2 + 1, i2, j1, j1 + (j2 - j1) / 2);
					root.bottomRight = constructNode(i1 + (i2 - i1) / 2 + 1, i2, j1 + (j2 - j1) / 2 + 1, j2);
					return root;
				}
			}
		}
		return new Node(grid[i1][j1] == 1 ? true : false, true);
	}
}