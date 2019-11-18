package subject.first.recursion;

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
 * 斐波那契数列递归解法，基准条件为0和1，每次递归调用下两项相加，直到0和1。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Solution {
    /**
     * 斐波那契数列递归解法
     * @param n 数列第n项
     * @return 数列第n项的值
     */
    public int Fibonacci(int n) {

        /* 基准条件，最开始的两个数为0和1 */
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        /* 每次递归使下两项相加 */
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
