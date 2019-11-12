/**
 * @author Seagull_gby
 * @date 2019/11/11 14:25
 * Description: 剑指Offer-面试题24-Java实现
 *
 * 问题描述：
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 实现思路：
 * 用三个指针分别指向中间，前驱和后驱节点，每次都反转中间节点的next域，然后三个指针整体向后挪一个节点
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
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
     * 反转链表
     * @param head 链表头节点指针
     * @return 反转后的头节点指针
     */
    public ListNode ReverseList(ListNode head) {
        ListNode headNode = head;

        /* 如果头结点为null，返回头结点 */
        if(head == null) {
            return head;
        }

        /* 将节点数分别为1、2的情况挑出来，为3个及以上节点分别设置头结点及其前后节点 */
        if(head.next == null) {
            return head;
        } else if (head.next.next == null) {
            head = head.next;
            head.next = headNode;
            headNode.next = null;

            return head;
        } else {
            ListNode nextNode = head.next.next;
            head = head.next;
            ListNode prevNode = headNode;

            /* 每次反转前一个节点的next指向，然后3个指针后移 */
            while(nextNode.next != null) {
                head.next = prevNode;
                prevNode = head;
                head = nextNode;
                nextNode = nextNode.next;
            }

            /* 改变最后两个节点next的指向 */
            head.next = prevNode;
            nextNode.next = head;
            head = nextNode;
            headNode.next = null;

            return head;
        }
    }
}
