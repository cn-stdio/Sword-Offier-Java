package subject.second.recursion;

/**
 * @author Seagull_gby
 * @date 2019/11/14 16:39
 * Description: 剑指Offer-面试题10-Java实现
 *
 * 问题描述：
 * 题目二：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 实现思路：
 * 有两种跳法，一阶或是两阶。
 * 如果第一次跳一阶，那么就剩下n-1阶阶梯，传入f(n-1)让这n-1阶阶梯重复判断跳1还是2
 * 如果第一次跳两阶，那么就剩下n-2阶阶梯，传入f(n-2)让这n-2阶阶梯重复判断跳1还是2
 * 每次选择都包含在上述两者之中，所以最终的数目为 f(n-1)+f(n-2)，典型的斐波那契数列。
 * 代码为递归解法。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Solution {
    /**
     * 跳台阶递归解法
     * @param target 台阶数目
     * @return 一共多少种方法
     */
    public int JumpFloor(int target) {
        if(target <= 0) {
            throw new IllegalArgumentException("请传入一个正数。");
        }

        /* 基准条件，跳1阶有1种，2阶阶梯有2种 */
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }

        return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
