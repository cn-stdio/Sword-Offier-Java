/**
 * @author Seagull_gby
 * @date 2019/11/18 13:46
 * Description: 剑指Offer-面试题11-Java实现
 *
 * 问题描述：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 实现思路：
 * 考虑到旋转前数组有序，所以利用二分查找法找最小数字。
 * 每次用前指针和中指针指向的数比较，如果前比中大，则最小值可能在数组后半段，否则可能在数组前半段。
 * 这样不断二分查找，最后前后指针只相差一个数时，找到分界点，后指针所指为最小值（因为前指针指的一直都是较大的值）
 * 注意特殊情况：数组中没有元素、数组中只有一个元素、原数组中有若干个重复元素如：{1,2,2,2,2,2}。
 * 当旋转后的数组为{2,2,1,2} 时，无法判断较小值在哪里，只能用顺序查找。
 * 顺序查找的思路是：不断用前指针和后指针所指的数比较，大就让前指针指向下一个值，直到找到分界点。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Solution {

    /**
     * 找出旋转数组的最小数字
     * @param array 旋转后的数组
     * @return 数组中的最小数字
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) {
            return 0;
        }

        /* 设立两个指针，分别指向前面和后面的数组元素 */
        int start = 0;
        int end = array.length - 1;
        int mid = end / 2;

        /* 旋转了0次，也就是旋转后的数组是非递减情况 */
        if(array[start] < array[end]) {
            return array[start];
        }

        /* 如果三数相等，用顺序查找法，否则用二分查找法 */
        if(array[start]==array[mid] && array[mid]==array[end]) {
            /* 将数组前几个元素跟最后一个比较，直到找到临界点 */
            while(start!=end && array[start]>=array[end]) {
                start ++;
            }

            return array[start];
        } else {
            /* 用二分法查找数组中最小元素，后一个条件是为了排除数组中只有一个元素的情况 */
            while(start!=end-1 && start!=end) {

                /* 把数组一分为二，每次比较数组第一个元素和中间元素的值，小就在后者子数组，大就在前者子数组 */
                if(array[start] <= array[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }

                mid = (end+start) / 2;
            }

            return array[end];
        }
    }
}
