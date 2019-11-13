/**
 * @author Seagull_gby
 * @date 2019/11/12 16:28
 * Description: 剑指Offer-面试题07-Java实现
 *
 * 问题描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 实现思路：
 * 将前序数组的每一个值当作根节点，从中序数组中找到对应的值。
 * 将每一个左（右）子树作为新的二叉树，用前序和中序的临界点作为“新数组”传入，递归构建左右子树。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 重建二叉树
     * @param pre 前序遍历结果
     * @param in 中序遍历结果
     * @return 结果二叉树
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        /* 得到前序和中序数组的初始临界 */
        int strPre = 0, endPre = pre.length-1;
        int strIn = 0, endIn = in.length-1;

        /* 构建根节点 */
        TreeNode root = reConstructBinaryTree(pre, strPre, endPre, in, strIn, endIn);
        return root;
    }

    /**
     * 重载“重建二叉树”方法，用数组的临界值控制数组遍历
     * @param pre 前序遍历结果
     * @param strPre 前序遍历数组初始值
     * @param endPre 前序遍历数组最后值
     * @param in 中序遍历结果
     * @param strIn 中序遍历数组初始值
     * @param endIn 中序遍历数组最后值
     * @return 结果二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int strPre, int endPre, int[] in, int strIn, int endIn) {

        /* 临界情况，假如左（右）子树没有值，返回null */
        if(strPre>endPre || strIn>endIn) {
            return null;
        }

        /* 首先构建根节点的值 */
        TreeNode root = new TreeNode(pre[strPre]);

        /* 遍历中序数组，找到前序数组的值 */
        for(int i=strIn; i<=endIn; i++) {
            if(in[i] == pre[strPre]) {
                root.left = reConstructBinaryTree(pre, strPre+1, strPre+i-strIn, in, strIn, i-1);
                root.right = reConstructBinaryTree(pre, strPre+i-strIn+1, endPre, in, i+1, endIn);
            }
        }

        return root;
    }
}
