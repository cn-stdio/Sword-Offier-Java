package method.basic;

/**
 * @author Seagull_gby
 * @date 2019/11/11 14:10
 * Description: 剑指Offer-面试题03-Java实现
 *
 * 问题描述：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 实现思路：
 * 考虑到所有数字都在0到n-1的范围内，所以如果数组中没有重复的数字，那么当数组排序后，数组的下标就是对应的值
 * 那么让每一个数字都放在他应该在的位置（也就是数字与下标相等的位置）
 * 这样只要出现目标数字的位置早就有了相应的值（与目标数字相等，比如1在下标2处，但是下标1处已经是正确的值1了，那么1就重复了），那么目标数字就是重复的。
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

        for(int i=0; i<length; i++) {
            /* 如果值在对应位置上，跳过本次循环看下一个值 */
            if(numbers[i] == i) {
                continue;
            } else {
                /* 如果值与对应位置上的值相等，则重复，否则交换位置，重新检测（i-1） */
                if(numbers[i]==numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[temp] = temp;
                    i --;
                }
            }
        }

        return false;
    }
}
