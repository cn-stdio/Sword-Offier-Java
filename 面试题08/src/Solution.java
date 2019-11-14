/**
 * @author Seagull_gby
 * @date 2019/11/13 18:45
 * Description: 剑指Offer-面试题08-Java实现
 *
 * 问题描述：
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 实现思路：
 * 首先分该节点有无右子树来讨论。
 * 1. 若节点有右子树，则如果其右孩子不存在左子树，其右孩子就是要找的节点，而其右孩子存在左子树，就沿着其右孩子的左指针一路遍历下去，叶子节点就是我们要找的节点。
 * 2. 若节点无右子树，这种情况就比较复杂。
 * 2.1 首先要分是不是根节点，是根节点又没右子树直接返回null即可。
 * 2.2 如果不是根节点的话，那还要看其本身是父节点的左孩子还是右孩子。
 * 2.2.1 如果本身是父节点的左孩子，那直接返回父节点。
 * 2.2.2 如果本身是父节点的右孩子，就沿着父节点遍历，直到找到一个节点，使得该节点是其父节点的左孩子，返回该节点的父节点即可。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 找出中序遍历指定节点的下一个节点
     * @param pNode 指定节点
     * @return 指定节点的下一个节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        /* 判断是否传入的是空二叉树 */
        if(pNode == null) {
            return null;
        }

        /* 判断该节点是否有右子树 */
        if(pNode.right == null) {
            /* 判断是否为根节点 */
            if(pNode.next == null) {
                return null;
            } else {
                /* 判断该节点位于父级节点的左子树还是右子树 */
                if(pNode.next.left == pNode) {
                    return pNode.next;
                } else {
                    /* 根据左根右原则，遍历其父节点，直到找到为父节点左孩子的节点，返回该节点的父节点 */
                    while(pNode.next.next!=null && pNode.next!=pNode.next.next.left) {
                        pNode = pNode.next;
                    }

                    /* 这里不用判空，因为上述如果没有找到合乎条件的节点，pNode.next.next为null退出循环，自然返回null */
                    return pNode.next.next;
                }
            }
        } else {
            /* 若没有左子树则不进入循环，直接返回原节点的右孩子 */
            pNode = pNode.right;
            /* 有左子树，则沿着左孩子遍历下去，直到叶子节点就是下一个值 */
            while(pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
    }
}
