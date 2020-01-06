

private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
    if (inStart > inEnd || postEnd < 0) return null;
    int value = postorder[postEnd];
    int p = 0;
    for (int i = inStart; i <= inEnd; ++i) {
        if (inorder[i] == value) {
            p = i;
            break;
        }
    }
    TreeNode node = new TreeNode(value);
    node.left = helper(inorder, postorder, inStart, p - 1, p - 1 + postEnd - inEnd);
    node.right = helper(inorder, postorder, p + 1, inEnd, postEnd - 1);
    return node;
}


public TreeNode buildTree(int[] inorder, int[] postorder) {
    return helper(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
}