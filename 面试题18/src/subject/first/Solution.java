package subject.first;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:34
 * Description: 剑指Offer-面试题18-Java实现
 *
 * 问题描述：
 * 题目一：在O(1)时间内删除链表节点。
 *
 * 实现思路：
 * 把后一节点的值复制到要删除的节点上，再删除后一节点
 * 因为要求在O(1)时间删除节点，所以这里默认传入的节点一定在链表中
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
     * 删除节点
     * @param pHead 链表头结点指针
     * @param pToBeDeleted 链表要删除的节点
     */
    public void deleteNode(ListNode pHead, ListNode pToBeDeleted) {
        /* 传入空节点的话直接停止调用 */
        if(pHead==null  || pToBeDeleted==null) {
            return;
        }

        /* 在默认链表中存在要删除节点的情况下，链表中只有一个节点 */
        if(pHead.next == null) {
            /* 这里未做任何操作的原因是： Java是值传递，方法中传参只是拷贝的引用，不会影响到实际引用，而题目又要求返回void，故实际无法将唯一节点置null */
            return;
        }

        /* 该节点是尾结点 */
        if(pToBeDeleted.next == null) {
            while(pHead.next != pToBeDeleted) {
                pHead = pHead.next;
            }
            pHead.next = null;
            return;
        }

        /* 正常情况，将后者的值赋予前者，然后删除后者 */
        pToBeDeleted.val = pToBeDeleted.next.val;
        pToBeDeleted.next = pToBeDeleted.next.next;
    }

    /**
     * 打印链表
     * @param pHead 链表头节点的指针
     */
    private static void printList(ListNode pHead) {
        if(pHead == null) {
            System.out.println("null");
        }

        while(pHead.next != null) {
            System.out.print(pHead.val + "，");
            pHead = pHead.next;
        }
        System.out.println(pHead.val);
    }

    /**
     * 手动创建测试用例，考虑三种情况：
     * 1. 正常情况
     * 2. 删除头节点
     * 3. 删除尾节点
     */
    public static void main(String[] args) {
        ListNode pHead = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);

        pHead.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = null;

        Solution solution = new Solution();

        System.out.print("开始链表：");
        printList(pHead);

        System.out.print("删除其中一个节点后：");
        solution.deleteNode(pHead, firstNode);
        printList(pHead);

        System.out.print("删除头节点后：");
        solution.deleteNode(pHead, pHead);
        printList(pHead);

        System.out.print("删除尾节点后：");
        solution.deleteNode(pHead, thirdNode);
        printList(pHead);
    }
}
