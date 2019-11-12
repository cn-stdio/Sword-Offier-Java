package method.recursion;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:31
 * Description: 剑指Offer-面试题25-Java实现
 * 问题描述：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 实现思路：
 * 利用递归的思想，每次递归比较两链表对应指针节点的值，并将较小的一方加在新链表的后面。
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
        /* 基准情况，递归遍历直到一方为null */
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        /* 新建最终链表保存结果 */
        ListNode finalList = null;
        /* 对于每一次遍历的每一个节点来说，最终链表指针永远指向较小的一方 */
        if(list1.val < list2.val){
            finalList = list1;
            finalList.next = Merge(list1.next,list2);
        }else{
            finalList = list2;
            finalList.next = Merge(list1,list2.next);
        }
        return finalList;
    }
}
