package method.complex;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:28
 * Description: 剑指Offer-面试题25-Java实现
 *
 * 问题描述：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 实现思路：
 * 构建一条新链表，用原来两链表指针遍历两链表，发现小的节点就加在新链表上，直到一个链表遍历完毕，把另一个链表剩余节点直接加在新链表上。
 *
 * 本实现因不断构建新节点影响性能，另一包内有直接用双链表实现和递归实现
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&tPage=1
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
     * 合并链表
     * @param list1 链表A
     * @param list2 链表B
     * @return 合并后的新链表
     */
    public ListNode Merge(ListNode list1,ListNode list2) {

        /* 判断链表其中一个为null的情况 */
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        /* 最终链表指针 */
        ListNode finalList = null;

        /* 最终链表头指针 */
        ListNode headNode = null;
        /* 先构造最终链表的头结点 */
        if(list1.val >= list2.val) {
            finalList = finalList = new ListNode(list2.val);
            list2 = list2.next;
        } else {
            finalList = finalList = new ListNode(list1.val);
            list1 = list1.next;
        }
        headNode = finalList;

        /* 遍历两个链表 */
        while(list1!=null && list2!=null) {
            /* 比较两链表数据大小，将小的一方的值加入最终链表新建节点中 */
            if(list1.val >= list2.val) {
                finalList.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                finalList.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            finalList = finalList.next;
        }
        /* 一方为空后，直接将另外一个链表的剩余节点加到最终链表上 */
        if(list1 == null) {
            finalList.next = list2;
        } else {
            finalList.next = list1;
        }

        return headNode;

    }
}

