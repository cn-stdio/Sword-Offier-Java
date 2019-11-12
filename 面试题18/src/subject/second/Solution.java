package subject.second;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:34
 * Description: 剑指Offer-面试题18-Java实现
 * 问题描述：
 * 题目二：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *        例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 实现思路：
 * 构建一个新的头指针节点，此时“头节点值重复”的问题就转换为了一般问题。
 * 因为最后返回的是新的头节点的next域，所以不用考虑新的头节点的值是否与头节点的值相同的问题。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    /**
     * 链表节点内部类
     */
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除重复节点
     * @param pHead 链表头节点指针
     * @return 删除后的链表头节点指针
     */
    public ListNode deleteDuplication(ListNode pHead) {
        /* 传入空链表直接返回 */
        if(pHead == null) {
            return null;
        }

        /* 构建一个新的头节点 */
        ListNode headNode = new ListNode(-1);
        headNode.next = pHead;
        /* 遍历指针 */
        ListNode pList = pHead;
        ListNode prevList = headNode;
        /* 对该链表进行遍历，因为可能尾结点重复，此时删除尾结点后prevList.next会将null赋予pList，所以加入pList判空条件 */
        while(pList != null && pList.next != null) {
            if(pList.next.val == pList.val) {
                /* 遇到重复节点后，遍历到最后一个重复节点 */
                while(pList.next!=null && pList.next.val==pList.val) {
                    pList = pList.next;
                }
                prevList.next = pList.next;
                pList = prevList.next;
            } else {
                prevList = pList;
                pList = pList.next;
            }
        }

        return headNode.next;
    }
}
