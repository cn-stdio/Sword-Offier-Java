package method.easy;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:12
 * Description: 剑指Offer-面试题04-Java实现
 * 问题描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 实现思路：
 * 以右上角为基准，根据递增规则（下边的值大，左边的值小）按大小遍历，传入的整数大就往下，小就往左。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    /**
     * 判断二维数组中是否有某整数
     * @param target 目标整数
     * @param array 二维数组
     * @return 判断结果
     */
    public boolean Find(int target, int [][] array) {
        /* 判断传入数组是否为空 */
        if (array == null) {
            return false;
        }

        /* 列的最大下标，因为从右上角开始遍历，所以行下标设置为0 */
        int rowIndex = 0;
        int columnIndex = array[0].length - 1;

        /* 从右上角开始遍历二维数组，因为下大左小的性质，遇见比整数大的数就往左，小就往下 */
        while (rowIndex<array.length && columnIndex>=0) {
            if (target == array[rowIndex][columnIndex]) {
                return true;
            } else if (target < array[rowIndex][columnIndex]) {
                columnIndex --;
            } else {
                rowIndex ++;
            }
        }

        return false;
    }
}

