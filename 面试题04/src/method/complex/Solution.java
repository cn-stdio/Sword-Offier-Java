package method.complex;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:12
 * Description: 剑指Offer-面试题04-Java实现
 * 问题描述：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 实现思路：
 * 以右下角为基准，遵守递增规则（下边的值大，左边的值小），先遍历最后一排，再根据递增规则按大小遍历。
 *
 * 该代码较为复杂，另一个包里有优化代码。
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
    public boolean Find(int target, int[][] array) {
        /* 得到行和列的最大下标 */
        int columnIndex = array.length - 1;
        int rowIndex = array[0].length - 1;

        /* 如果传入的二维数组为空，返回false */
        if (columnIndex == 0 && rowIndex == -1) {
            return false;
        }

        /* 如果该整数比二维数组中最大值还大，返回false */
        if (target > array[columnIndex][rowIndex]) {
            return false;
        }

        /* 遍历二维数组最后一列，直到找到大于等于该整数的值或者遍历到第一行 */
        while (target < array[columnIndex][rowIndex] && columnIndex != 0) {
            columnIndex--;
        }

        /* 如果等于就返回true，否则遍历该数所在的一维数组（所在行） */
        if (target == array[columnIndex][rowIndex]) {
            return true;
        } else {
            /* 如果不是第一行（比如小于第四行的15但是大于第三行的13），则遍历较大的数（15）所在行 */
            if (columnIndex != 0) {
                columnIndex++;
            }

            /* 从后往前遍历上述找出的数所在的一维数组（行） */
            while (target != array[columnIndex][rowIndex]) {
                rowIndex--;

                /* 该行遍历完了或者该列遍历完了还没跳出循环，证明没有相等的数，返回false */
                if (rowIndex == -1 || columnIndex > (array.length - 1)) {
                    return false;
                }

                /* 当在该行中找到小于target整数的数时，遍历该列，直到找到大于target的数 */
                while (target > array[columnIndex][rowIndex] && columnIndex <= (array.length - 1)) {
                    columnIndex++;
                }
            }

            return true;
        }
    }
}
