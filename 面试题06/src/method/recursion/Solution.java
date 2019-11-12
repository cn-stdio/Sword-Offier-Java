package method.recursion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Seagull_gby
 * @date 2019/11/12 15:45
 * Description: 剑指Offer-面试题06-Java实现
 *
 * 问题描述：
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 要求： 不允许改变链表的结构（也就是你不能将链表反转再从头到尾输出）
 *
 * 实现思路：
 * 既然用栈可以很方便的实现，而递归本质又是栈结构，所以可以用递归实现。
 * 不断递归输出下一节点的值和本身的值。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 从尾到头打印链表
     * @param listNode 链表头指针
     * @return 从尾到头的值的集合
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /* 倒序链表值保存集合 */
        ArrayList<Integer> fList;

        /* 基准条件，递归到链表末尾返回一个空集合以添加值 */
        if(listNode == null) {
            return new ArrayList<>();
        }
        fList = printListFromTailToHead(listNode.next);
        fList.add(listNode.val);

        return fList;
    }
}
