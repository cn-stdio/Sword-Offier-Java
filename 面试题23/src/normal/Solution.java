package normal;

/**
 * @author Seagull_gby
 * @date 2019/11/18 19:15
 * Description: 剑指Offer-面试题23-Java实现
 *
 * 问题描述：
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 实现思路：
 * 首先判断链表中是否有环：
 * 用两个指针，一个每次走两步，一个每次走一步，当他俩相遇的时候，链表有环，如果走的快的指针走到了null或者其next域为null，链表无环。
 * 其次判断环中节点个数：
 * 让指针B先走，同时设置一个计数器，每走一步计数器加一，当再次走到指针A处时，计数器的值就为环中节点个数。
 * 最后判断环的入口节点：
 * 重新初始化指针A和B，让指针B先走“环中节点个数”个节点，之后他俩同时开始移动。
 * 这样指针B和指针A再次相遇即为环的入口节点。
 * 其实原因就是用指针B去找链表的结尾，先走环的节点个数，那么他和指针A就始终相差一个环的距离。
 * 此时当他走到链表的结尾时，因为他们相差一个环的距离，所以指针A应该正好站在环的门口前。
 *
 * 这种方法和哈希表方法实现时间复杂度都是O(n)，但是该方法在空间复杂度上为O(1)，不需要额外空间。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=3
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
     * 找出链表中环的入口节点
     * @param pHead 链表
     * @return 环的入口节点（若没有则为null）
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if(pHead==null || pHead.next==null) {
            return null;
        }

        /* 每次走一步的链表指针 */
        ListNode pList = pHead;
        /* 每次走两步的链表指针 */
        ListNode nList = pHead;

        /* 确定链表中是否有环 */
        while(nList!=null && nList.next!=null) {
            nList = nList.next.next;
            pList = pList.next;

            /* 链表中有环时退出循环 */
            if(pList == nList) {
                break;
            }
        }

        /* 链表无环的情况 */
        if(pList != nList) {
            return null;
        }

        /* 计算环中有几个节点 */
        nList = nList.next;
        int count = 1;
        while(nList != pList) {
            nList = nList.next;
            count ++;
        }

        /* 让指针B先走"环中节点个数"个节点 */
        pList = pHead;
        nList = pHead;
        while(count != 0) {
            nList = nList.next;
            count --;
        }

        /* 指针AB同时行动，再次相遇的节点即为环的入口节点 */
        while(pList != nList) {
            pList = pList.next;
            nList = nList.next;
        }

        return pList;
    }
}
