/**
 * @author Seagull_gby
 * @date 2019/11/11 14:32
 * Description: 剑指Offer-面试题22-Java实现
 *
 * 问题描述：
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 实现思路：
 * 设置一个指针来遍历链表，同时设置一个指针指向“遍历指针”的第前k个节点。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

public class Solution {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输出倒数的节点
     * @param head 链表头节点
     * @param k 倒数第k个
     * @return 结果链表
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        /* 遍历指针 */
        ListNode nList = head;
        /* 遍历指针前k个节点的指针 */
        ListNode pList = head;

        /* 保证k为合理参数 */
        if(k <= 0) {
            throw new IllegalArgumentException("请输入大于0的整数k。");
        }

        /* 链表长度 */
        int length = 0;
        /* 遍历指针移动次数 */
        int count = 0;
        while(nList != null) {
            nList = nList.next;
            length ++;
            /* 在遍历指针移动了k次时，同步移动遍历指针前k个节点的指针 */
            if(count != k) {
                count ++;
            } else {
                pList = pList.next;
            }
        }

        if(length < k) {
            return null;
        } else {
            return pList;
        }

    }
}
