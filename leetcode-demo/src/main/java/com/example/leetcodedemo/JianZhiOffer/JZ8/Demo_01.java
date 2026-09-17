package com.example.leetcodedemo.JianZhiOffer.JZ8;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Demo_01 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //  根据描点法、欧拉路径进行寻找  中序遍历为 绕树一周  经过两次的节点
        //  如果有右子树  那么就按照右子树的左分支进行寻找  找到第一个左分支为null的点就是中序遍历的下一个节点
        // 如果没有右子树，那么它的下一个节点是  顺着next指针，找到第一个用了 让它变成左子树的节点，如果next指针为null ，那就返回null
        if (pNode.right != null) {
            return getByRightTree(pNode.right);
        } else {
            return getByParentTree(pNode);
        }
    }

    private TreeLinkNode getByRightTree(TreeLinkNode pNode) {
        //  终止条件是第一个左分支为null的点
        if (pNode.left == null) {
            return pNode;
        }
        //  否则就继续取左分支的下一个点
        pNode = pNode.left;
        return getByRightTree(pNode);
    }

    private TreeLinkNode getByParentTree(TreeLinkNode pNode) {
        //  终止条件是  它变成左子树的节点
        TreeLinkNode parentNode = pNode.next;
        if(parentNode == null){return null;}
        if (parentNode.left == pNode) {
            return parentNode;
        }
        //  否则  就进行下一层
        return getByParentTree(parentNode);
    }
}
