package method.normal;

/**
 * @author Seagull_gby
 * @date 2019/11/12 11:10
 * Description: 剑指Offer-面试题05-Java实现
 *
 * 问题描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 实现思路：
 * 设定两个指针从后往前遍历字符串（因为从前往后每个字符串要移动多次，而从后往前只需要移动一次）。
 * 先遍历字符串，统计字符串中空格的个数，以计算最终字符串的长度。
 * 设定两个指针，一个指向原字符串末尾，一个以最终字符串的长度为基准指向最终字符串末尾。
 * 从后往前将字符串的值从指针A的位置赋予指针B的位置。
 * 遇到空格后，指针B的位置赋予“%20”
 * 因为指针A和指针B中间只相差空格被替换后的位置，所以当空格替换完全时，指针A与指针B重合。
 *
 * 牛客网测试用例：
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {

    /**
     * 字符串中空格替换为"%20"
     * @param str 字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(StringBuffer str) {
        /* 构建两个指针，前者指向原来数组最后长度位置，后者指向替换后的数组长度位置 */
        int fPtr = str.length()-1;
        int sPtr = fPtr;
        /* 每遇到一个空格加2长度，最后sPtr指向的字符数组位置为替换后的长度位置 */
        for(int i=0; i<=fPtr; i++) {
            if(str.charAt(i) == ' ') {
                sPtr += 2;
            }
        }
        /* 为字符串扩容 */
        str.setLength(sPtr+1);

        /* 从后往前遍历字符串 */
        while(fPtr != sPtr) {
            /* 遇到空格就替换，否则两个指针一直往前遍历 */
            if(str.charAt(fPtr) != ' ') {
                str.setCharAt(sPtr, str.charAt(fPtr));
                fPtr --;
                sPtr --;
            } else {
                str.setCharAt(sPtr --, '0');
                str.setCharAt(sPtr --, '2');
                str.setCharAt(sPtr --, '%');

                fPtr --;
            }
        }

        return str.toString();
    }
}
