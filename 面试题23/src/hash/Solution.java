package hash;

import java.util.HashMap;

/**
 * @author Seagull_gby
 * @date 2019/11/18 20:36
 * Description: 剑指Offer-面试题23-Java实现
 *
 * 问题描述：
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 实现思路：
 * 用哈希表来储存节点，值为节点出现次数，当第一个节点出现次数为2的节点即为环的入口节点。
 *
 * 这种方法时间复杂度为O(n)达到了最优，但是需要额外空间，不如另一种实现。
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

        /* 初始化一个额外的哈希表来储存节点 */
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(pHead != null) {
            /* 如果包含该节点，则返回，该节点就是环入口 */
            if(map.containsKey(pHead)) {
                return pHead;
            } else {
                map.put(pHead, 0);
                pHead = pHead.next;
            }
        }

        return null;
    }
}
