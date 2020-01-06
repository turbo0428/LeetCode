time complexity: O(n)
space complexity: O(n)


private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    int value = preorder[preStart];
    int p = 0;
    for(int i = inStart; i <= inEnd; ++i) {
        if (inorder[i] == value) {
            p = i;
            break;
        }
    }
    
    TreeNode node = new TreeNode(value);
    node.left = helper(preorder, inorder, preStart + 1, inStart, p - 1);
    node.right = helper(preorder, inorder, p + 1 + preStart - inStart, p + 1, inEnd);
    return node;
}


public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(preorder, inorder, 0, 0, inorder.length - 1);
}