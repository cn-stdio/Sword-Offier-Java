package method.easy;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:30
 * Description: 剑指Offer-面试题25-Java实现
 *
 * 问题描述：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 实现思路：
 * 构建一个过程指针，从头节点较小的一方开始遍历，比较过程指针的下一个节点与另一链表指针指向的节点的值
 * 过程指针指向的节点值小的话则不动让过程指针指向下一节点继续比较，否则改变过程指针节点的next域指向另一链表指针节点，并切换过程指针到另一链表
 * 过程指针所在链表用标志位flag判断（即判断另一链表是A还是B）
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

        /* 最终链表的头结点指针 */
        ListNode finalList = null;

        /* 标志位，标志“过程指针”到了哪个链表，1代表在链表A，2代表在链表B */
        int flag = 1;
        /* 先把最终链表头结点指向两者中头结点值较小的一方 */
        if(list1.val >= list2.val) {
            finalList = list2;
            flag = 2;
        } else {
            finalList = list1;
        }

        /* 两链表过程指针 */
        ListNode pList = finalList;
        /* 循环直到过程指针指向某一链表最后一个节点 */
        while (pList.next != null) {
            /* 当过程指针指向A链表时，如果指针下一个节点值比B链表指针小，则过渡到下一个节点，否则切换过程指针所在链表，并将两链表指针后移 */
            if(flag == 1) {
                if(pList.next.val < list2.val) {
                    pList = pList.next;
                } else {
                    list1 = pList.next;
                    pList.next = list2;
                    pList = list2;
                    flag = 2;
                }
            } else {
                if(pList.next.val < list1.val) {
                    pList = pList.next;
                } else {
                    list2 = pList.next;
                    pList.next = list1;
                    pList = list1;
                    flag = 1;
                }
            }
        }

        /* 将另一链表的剩余节点加在末尾 */
        if(flag == 1) {
            pList.next = list2;
        } else {
            pList.next = list1;
        }

        return finalList;
    }
}
