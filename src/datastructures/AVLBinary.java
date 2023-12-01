class Main {
  public static void main(String[] args) {
    // Uncomment the following two lines if you want to read from a file
    In.open("public/small.in");
    Out.compareTo("public/small.out");

    BinaryTree T = new BinaryTree();

    int m = In.readInt(); // number of operations
    for (int i = 0; i < m; i++) {
      char operation = In.readChar();
      if (operation == 'I') {
        int key = In.readInt();
        int value = In.readInt();
        T.insert(key, value);
      } else {
        int x = In.readInt();
        Out.println(T.query(x));
      }
    }

    // Uncomment the following line if you want to read from a file
    In.close();
  }
}

class TreeNode {
    public int key;
    public int value;
    public int maxValue;  // New variable to store the maximum value in the subtree rooted at this node
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public boolean moveLeft;
    public boolean moveRight;

    TreeNode(int key, int value, int maxValue) {
        this.key = key;
        this.value = value;
        this.maxValue = maxValue;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.moveLeft = false;
        this.moveRight = false;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        this.root = null;
    }

    public void insert(int key, int value) {
        if (root == null) {
            root = new TreeNode(key, value, value);
        } else {
            insert(root, key, value);
        }
    }

    public void insert(TreeNode node, int key, int value) {
        int maxValue;
        if (node.parent != null) {
            maxValue = Math.max(value, node.parent.maxValue);
        } else {
            maxValue = Math.max(value, node.maxValue);
        }

        if (key < node.key) { // insert in the left subtree
            if (node.left != null) {
                insert(node.left, key, value);
            } else {
                node.left = new TreeNode(key, value, maxValue);
                node.left.parent = node;
            }
        } else { // insert in the right subtree
            if (node.right != null) {
                insert(node.right, key, value);
            } else {
                node.right = new TreeNode(key, value, maxValue);
                node.right.parent = node;
            }
        }

        if (node.right != null && node.left != null) {
            if (node.right.maxValue >= node.left.maxValue) {
                node.moveRight = true;
                node.moveLeft = false;
            } else {
                node.moveRight = false;
                node.moveLeft = true;
            }
        }
    }

    public int query(int x) {
        if (root == null) {
            return 0;
        }

        TreeNode wishMeLuck = findNodeWithClosestToX(root, x);

        if (wishMeLuck == null) {
            return 0;
        }
        return parents(wishMeLuck, x);
    }

    public TreeNode findNodeWithClosestToX(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.key <= x) {
            if (node.right == null || node.right.key > x) {
                return node;
            }

            return findNodeWithClosestToX(node.right, x);
        }

        return findNodeWithClosestToX(node.left, x);
    }

    public int parents(TreeNode node, int x) {
        int max = findIt(node, x);
        int newMax = 0;

        node = node.parent;
        while (node != null && node.key <= x) {
            newMax = findIt(node, x);
            max = Math.max(max, newMax);
            node = node.parent;
        }

        return max;
    }

    public int findIt(TreeNode node, int x) {
        if (node.moveLeft) {
            return findIt(node.left, x);
        } else if (node.moveRight) {
            return findIt(node.right, x);
        } else {
            return node.maxValue;
        }
    }
}
