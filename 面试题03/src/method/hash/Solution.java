package method.hash;

import java.util.*;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:06
 * Description: 剑指Offer-面试题03-Java实现
 *
 * 问题描述：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 实现思路：
 * 利用哈希表作为中介来储存数组中的值，如果不存在就放进去，存在就返回。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    /**
     * 找出重复的数字
     * @param numbers 目标数组
     * @param length 数组大小
     * @param duplication 测试用例要求将重复数字放在该数组第一个位置
     * @return 是否找到重复的数字
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        /* 构建一个哈希表作为中介 */
        Map<Integer, Integer> map = new HashMap<>(length);

        /* 如果输入为空，直接返回不存在 */
        if(length == 0) {
            return false;
        }

        /* 对数组遍历，对每个值判断其在哈希表是否存在，存在就返回，不存在就保存进去 */
        for (int num : numbers) {
            if(map.containsKey(num)) {
                duplication[0] = num;
                return true;
            } else {
                map.put(num, 1);
            }
        }

        return false;
    }
}