// BST Property: A value of a node is greater than all the nodes to it's left,
// and less than all the nodes to it's right. All child nodes are also BSTs
// Primary operations on BSTs: Insertion, Searching, Deletion

class Node {
  int data;
  Node(int d) {
    data = d;
    left = right = null;
  }
}

class BinarySearchTree {

  Index index = new Index();

  // A recursive function to construct Full from pre[]. preIndex is used
  // to keep track of index pre[].
  Node constructTreeUtil(int pre[], Index preIndex,
      int low, int high, int size) {

    if(preIndex.index >= size || low > high) {
      return null;
    }

    Node root = new Node(pre[preIndex.index]);
    preIndex.index = preIndex.index + 1;

    if (low == high) {
      return root;
    }

    int i;
    for (i = low; i <= high; ++i) {
      if (pre[i] > root.data) {
        break;
      }
    }

    // Use the index of element found in preorder traversal.
    // This function mainly uses constructTreeUtil()
    Node constructTree(int pre[], int size) {
      return constructTreeUtil(pre, index, 0, size - 1, size);
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node node) {
      if(node == null) {
        return;
      }
      printInorder(node.left);
      System.out.print(node.data + "");
      printInorder(node.right);
    }

    public static void main(String[], args) {
      BinaryTree tree = new BinaryTree();
      int pre[] = new int[]{10, 5, 1, 7, 40, 50};
      int size = pre.length;
      Node root = tree.constructTree(pre, size);
      System.out.println("Inorder traversal of the constructed tree is ");
      tree.printInorder(root);
    }
  }
}


