package method.normal;

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
 * 倒序输出很容易想到的一点就是构造一个栈结构，典型的后进先出的结构，将链表中的值依次压入栈中，再从栈弹出到集合中。
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
        ArrayList<Integer> fList = new ArrayList<>();

        /* 构造一个空栈 */
        Stack<Integer> stack = new Stack<>();
        /* 将链表的值压入栈中 */
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        /* 将栈中的值推入集合中 */
        while(!stack.empty()) {
            fList.add(stack.pop());
        }

        return fList;
    }
}
