package subject.first.normal;

/**
 * @author Seagull_gby
 * @date 2019/11/14 16:08
 * Description: 剑指Offer-面试题10-Java实现
 *
 * 问题描述：
 * 题目一：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 实现思路：
 * 用三个变量，两个变量分别是数列的第一项和第二项，另外一个变量保存下一项的值，从下往上推。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Solution {
    /**
     * 斐波那契数列循环解法
     * @param n 数列第n项
     * @return 数列第n项的值
     */
    public int Fibonacci(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("请传入一个非负数。");
        }

        if(n <= 1) {
            return n;
        }

        int fA = 0;
        int fB = 1;
        int fTmp = -1;
        /* 因为一开始已经有2个数了，初始值为0，所以以 1 为判断条件 */
        while(n != 1) {
            n --;

            fTmp = fA + fB;
            fA = fB;
            fB = fTmp;
        }
        
        return fTmp;
    }
}
